package org.example.jvmdemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 元空间溢出
 * java -cp . -XX:MetaspaceSize=1M -XX:MaxMetaspaceSize=1M -XX:+HeapDumpOnOutOfMemoryError org.example.jvmdemo.MetaspaceOOM
 *
 * @author lxc
 * @date 2025/7/15
 */
public class MetaspaceOOM {

    public static void main(String[] args) {
        int i = 0;
        try {
            while (true) {
                // 使用JDK动态代理生成类
                ClassLoader loader = new ClassLoader() {};
                Class<?>[] interfaces = new Class<?>[]{Runnable.class};
                InvocationHandler handler = (proxy, method, args1) -> null;

                Proxy.newProxyInstance(loader, interfaces, handler);
                i++;

                // 每1000次打印一次进度
                if (i % 1000 == 0) {
                    System.out.println("已生成代理类: " + i);
                }
            }
        } catch (Throwable e) {
            System.out.println("动态生成类次数: " + i);
            throw e;
        }
    }

}
