package com.demo.thread.problem;

// Created at 2022/11/12 9:25 PM
// Recommend time: 1 Hour
// Actual time: 
// Link: 
// Difficulty: 
// Tag: 

// Title: 
// 

// Example: 
// 

// Resolve: 
// 首先要理解 notifyAll 和 wait 的意义
// notifyAll 表示唤醒等待该锁导致的 WAITING 状态线程
// wait 表示自己释放锁，并进入 WAITING 状态
//

public class 两个线程交替打印AB {

    public static void main(String[] args) {
        两个线程交替打印AB test = new 两个线程交替打印AB();
        Object lock = new Object();

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 50;
                while (i-- > 0) {
                    synchronized (lock) {
                        test.print();
                        // 注意是 lock.notifyAll()，而不是 notifyAll()
                        lock.notifyAll();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }, "A");

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 50;
                while (i-- > 0) {
                    // System.out.println(Thread.currentThread().getState());
                    synchronized (lock) {
                        test.print();
                        System.out.println(threadA.getState());
                        lock.notifyAll();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }, "B");

        threadA.start();
        threadB.start();
    }

    void print() {
        System.out.println(Thread.currentThread().getName());
    }
}
