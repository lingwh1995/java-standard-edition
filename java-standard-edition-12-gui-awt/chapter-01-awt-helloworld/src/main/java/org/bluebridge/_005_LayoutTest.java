package org.bluebridge;

import javax.swing.*;
import java.awt.*;

/**
 * @author lingwh
 * @desc 布局测试程序
 * @date 2025/1/26 16:32
 */
public class _005_LayoutTest {

    public static void main(String[] args) {
        // 使用 invokeLater 将 UI 任务推送到事件分发线程 (EDT) - lambda 表达式调用
        // SwingUtilities.invokeLater(() -> new _005_LayoutTest().createAndShowGUI());

        // 使用 invokeLater 将 UI 任务推送到事件分发线程 (EDT) - 方法引用调用
        SwingUtilities.invokeLater(new _005_LayoutTest()::createAndShowGUI);
    }

    /**
     * 创建并显示 GUI
     */
    private void createAndShowGUI() {
        // 创建窗体
        Frame frame = new Frame();

        // 设置窗体位置和尺寸
        frame.setBounds(500, 500, 500, 300);

        // 使用边界布局
        frame.setLayout(new BorderLayout());
        frame.add(new Button("button1"), BorderLayout.WEST);  //在添加组件时，可以在后面加入约束
        frame.add(new Button("button2"), BorderLayout.EAST);
        frame.add(new Button("button3"), BorderLayout.SOUTH);
        frame.add(new Button("button4"), BorderLayout.NORTH);
        frame.add(new Button("button5"), BorderLayout.CENTER);

        // 设置窗体可见
        frame.setVisible(true);
    }

}
