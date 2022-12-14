package com.demo.asm;

// Created at 2022/12/13 8:44 PM

// 知识点: 
// 通过 asm 修改属性

// 分析: 
// 

// 问题: 
// 

// 使用场景：
// 

// 参考：
// https://www.baeldung.com/java-asm

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;

import static org.objectweb.asm.Opcodes.ASM9;

public class AddFieldVisitor extends ClassVisitor {

    private String fieldName;
    private String fieldType;
    private int access = org.objectweb.asm.Opcodes.ACC_PUBLIC;
    private boolean isFieldPresent;

    protected AddFieldVisitor(String fieldName, int fieldAccess, String fieldType, ClassVisitor classWriter) {
        super(ASM9, classWriter);
        this.fieldName = fieldName;
        this.fieldType = fieldType;
        this.access = fieldAccess;
    }

    @Override
    public FieldVisitor visitField(int access, String name, String descriptor, String signature, Object value) {
        // 是否已经存在需要添加的 field
        if (name.equals(fieldName)) {
            isFieldPresent = true;
        }
        return cv.visitField(access, name, descriptor, signature, value);
    }

    /**
     * 这个方法是最后调用的
     */
    @Override
    public void visitEnd() {

        // 在这里添加一个新的 field
        if (!isFieldPresent) {
            // 这里的 cv 其实就是一个 ClassWriter，ClassWriter 在调用
            // visitField 的时候其实就是添加这个属性
            //
            FieldVisitor fv = cv.visitField(
                    access, fieldName, fieldType, null, null);
            // 这里重新调用 fv 的 visitEnd，表示完成了属性的访问
            if (fv != null) {
                fv.visitEnd();
            }
        }
        cv.visitEnd();
    }


}
