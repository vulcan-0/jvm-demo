package org.example.jvmdemo;

import java.util.HashMap;
import java.util.Map;

/**
 * 垃圾回收开销过大
 * java -cp . -Xms10m -Xmx10m -XX:+UseParallelGC -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError org.example.jvmdemo.GCOverheadOOM
 *
 * @author lxc
 * @date 2025/7/15
 */
public class GCOverheadOOM {

    public static void main(String[] args) {
        Map<Key, String> map = new HashMap<>();
        while (true) {
            for (int i = 0; i < 10000; i++) {
                if (!map.containsKey(new Key(i)))
                    map.put(new Key(i), "Number:" + i);
            }
        }
    }

    static class Key {

        Integer id;

        public Key(Integer id) {this.id = id;}

        @Override
        public int hashCode() {
            return id.hashCode();
        }

    }

}
