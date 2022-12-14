package com.demo.cls;

// Created at 2022/11/20 4:26 PM
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

import java.util.LinkedList;
import java.util.List;

public class InternalClass {

    public static void main(String[] args) {
        InternalClass test = new InternalClass();
        List<?> myList = new LinkedList<>();
        List<? extends Object> myList3 = myList;
    }


}
