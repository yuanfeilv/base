package com.ambity.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class RedisLock {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     *
     * @param lockKey 想要加锁的key
     * @param expireTime redis 分布式锁的过期时间，单位为毫秒，锁时间一定要合适
     * @return
     */
    public boolean lock(String lockKey,long expireTime){
        String setnxValue = String.valueOf(System.currentTimeMillis()+expireTime);
        if (stringRedisTemplate.opsForValue().setIfAbsent(lockKey,setnxValue)){
            // 如果设置成功，则 说明没有其他线程设置，加锁成功返回
            return true;
        }
        // 获取当前redis 的值
        String redisLockKeyValue = stringRedisTemplate.opsForValue().get(lockKey);
        // 如果redis 的值小于 当前系统时间，说明有锁过期的情况，此时如果getset 命令的结果和原来的值相同
        // 说明是当前线程加锁成功，返回true
        if (System.currentTimeMillis()>Long.valueOf(redisLockKeyValue)&&redisLockKeyValue.equals(stringRedisTemplate.opsForValue().getAndSet(lockKey,setnxValue))){
            return true;
        }
        return false;
    }

    public boolean unlock(String lockKey,String expireValue){
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del',KEYS[1]) else return 0 end ";        DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>(script,Long.class);
        // 参数一：redisScript，参数二：key列表，参数三：arg（可多个）
        Long result = stringRedisTemplate.execute(redisScript, Collections.singletonList(lockKey),expireValue);
        return result==1L;
    }
}
