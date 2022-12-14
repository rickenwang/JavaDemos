package com.demo.javapoet;

// Created at 2022/12/13 11:21 AM

// 知识点: 
// JavaPoet 是 square 公司开发的 Java 文件生成框架。
// 可以在编译期动态生成源文件，但是无法修改现有的源文件
// 或者 class 文件。

// 分析: 
//

// 问题: 
// 

// 使用场景：
// 

// 参考：
//

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.Modifier;
import java.io.File;
import java.io.IOException;


public final class JavaPoetDemo {
    public static void main(String[] args) {
        System.out.println("Hello, JavaPoet!");
        test();
    }

    public static void test() {

        // 定义方法
        MethodSpec main = MethodSpec.methodBuilder("main")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .returns(void.class)
                .addParameter(String[].class, "args")
                // 这里定义 T (Type)，会自动在 import 中导入
                .addStatement("$T.out.println($S)", System.class, "Hello, JavaPoet!")
                .build();

        // 定义类，并将方法添加到类上
        TypeSpec helloWorld = TypeSpec.classBuilder("HelloWorld")
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .addMethod(main)
                .build();

        // 将类保存到 JavaFile 上
        JavaFile javaFile = JavaFile.builder("com.example.helloworld", helloWorld)
                .build();

        try {
            // javaFile.writeTo(System.out);
            // 包名和文件名都已经指定了，这里只需要父目录文件即可
            javaFile.writeTo(new File("src"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
