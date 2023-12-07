package structure.adapter.adapter_f.client;

import structure.adapter.adapter_f.controller.XxjlController;
import structure.adapter.adapter_f.domain.Xxjl;

public class Client {
    private static XxjlController xxjlController = new XxjlController();

    public static void main(String[] args) {
        xxjlController.save(new Xxjl());
        xxjlController.delete(new Xxjl());
    }
}
