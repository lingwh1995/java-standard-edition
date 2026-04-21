package structure.adapter.adapter_g_builder.client;

import structure.adapter.adapter_g_builder.controller.XxjlController;
import structure.adapter.adapter_g_builder.domain.Xxjl;

public class Client {
    private static XxjlController xxjlController = new XxjlController();

    public static void main(String[] args) {
        xxjlController.save(new Xxjl());
        xxjlController.delete(new Xxjl());
    }
}
