package com.demo.thread.demo;

// Created at 2022/12/12 12:11 PM

// 知识点:
// AQS 也叫抽象队列同步器，也是在 CAS 能力上的二次封装。
// AQS 的原理就是 CAS + 缓存队列，同一个资源只能有一个线程持有，
// 1. 线程在获取资源时，会先通过 CAS 判断持有线程是否为空，为空则持有；
// 2. 如果当前资源已经被持有了，那么会通过 CAS 的 park 方法阻塞当前线程；
// 很多并发相关的类都是基于 AQS 的，比如：
// - CountDownLatch：可以用于等待多个任务全部完成；
// - Semaphore：可以用于并发控制；
// - ReentrantLock：
// - ReentrantReadWriteLock
// 等并发工具，均是借助AQS完成他们的所需要的锁分配问题。

// 分析: 
// 

// 问题: 
// 

// 使用场景：
// 

// 参考：
// 掘金 - 一文了解 AQS：https://juejin.cn/post/6948030364321333262

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

public class AQSDemo {

    public static void main(String[] args) {
        AQSDemo test = new AQSDemo();

        AbstractQueuedSynchronizer abstractQueuedSynchronizer ;
        CountDownLatch countDownLatch;
        Semaphore semaphore;
        ReentrantLock reentrantLock;
    }

    public int add(int a, int b) {
        return a+b;
    }
}
