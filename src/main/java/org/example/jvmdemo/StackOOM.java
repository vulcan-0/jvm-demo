package org.example.jvmdemo;

/**
 * 栈溢出
 * java -cp . -Xss160k org.example.jvmdemo.StackOOM
 *
 * @author lxc
 * @date 2025/7/15
 */
public class StackOOM {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        StackOOM oom = new StackOOM();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("栈深度: " + oom.stackLength);
            throw e;
        }
    }

}
