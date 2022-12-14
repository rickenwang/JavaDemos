package com.demo.collections;

// Created at 2022/12/11 3:34 PM

// 知识点: 
// CopyOnWriteArrayList 即写时复制数组，在容器发生变更时，将数据拷贝到一个新的数组，
// 然后在新容器里变更，最后将旧容器的引用指向新容器。
// 通过与ReentrantLock搭配实现线程安全。而对于容器的读是直接读取当前容器是无锁操作。
// 同时 volatile 保证 array 数据能及时同步到其他线程中。

// 分析: 
// 核心的数据结构是两个：
// - ReentrantLock lock
// - transient volatile Object[] array;  transient 修饰的字段表示不能被 Serializable 序列化
//
// 写操作：
// 1. 不管是 add 还是 remove，写操作需要获取 lock 锁，
//
// 读操作：
// 1. 读是没有锁的

// 问题: 
// 1. 既然写的时候已经通过 lock 加锁了，那么为什么还需要拷贝数据？
// 虽然写锁了，但是读没加锁，如果在修改的时候不拷贝数据，那么仍然可能
// 读到脏数据。
//
//

// 使用场景：
// 1. CopyOnWriteList 适合并发情况下读多写少的场景。

import com.demo.Person;

import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo {

    private CopyOnWriteArrayList<Person> persons = new CopyOnWriteArrayList<>();

    public static void main(String[] args) {
        CopyOnWriteArrayListDemo test = new CopyOnWriteArrayListDemo();
    }

    //
    public void testAdd(Person person) {
        persons.add(person);
    }

    public void testRemove() {
        persons.remove(0);
    }

    public void testGet() {
        persons.get(0);
    }

}
