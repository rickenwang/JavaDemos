package com.demo.thread.problem;

// Created at 2022/11/12 8:53 PM
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
// 

import java.util.concurrent.Semaphore;

public class 三个线程交替打印ABC {

    public static void main(String[] args) {
        三个线程交替打印ABC test = new 三个线程交替打印ABC();
        Semaphore semaphoreA = new Semaphore(1);
        Semaphore semaphoreB = new Semaphore(0);
        Semaphore semaphoreC = new Semaphore(0);


        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int i = 20;
                    while (i-->0) {
                        semaphoreA.acquire();
                        test.print();
                        semaphoreB.release();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }, "A");

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int i = 20;
                    while (i-->0) {
                        semaphoreB.acquire();
                        test.print();
                        semaphoreC.release();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }, "B");

        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int i = 20;
                    while (i-->0) {
                        semaphoreC.acquire();
                        test.print();
                        semaphoreA.release();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }, "C");

        threadA.start();
        threadB.start();
        threadC.start();
    }

    void print() {

        System.out.println(Thread.currentThread().getName());
    }


}
