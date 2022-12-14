package com.demo.asm;

// Created at 2022/12/13 2:11 PM

// 知识点: 
// Event-based
// 1. ClassReader：用于读取 class 文件
// 2. ClassVisitor：用于修改 class 文件
// 3. ClassWriter：输出修改后的 class 文件
//
// 我们可以依次收到如下回调：
// - visit
// - visitSource?
// - visitOuterClass?
// - (visitAnnotation | visitAttribute)*
// - (visitInnerClass | visitField | visitMethod)*
// - visitEnd
//
// tree-based
//

// 分析: 
// 

// 问题: 
// 

// 使用场景：
// 

// 参考：
//

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
import org.apache.commons.io.FileUtils;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import java.io.File;
import java.io.IOException;

public class ASMDemo {
    ASMDemo() throws IOException {


    }

    // 给 com.demo.Person 类添加一个 mNickName 字段
    public void addField() throws IOException {

        ClassReader classReader = new ClassReader("com.demo.Person");
        ClassWriter classWriter = new ClassWriter(classReader, 0);

        AddFieldVisitor addFieldVisitor = new AddFieldVisitor(
                "mNickName",
                org.objectweb.asm.Opcodes.ACC_PUBLIC,
                Type.String.getClassName(),
                classWriter);

        classReader.accept(addFieldVisitor, 0);
        byte[] bytes = classWriter.toByteArray();

        FileUtils.writeByteArrayToFile(new File("Person.class"), bytes);
    }



    public static void main(String[] args) {
        try {
            ASMDemo test = new ASMDemo();
            test.addField();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
