package com.ambity.zookeeper;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.state.ConnectionState;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ZookeeperClientTest {
    private static final String CONNECT_STR = "10.238.148.105:2181";
    private static final int sessionTimeoutMs = 60*1000;
    private static final int connectionTimeoutMs = 5000;
    private static CuratorFramework curatorFramework;

    @Before
    public void init() {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(5000, 30);
        curatorFramework = CuratorFrameworkFactory.builder().connectString(getConnectStr())
                .retryPolicy(retryPolicy)
                .sessionTimeoutMs(sessionTimeoutMs)
                .connectionTimeoutMs(connectionTimeoutMs)
                .canBeReadOnly(true)
                .build();
        curatorFramework.getConnectionStateListenable().addListener((client, newState) -> {
            if (newState == ConnectionState.CONNECTED) {
                System.out.println("连接成功！");
            }

        });
        System.out.println("连接中......");
        curatorFramework.start();
    }

    public void createIfNeed(String path) throws Exception {
        Stat stat = curatorFramework.checkExists().forPath(path);
        if (stat==null){
            String s = curatorFramework.create().forPath(path);
//            log.info("path {} created! ",s);
        }
    }

    public static CuratorFramework getCuratorFramework() {
        return curatorFramework;
    }

    @After
    public void test(){
        try {
            TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    protected   String getConnectStr(){
        return CONNECT_STR;
    }
    @Test
    public void printNodeData() throws Exception {
        CuratorFramework curatorFramework = getCuratorFramework();
        byte[] bytes = curatorFramework.getData().forPath("/zk-node");
        System.out.println(new String(bytes));
    }
}
