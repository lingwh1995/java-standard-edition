package org.bluebridge;

import javax.swing.*;

/**
 * @author lingwh
 * @desc Swing HelloWorld程序
 * @date 2025/8/4 18:17
 */
public class _001_HelloWorld {

    public static void main(String[] args) {
        // 使用 invokeLater 将 UI 任务推送到事件分发线程 (EDT)
        // SwingUtilities.invokeLater(() -> new HelloWorld().createAndShowGUI());

        // 使用 invokeLater 将 UI 任务推送到事件分发线程 (EDT)
        SwingUtilities.invokeLater(new _001_HelloWorld()::createAndShowGUI);
    }

    /**
     * 创建并显示 GUI
     */
    private void createAndShowGUI() {
        // 创建 JFrame 实例
        JFrame frame = new JFrame("Swing HelloWorld");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        // 让窗口居中显示
        frame.setLocationRelativeTo(null);

        // 添加一个最简单的按钮
        JButton button = new JButton("点击我");
        // 添加点击事件
        button.addActionListener(e -> JOptionPane.showMessageDialog(frame, "按钮被点击了!"));
        frame.add(button);

        // 显示窗口
        frame.setVisible(true);
    }

}