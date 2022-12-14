package com.demo.unsafe;

// Created at 2022/12/11 5:00 PM

// 知识点: 
// Unsafe 可以提供一些提升Java运行效率但也有安全风险的一些接口，
// 我们对 Unsafe 的使用一定要慎重，接口主要包含如下几种类型：
// - 内存操作
// - CAS：
// - Class相关
// - 对象操作
// - 线程调度
// - 系统信息获取
// - 内存屏障
// - 数组操作等几类

// 分析: 
// 1、CAS 操作
// CAS 操作的典型应用在 AtomicInteger 上，比如
// -> AtomicInteger.getAndIncrement()
// -> unsafe.getAndAddInt(object, offset, 1);
// -> unsafe.compareAndSwapInt
// -> compareAndSwapInt(object, offset, expected, x);
//
// 2、线程调度
// 典型应用在 AQS 上
// void park(isAbsolute, time)  阻塞当前线程一段时间
// void unpark(thread) 解除当前线程阻塞
//

// 问题: 
// 1. 如何获得 Unsafe 实例？
// 可以通过反射来获取实例

// 使用场景：
//

// 参考：
// - Unsafe JDK 源码：http://hg.openjdk.java.net/jdk7/jdk7/jdk/file/9b8c96f96a0f/src/share/classes/sun/misc/Unsafe.java
// - 美团技术 - Unsafe 类解析：https://tech.meituan.com/2019/02/14/talk-about-java-magic-class-unsafe.html
//

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicInteger;

public class UnsafeDemo {

    public static void main(String[] args) {
        UnsafeDemo test = new UnsafeDemo();

        Unsafe unsafe = reflectGetUnsafe();

        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.getAndIncrement();
    }

    private static Unsafe reflectGetUnsafe() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (Exception e) {
            return null;
        }
    }
}
