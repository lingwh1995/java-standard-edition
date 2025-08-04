package org.bluebridge;

import javax.swing.*;
import java.awt.*;
/**
 * @author lingwh
 * @desc
 * @date 2025/8/4 18:24
 */
public class SwingLayouts {
    public static void main(String[] args) {
        JFrame frame = new JFrame("布局管理器示例");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // 使用选项卡展示不同布局
        JTabbedPane tabbedPane = new JTabbedPane();

        // BorderLayout示例
        JPanel borderPanel = new JPanel(new BorderLayout());
        borderPanel.add(new JButton("北"), BorderLayout.NORTH);
        borderPanel.add(new JButton("南"), BorderLayout.SOUTH);
        borderPanel.add(new JButton("西"), BorderLayout.WEST);
        borderPanel.add(new JButton("东"), BorderLayout.EAST);
        borderPanel.add(new JButton("中"), BorderLayout.CENTER);
        tabbedPane.addTab("BorderLayout", borderPanel);

        // FlowLayout示例
        JPanel flowPanel = new JPanel(new FlowLayout());
        for (int i = 1; i <= 10; i++) {
            flowPanel.add(new JButton("按钮" + i));
        }
        tabbedPane.addTab("FlowLayout", flowPanel);

        // GridLayout示例
        JPanel gridPanel = new JPanel(new GridLayout(3, 3));
        for (int i = 1; i <= 9; i++) {
            gridPanel.add(new JButton("格子" + i));
        }
        tabbedPane.addTab("GridLayout", gridPanel);

        frame.add(tabbedPane);
        frame.setVisible(true);
    }
}
