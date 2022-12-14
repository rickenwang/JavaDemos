package com.demo.genericity;

// Created at 2022/12/3 9:44 PM
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

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GenericityDemo {

    public static void main(String[] args) {
        GenericityDemo test = new GenericityDemo();

        // Java语言的泛型实现方式是擦除法
        //

        // list由于是在运行时创建的对象所以由于泛型擦除是无法获取泛型信息的，
        // 因为运行时对象本质是方法的调用(真正调用了以后才会创建)，
        // 在运行时创建的对象是没有办法通过反射获取其中的类型的。
        List<Integer> list1 = new ArrayList<>();
        Type type1 = list1.getClass().getGenericSuperclass(); //获取不到泛型信息
        System.out.println(type1.toString());

        // 第二个是可以获取的，因为后边加了{}，这就使得这个list成为了一个匿名内部类且父类是List，
        // 子类是可以调用父类的构造方法的，加了之后这个list1就不是运行时创建的对象了而是编译时创建的，
        // 所以是可以获取泛型类型的。
        List<Integer> list2 = new ArrayList() {};

        Type type2 = list2.getClass().getGenericSuperclass(); //可以获取到泛型信息
        System.out.println(type2.toString());

        test.decode("json");
    }

    public void decode(String str) {
        List<Data> list1 = new ArrayList<>();
        List<Data> list2 = new ArrayList<Data>(){};
        decode(str, list2);

        System.out.println(list2);
    }

    public <T> void decode(String str, List<T> list) {
        // 能否把 s 中的 内容解析到 list 里，如果不能，为什么？
        // 如果不能，如果本方法签名不改，有做到的办法吗？

        // 通过 Gson 很容易就解决了
        // List<T> data = new Gson().fromJson(str, list.getClass().getGenericSuperclass());

        try {
            // ArrayList<Data> 的 type
            ParameterizedType parameterizedType = (ParameterizedType) list.getClass().getGenericSuperclass();

            // ArrayList 的 type，实际为 Class 类型
            Type rawType = parameterizedType.getRawType();
            // T 的 type，实际为 Class 类型
            Type[] argsTypes = parameterizedType.getActualTypeArguments();

            // 将 类型为 T 的 type 强转为 Class<T>
            Class<T> classT = (Class<T>)argsTypes[0];

            // 生成类型为 T 的 instance 实例
            T ins = classT.newInstance();

            System.out.println(classT.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    static class Data {
        String key;
        String value;
    }

    static class MyData extends ArrayList<Data> {
    }

    static class TypeAdapter<T> {

        public void write(String s, T value) {

        }

        public T read(String s) {
            return null;
        }
    }

}
