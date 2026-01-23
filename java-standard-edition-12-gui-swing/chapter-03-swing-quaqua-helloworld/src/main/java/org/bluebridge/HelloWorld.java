package org.bluebridge;


import ch.randelshofer.quaqua.QuaquaLookAndFeel;

import javax.swing.*;
import java.awt.*;

/**
 * @author lingwh
 * @desc
 * @date 2026/1/22 15:02
 */
public class HelloWorld {

    public static void main(String[] args) {
        try {
            // 设置Quaqua外观，模仿Mac OS X界面
            UIManager.setLookAndFeel(new QuaquaLookAndFeel());
            
            // 可以通过系统属性自定义Quaqua的某些特性
            System.setProperty("Quaqua.design", "light");
            
            SwingUtilities.invokeLater(() -> {
                JFrame frame = new JFrame("Quaqua外观演示 - MAC风格界面");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(500, 400);
                frame.setLayout(new BorderLayout(10, 10));
                
                // 创建顶部面板
                JPanel topPanel = new JPanel();
                topPanel.add(new JLabel("欢迎使用Quaqua外观主题!"));
                
                // 创建中心面板
                JPanel centerPanel = new JPanel(new GridBagLayout());
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.insets = new Insets(5, 5, 5, 5);
                
                gbc.gridx = 0; gbc.gridy = 0;
                centerPanel.add(new JLabel("用户名:"), gbc);
                gbc.gridx = 1;
                centerPanel.add(new JTextField(15), gbc);
                
                gbc.gridx = 0; gbc.gridy = 1;
                centerPanel.add(new JLabel("密码:"), gbc);
                gbc.gridx = 1;
                centerPanel.add(new JPasswordField(15), gbc);
                
                gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
                gbc.anchor = GridBagConstraints.CENTER;
                centerPanel.add(new JCheckBox("记住登录状态"), gbc);
                
                // 创建底部按钮面板
                JPanel buttonPanel = new JPanel();
                buttonPanel.add(new JButton("登录"));
                buttonPanel.add(new JButton("取消"));
                
                // 添加组件到框架
                frame.add(topPanel, BorderLayout.NORTH);
                frame.add(centerPanel, BorderLayout.CENTER);
                frame.add(buttonPanel, BorderLayout.SOUTH);
                
                // 添加菜单栏
                JMenuBar menuBar = new JMenuBar();
                JMenu fileMenu = new JMenu("文件");
                fileMenu.add(new JMenuItem("新建"));
                fileMenu.add(new JMenuItem("打开"));
                fileMenu.addSeparator();
                fileMenu.add(new JMenuItem("退出"));
                menuBar.add(fileMenu);
                
                JMenu helpMenu = new JMenu("帮助");
                helpMenu.add(new JMenuItem("关于"));
                menuBar.add(helpMenu);
                
                frame.setJMenuBar(menuBar);

                // 居中显示
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
