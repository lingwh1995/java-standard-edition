package org.bluebridge;

import javax.swing.*;

public class HelloWorld {
    private void createAndShowGUI() {
        // 创建 JFrame 实例
        JFrame frame = new JFrame("Simple Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // 添加一个最简单的按钮
        JButton button = new JButton("Click Me!");
        frame.add(button);

        // 显示窗口
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // 确保创建和更新 GUI 的操作在事件调度线程上执行
        SwingUtilities.invokeLater(() -> new HelloWorld().createAndShowGUI());
    }
}