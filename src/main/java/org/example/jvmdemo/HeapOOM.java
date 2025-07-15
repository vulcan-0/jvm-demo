package org.example.jvmdemo;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆内存溢出
 * java -cp . -Xms10m -Xmx10m -XX:+HeapDumpOnOutOfMemoryError org.example.jvmdemo.HeapOOM
 *
 * @author lxc
 * @date 2025/7/15
 */
public class HeapOOM {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        List<byte[]> list = new ArrayList<>();
        while (true) {
            list.add(new byte[_1MB]);
        }
    }

}
