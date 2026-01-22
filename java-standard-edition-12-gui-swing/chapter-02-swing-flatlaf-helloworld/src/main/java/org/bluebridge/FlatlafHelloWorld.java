package org.bluebridge;

import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;

/**
 * @author lingwh
 * @desc
 * @date 2026/1/22 15:02
 */
public class FlatlafHelloWorld {

    public static void main(String[] args) {
        // 关键：启用 FlatLaf 主题
        FlatDarkLaf.setup();

        // 然后启动你的 Swing 窗口
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Swing FlatLaf App");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.add(new JButton("这是一个现代感的按钮"));
            frame.setVisible(true);
        });
    }

}
