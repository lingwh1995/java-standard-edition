package org.bluebridge;

import javax.swing.*;
import java.awt.*;

/**
 * @author lingwh
 * @desc 创建菜单栏和菜单
 * @date 2026/1/29 22:30
 */
public class _015_MenuBarAndMenuTest {

    public static void main(String[] args) {
        // 使用 invokeLater 将 UI 任务推送到事件分发线程 (EDT) - lambda 表达式调用
        // SwingUtilities.invokeLater(() -> new _015_MenuBarAndMenuTest().createAndShowGUI());

        // 使用 invokeLater 将 UI 任务推送到事件分发线程 (EDT) - 方法引用调用
        SwingUtilities.invokeLater(new _015_MenuBarAndMenuTest()::createAndShowGUI);
    }

    /**
     * 创建并显示 GUI
     */
    private void createAndShowGUI() {
        // 创建窗体
        Frame frame = new Frame();

        // 设置窗体位置和尺寸
        frame.setBounds(500, 500, 500, 300);

        // 创建菜单栏
        MenuBar bar = new MenuBar();
        Menu menu = new Menu("File");
        menu.add(new MenuItem("Open"));

        // 添加点击事件
        MenuItem openItem = new MenuItem("Open");
        openItem.addActionListener(e -> System.out.println("打开菜单被点击了......"));
        menu.add(openItem);

        MenuItem saveItem = new MenuItem("Save");
        // MenuShortcut就是指定快捷键组合，默认情况下是Ctrl+指定按键
        saveItem.setShortcut(new MenuShortcut('S'));
        // 第二个参数指定为true表示需要Ctrl+Shift+指定按键
        // saveItem.setShortcut(new MenuShortcut('S', true));
        saveItem.addActionListener(e -> System.out.println("保存菜单使用快捷键 Ctrl + S 被触发了......"));
        menu.add(saveItem);

        bar.add(menu);
        //为窗口设定刚刚定义好的菜单栏
        frame.setMenuBar(bar);

        // 设置窗体可见
        frame.setVisible(true);
    }

}
