//package org.bluebridge;
//
//import org.eclipse.swt.SWT;
//import org.eclipse.swt.events.SelectionAdapter;
//import org.eclipse.swt.events.SelectionEvent;
//import org.eclipse.swt.layout.FillLayout;
//import org.eclipse.swt.widgets.Button;
//import org.eclipse.swt.widgets.Display;
//import org.eclipse.swt.widgets.Label;
//import org.eclipse.swt.widgets.Shell;
///**
// * @author lingwh
// * @desc
// * @date 2025/8/4 18:42
// */
//public class HelloWorld {
//    public static void main(String[] args) {
//        // 创建显示设备
//        Display display = new Display();
//
//        // 创建主窗口
//        Shell shell = new Shell(display);
//        shell.setText("我的第一个SWT应用");
//        shell.setSize(300, 200);
//        shell.setLayout(new FillLayout());
//
//        // 创建组件
//        Label label = new Label(shell, SWT.CENTER);
//        label.setText("欢迎使用SWT!");
//
//        Button button = new Button(shell, SWT.PUSH);
//        button.setText("点击我");
//
//        // 添加事件监听器
//        button.addSelectionListener(new SelectionAdapter() {
//            @Override
//            public void widgetSelected(SelectionEvent e) {
//                label.setText("按钮被点击了!");
//            }
//        });
//
//        // 显示窗口
//        shell.open();
//
//        // 事件循环
//        while (!shell.isDisposed()) {
//            if (!display.readAndDispatch()) {
//                display.sleep();
//            }
//        }
//
//        // 清理资源
//        display.dispose();
//    }
//}
