package com.ambity.jvmlearn.broker;

import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

@Component
public class LifeStyleTest implements SmartLifecycle {
    @Override
    public boolean isAutoStartup() {
        return true;
    }

    @Override
    public void stop(Runnable callback) {

    }

    @Override
    public void start() {
        System.out.println("------------------------------------start-------------------------------------");
    }

    @Override
    public void stop() {
        System.out.println("------------------------------------stop-------------------------------------");

    }

    @Override
    public boolean isRunning() {
        return false;
    }

    @Override
    public int getPhase() {
        return 0;
    }
}
