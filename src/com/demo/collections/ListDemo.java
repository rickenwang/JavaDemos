package com.demo.collections;

// Created at 2022/11/21 2:24 PM
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

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListDemo {

    public static void main(String[] args) {
        ListDemo test = new ListDemo();

        List<String> list = new LinkedList<>();
        list.add("2");
        list.add("2");
        list.add("3");
        test.safeDeleteIfEquals2(list);
        System.out.println(list.size());
    }

    void deleteIfEquals2(List<String> list) {
        for (String s: list) {
            if (s.equals("2")) {
                list.remove(s);
            }
        }
    }

    void safeDeleteIfEquals2(List<String> list) {
        Iterator<String> iter = list.listIterator();
        while (iter.hasNext()) {
            if (iter.next().equals("2")) {
                iter.remove();
            }
        }
    }

}
