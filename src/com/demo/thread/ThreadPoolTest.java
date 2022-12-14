package com.demo.thread;

import java.util.concurrent.*;

public class ThreadPoolTest {


    public static void main(String[] args) {


        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                1, 2, 2000, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(1)
        );

        // 1. 如果任务数小于 core 值，会创建新线程来执行；
        // 2. 如果任务数大于 core，会将任务放到任务队列中；
        // 3. 如果队列满了，则会新建非核心线程来执行任务；
        // 4. 如果线程数达到了最大限制，则会调用拒绝策略


       // executor.execute();
    }

    class Task implements Runnable {

        @Override
        public void run() {

        }
    }

}
