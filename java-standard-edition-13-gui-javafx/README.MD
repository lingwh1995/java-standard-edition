# Java Swing 外观主题大全

本文整理了Java Swing开发中常用的外观主题库，按照推荐程度分为三个等级。

## 优选-强烈推荐

- **Weblaf**
  - 特点：界面现代、简约，依赖包较少
  - 许可证：开源及商业协议
  - 链接：https://github.com/mgarin/weblaf

- **PgsLookAndFeel**
  - 特点：界面简约现代
  - 许可证：Apache2
  - 链接：https://github.com/pago/pgslookandfeel/

- **Seaglass**
  - 特点：基于Java 7 Nimbus改进，界面现代
  - 许可证：开源
  - 链接：https://github.com/khuxtable/seaglass/wiki

- **beautyeye**
  - 特点：国人开发，界面现代
  - 许可证：开源
  - 链接：https://github.com/JackJiang2011/beautyeye

## 中选-推荐使用

- **Synthetica**
  - 特点：UI风格丰富，中文字体支持存在问题
  - 许可证：部分免费，部分需商业授权
  - 链接：http://www.javasoft.de/synthetica/themes/

- **Jtattoo**
  - 特点：Luna风格特别出色
  - 许可证：GPL/LGPL/Apache
  - 链接：http://www.jtattoo.net/

- **Insubstantial**
  - 特点：substance项目的分支
  - 许可证：开源
  - 链接：https://github.com/Insubstantial/insubstantial

- **Nimbus**
  - 特点：Java 6 Update 10内置，稳定可靠
  - 许可证：Oracle开源
  - 链接：http://docs.oracle.com/javase/tutorial/uiswing/lookandfeel/nimbus.html

## 其他-备选方案

- **Quaqua**
  - 特点：模拟MAC OS界面
  - 许可证：开源
  - 链接：http://www.randoshofer.ch/quaqua/index.html

- **Alloy**
  - 特点：商业产品
  - 许可证：商业
  - 链接：http://lookandfeel.incors.com/

- **JGoodies**
  - 特点：商业产品
  - 许可证：商业
  - 链接：http://www.jgoodies.com/products/swing-suite/

## 使用说明

要在您的Swing应用程序中使用这些外观主题，请在初始化GUI组件之前调用以下代码：

```java
try {
    UIManager.setLookAndFeel("com.example.LookAndFeelClassName");
} catch (Exception e) {
    e.printStackTrace();
}
```

## 注意事项

- 在使用第三方外观主题前，请确认其许可证是否符合您的项目要求
- 某些外观主题可能需要额外的依赖库
- 测试不同操作系统上的兼容性以确保用户体验的一致性