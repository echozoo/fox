package com.echozoo.fox;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;

/**
 * TODO
 *
 * @author dujf
 * @version 1.0
 * @date 2022/12/14 17:02
 */

public class DeadLockTest {

    private final Object lockA = new Object();
    private final Object lockB = new Object();


    @Test
    public void testDeadLock() {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println("准备获取A lock");
            synchronized (lockA) {
                System.out.println("成功获取A lock");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("准备获取b lock");
                synchronized (lockB) {
                    System.out.println("成功获取B lock");
                }
            }
        });

        CompletableFuture<Void> futureB = CompletableFuture.runAsync(() -> {
            System.out.println("准备获取B lock");
            synchronized (lockB) {
                System.out.println("成功获取B lock");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("准备获取A lock");
                synchronized (lockA) {
                    System.out.println("成功获取A lock");
                }
            }
        });

        System.out.println("主线程执行开始");
        final CompletableFuture<Void> all = CompletableFuture.allOf(future, futureB);
        all.join();
        System.out.println("主线程执行结束");
    }
}
