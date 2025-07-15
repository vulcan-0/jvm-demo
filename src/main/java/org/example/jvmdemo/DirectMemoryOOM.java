package org.example.jvmdemo;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 直接内存溢出
 * java -cp . -XX:MaxDirectMemorySize=1M -XX:+HeapDumpOnOutOfMemoryError org.example.jvmdemo.DirectMemoryOOM
 * 极其危险，内存没有溢出，电脑卡死了
 *
 * @author lxc
 * @date 2025/7/15
 */
public class DirectMemoryOOM {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws Exception {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }

}
