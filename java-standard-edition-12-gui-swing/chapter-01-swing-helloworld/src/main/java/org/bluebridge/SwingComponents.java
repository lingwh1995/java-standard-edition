package org.bluebridge;

import javax.swing.*;
import java.awt.*;

/**
 * @author lingwh
 * @desc
 * @date 2025/8/4 18:17
 */
public class SwingComponents {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Swing组件示例");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // 文本框
        JTextField textField = new JTextField("文本框", 15);

        // 文本区域
        JTextArea textArea = new JTextArea("多行文本区域", 5, 20);
        JScrollPane scrollPane = new JScrollPane(textArea);

        // 复选框
        JCheckBox checkBox = new JCheckBox("复选框");

        // 单选按钮
        JRadioButton radio1 = new JRadioButton("选项1");
        JRadioButton radio2 = new JRadioButton("选项2");
        ButtonGroup group = new ButtonGroup();
        group.add(radio1);
        group.add(radio2);

        // 下拉列表
        String[] items = {"选项A", "选项B", "选项C"};
        JComboBox<String> comboBox = new JComboBox<>(items);

        // 列表
        String[] listItems = {"项目1", "项目2", "项目3"};
        JList<String> list = new JList<>(listItems);
        JScrollPane listScrollPane = new JScrollPane(list);

        // 添加组件到窗口
        frame.add(textField);
        frame.add(scrollPane);
        frame.add(checkBox);
        frame.add(radio1);
        frame.add(radio2);
        frame.add(comboBox);
        frame.add(listScrollPane);

        frame.pack();
        frame.setVisible(true);
    }
}
