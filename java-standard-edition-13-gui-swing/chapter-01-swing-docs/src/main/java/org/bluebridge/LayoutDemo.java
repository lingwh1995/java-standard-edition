package org.bluebridge;

import javax.swing.*;
import java.awt.*;

/**
 * 布局管理器演示程序
 * 演示多种常用的布局管理器及其特点
 */
public class LayoutDemo extends JFrame {
    
    public LayoutDemo() {
        initializeFrame();
        setupMainPanel();
    }
    
    /**
     * 初始化主窗口
     */
    private void initializeFrame() {
        setTitle("Java Swing 布局管理器演示");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null); // 居中显示
    }
    
    /**
     * 设置主面板
     */
    private void setupMainPanel() {
        // 使用BorderLayout作为主布局
        setLayout(new BorderLayout());
        
        // 创建顶部说明面板
        JPanel topPanel = createTopPanel();
        add(topPanel, BorderLayout.NORTH);
        
        // 创建中央演示面板
        JPanel centerPanel = createCenterPanel();
        add(centerPanel, BorderLayout.CENTER);
        
        // 创建底部信息面板
        JPanel bottomPanel = createBottomPanel();
        add(bottomPanel, BorderLayout.SOUTH);
    }
    
    /**
     * 创建顶部说明面板
     */
    private JPanel createTopPanel() {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder("布局管理器演示"));
        panel.setPreferredSize(new Dimension(800, 60));
        
        JLabel titleLabel = new JLabel("Java Swing 布局管理器演示程序", JLabel.CENTER);
        titleLabel.setFont(new Font("微软雅黑", Font.BOLD, 18));
        panel.add(titleLabel);
        
        return panel;
    }
    
    /**
     * 创建中央演示面板
     */
    private JPanel createCenterPanel() {
        // 使用CardLayout来组织不同的布局演示
        JPanel panel = new JPanel(new BorderLayout());
        
        // 创建选项卡面板来展示不同布局
        JTabbedPane tabbedPane = new JTabbedPane();
        
        // 添加各种布局演示面板
        tabbedPane.addTab("FlowLayout", createFlowLayoutPanel());
        tabbedPane.addTab("BorderLayout", createBorderLayoutPanel());
        tabbedPane.addTab("GridLayout", createGridLayoutPanel());
        tabbedPane.addTab("GridBagLayout", createGridBagLayoutPanel());
        tabbedPane.addTab("BoxLayout", createBoxLayoutPanel());
        
        panel.add(tabbedPane, BorderLayout.CENTER);
        
        return panel;
    }
    
    /**
     * 创建底部信息面板
     */
    private JPanel createBottomPanel() {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(800, 30));
        
        JLabel infoLabel = new JLabel("提示：调整窗口大小以查看不同布局的效果", JLabel.CENTER);
        infoLabel.setForeground(Color.GRAY);
        panel.add(infoLabel);
        
        return panel;
    }
    
    /**
     * 创建FlowLayout演示面板
     */
    private JPanel createFlowLayoutPanel() {
        JPanel panel = new JPanel(new FlowLayout());
        panel.setBorder(BorderFactory.createTitledBorder("FlowLayout - 流式布局"));
        
        // 添加一些组件来演示FlowLayout
        for (int i = 1; i <= 6; i++) {
            JButton button = new JButton("按钮 " + i);
            button.setPreferredSize(new Dimension(100, 50));
            panel.add(button);
        }
        
        // 添加标签和文本框
        JLabel label = new JLabel("标签：");
        JTextField textField = new JTextField(10);
        panel.add(label);
        panel.add(textField);
        
        // 添加说明
        JLabel description = new JLabel("特点：按添加顺序从左到右排列，空间不足时自动换行");
        description.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        description.setForeground(Color.BLUE);
        panel.add(Box.createVerticalStrut(10)); // 添加一些垂直间距
        panel.add(description);
        
        return panel;
    }
    
    /**
     * 创建BorderLayout演示面板
     */
    private JPanel createBorderLayoutPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("BorderLayout - 边界布局"));
        
        // 添加中央组件
        JTextArea centerText = new JTextArea("BorderLayout.CENTER\n这是中央区域，占据剩余空间");
        centerText.setEditable(false);
        centerText.setLineWrap(true);
        centerText.setWrapStyleWord(true);
        centerText.setBackground(Color.LIGHT_GRAY);
        panel.add(centerText, BorderLayout.CENTER);
        
        // 添加北部组件
        JButton northButton = new JButton("North (顶部)");
        northButton.setPreferredSize(new Dimension(150, 30));
        panel.add(northButton, BorderLayout.NORTH);
        
        // 添加南部组件
        JButton southButton = new JButton("South (底部)");
        southButton.setPreferredSize(new Dimension(150, 30));
        panel.add(southButton, BorderLayout.SOUTH);
        
        // 添加西部组件
        JButton westButton = new JButton("West\n(左侧)");
        westButton.setPreferredSize(new Dimension(100, 100));
        panel.add(westButton, BorderLayout.WEST);
        
        // 添加东部组件
        JButton eastButton = new JButton("East\n(右侧)");
        eastButton.setPreferredSize(new Dimension(100, 100));
        panel.add(eastButton, BorderLayout.EAST);
        
        // 添加说明
        JLabel description = new JLabel("特点：分为北、南、东、西、中五个区域，每个区域只能放置一个组件");
        description.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        description.setForeground(Color.BLUE);
        panel.add(description, BorderLayout.SOUTH);
        
        return panel;
    }
    
    /**
     * 创建GridLayout演示面板
     */
    private JPanel createGridLayoutPanel() {
        // 使用2行3列的网格布局
        JPanel panel = new JPanel(new GridLayout(2, 3, 5, 5)); // 行数，列数，水平间距，垂直间距
        panel.setBorder(BorderFactory.createTitledBorder("GridLayout - 网格布局"));
        
        // 添加6个按钮形成2x3的网格
        for (int i = 1; i <= 6; i++) {
            JButton button = new JButton("按钮 " + i);
            button.setPreferredSize(new Dimension(100, 50));
            panel.add(button);
        }
        
        // 添加说明
        JLabel description = new JLabel("特点：将容器划分为相等大小的矩形网格，组件平均分配空间");
        description.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        description.setForeground(Color.BLUE);
        panel.add(description);
        
        return panel;
    }
    
    /**
     * 创建GridBagLayout演示面板
     */
    private JPanel createGridBagLayoutPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder("GridBagLayout - 网格包布局"));
        
        GridBagConstraints gbc = new GridBagConstraints();
        
        // 添加第一个组件到(0,0)，并设置占用2列
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(5, 5, 5, 5);
        JButton wideButton = new JButton("宽按钮 (占用2列)");
        wideButton.setPreferredSize(new Dimension(200, 40));
        panel.add(wideButton, gbc);
        
        // 添加第二个组件到(2,0) - 实际上是第3列
        gbc.gridx = 2; gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 0.0;
        JButton button1 = new JButton("按钮1");
        button1.setPreferredSize(new Dimension(80, 40));
        panel.add(button1, gbc);
        
        // 添加第三个组件到(0,1) - 第二行第一列
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 0.0;
        JButton button2 = new JButton("按钮2");
        button2.setPreferredSize(new Dimension(80, 40));
        panel.add(button2, gbc);
        
        // 添加第四个组件到(1,1) - 第二行第二列，并设置跨2行
        gbc.gridx = 1; gbc.gridy = 1;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.weighty = 1.0;
        JButton tallButton = new JButton("高按钮\n(跨2行)");
        tallButton.setPreferredSize(new Dimension(80, 80));
        panel.add(tallButton, gbc);
        
        // 添加第五个组件到(0,2) - 第三行第一列
        gbc.gridx = 2; gbc.gridy = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        JButton button3 = new JButton("按钮3");
        button3.setPreferredSize(new Dimension(80, 40));
        panel.add(button3, gbc);
        
        // 添加说明
        JLabel description = new JLabel("特点：最灵活的布局，可设置组件位置、大小、拉伸比例等");
        description.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        description.setForeground(Color.BLUE);
        panel.add(description);
        
        return panel;
    }
    
    /**
     * 创建BoxLayout演示面板
     */
    private JPanel createBoxLayoutPanel() {
        // 使用垂直Box布局作为主容器
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("BoxLayout - 盒式布局"));
        
        // 创建水平布局的第一个子面板
        JPanel horizontalPanel1 = new JPanel();
        horizontalPanel1.setLayout(new BoxLayout(horizontalPanel1, BoxLayout.X_AXIS));
        horizontalPanel1.setAlignmentX(Component.LEFT_ALIGNMENT); // 左对齐
        
        // 向第一个水平面板添加组件
        horizontalPanel1.add(new JButton("水平1"));
        
        horizontalPanel1.add(Box.createRigidArea(new Dimension(10, 0))); // 固定间隔
        
        horizontalPanel1.add(new JButton("水平2"));
        
        horizontalPanel1.add(Box.createHorizontalGlue()); // 弹性间隔
        
        horizontalPanel1.add(new JButton("水平3"));
        
        // 将第一个水平面板添加到主面板
        panel.add(horizontalPanel1);
        
        // 添加垂直间隔
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        
        // 创建水平布局的第二个子面板
        JPanel horizontalPanel2 = new JPanel();
        horizontalPanel2.setLayout(new BoxLayout(horizontalPanel2, BoxLayout.X_AXIS));
        horizontalPanel2.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        // 添加更多组件
        horizontalPanel2.add(new JLabel("标签:"));
        
        horizontalPanel2.add(Box.createRigidArea(new Dimension(5, 0)));
        
        horizontalPanel2.add(new JTextField(10));
        
        horizontalPanel2.add(Box.createRigidArea(new Dimension(10, 0)));
        
        horizontalPanel2.add(new JButton("提交"));
        
        // 将第二个水平面板添加到主面板
        panel.add(horizontalPanel2);
        
        // 添加垂直间隔
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        
        // 添加一个垂直的Box容器
        Box verticalBox = Box.createVerticalBox();
        verticalBox.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        verticalBox.add(new JLabel("垂直盒布局示例:"));
        
        verticalBox.add(Box.createRigidArea(new Dimension(0, 5)));
        
        verticalBox.add(new JButton("垂直按钮1"));
        
        verticalBox.add(Box.createRigidArea(new Dimension(0, 5)));
        
        verticalBox.add(new JButton("垂直按钮2"));
        
        verticalBox.add(Box.createRigidArea(new Dimension(0, 5)));
        
        verticalBox.add(new JButton("垂直按钮3"));
        
        panel.add(verticalBox);
        
        // 添加说明
        JLabel description = new JLabel("特点：可在X轴或Y轴方向排列组件，支持弹性间隔");
        description.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        description.setForeground(Color.BLUE);
        panel.add(description);
        
        return panel;
    }
    
    public static void main(String[] args) {
        // 设置系统外观
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // 在事件调度线程中创建和显示GUI
        SwingUtilities.invokeLater(() -> {
            try {
                new LayoutDemo().setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}