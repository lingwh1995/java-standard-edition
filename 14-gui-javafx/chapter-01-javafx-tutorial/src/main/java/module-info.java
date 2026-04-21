module org.bluebridge.javafx.helloworld {
    // 必须包含 JavaFX 的基础模块
    requires javafx.controls;
    requires javafx.fxml;

    // --- 添加下面这一行来引入 AtlantaFX ---
    requires atlantafx.base;

    // 如果你也要用 ControlsFX，请加上这一行
    requires org.controlsfx.controls;

    // 允许 JavaFX 反射访问你的包（如果你使用了 FXML）
    opens org.bluebridge to javafx.graphics, javafx.fxml;

    // 导出你的包，以便外部可以运行
    exports org.bluebridge;
}
