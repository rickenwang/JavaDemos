package com.demo.thread.demo;

// Created at 2022/12/11 4:51 PM

// 知识点: 
// AtomicXxx 依赖于 Unsafe 类提供的 CAS 能力；

// 分析: 
// 

// 问题: 
// 

// 使用场景：
// 非常适合多线程计数

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {

    public static void main(String[] args) {
        AtomicDemo test = new AtomicDemo();

        AtomicInteger atomicInteger = new AtomicInteger(1);
        atomicInteger.incrementAndGet();
    }


    // 控制 running 状态下的 task 不超过指定值
    static class TaskManager {

        private int max = 5;

        TaskManager(int max) {
            this.max = max;
        }

    }


    static class Task {


    }

}
