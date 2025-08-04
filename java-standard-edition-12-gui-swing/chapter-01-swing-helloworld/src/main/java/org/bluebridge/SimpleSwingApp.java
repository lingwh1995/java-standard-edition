package org.bluebridge;

import javax.swing.*;
import java.awt.event.*;
/**
 * @author lingwh
 * @desc
 * @date 2025/8/4 18:11
 */
public class SimpleSwingApp {
    public static void main(String[] args) {
        // 创建主窗口
        JFrame frame = new JFrame("我的第一个Swing应用");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // 创建组件
        JLabel label = new JLabel("欢迎使用Swing!", JLabel.CENTER);
        JButton button = new JButton("点击我");

        // 添加事件监听器
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "按钮被点击了!");
            }
        });

        // 布局管理
        frame.setLayout(new java.awt.BorderLayout());
        frame.add(label, java.awt.BorderLayout.CENTER);
        frame.add(button, java.awt.BorderLayout.SOUTH);

        // 显示窗口
        frame.setVisible(true);
    }
}
