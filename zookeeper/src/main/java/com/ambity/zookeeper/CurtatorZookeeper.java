package com.ambity.zookeeper;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.curator.framework.state.ConnectionState;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CurtatorZookeeper {
    private static CuratorFramework curatorFramework;
    @Before
    public void init() throws IOException, InterruptedException {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        curatorFramework = CuratorFrameworkFactory.builder()
                .connectString("10.238.148.105:2181")
                .sessionTimeoutMs(5000)  // 会话超时时间
                .connectionTimeoutMs(5000) // 连接超时时间
                .retryPolicy(retryPolicy).canBeReadOnly(true)
                .build();
        curatorFramework.getConnectionStateListenable().addListener((client, newState) -> {
            if (newState == ConnectionState.CONNECTED) {
                System.out.println("连接成功！");
            }
        });
        System.out.println("开始连接");
        curatorFramework.start();
    }
    @Test
    public void testCreate() throws Exception {
        byte[] bytes = curatorFramework.getData().forPath("/zk-node");

//        String path = curatorFramework.create().forPath("/curator-node");
        // curatorFramework.create().withMode(CreateMode.PERSISTENT).forPath("/curator-node","some-data".getBytes())
        System.out.println(new String(bytes));
        CuratorCache curatorCache = CuratorCache.build(curatorFramework,"/zk-node");
        curatorCache.listenable().addListener(new CuratorCacheListener() {
            @Override
            public void event(Type type, ChildData oldData, ChildData data) {
                System.out.println(type);
            }
        });
    }
    @After
    public void test(){
        try {
            TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
