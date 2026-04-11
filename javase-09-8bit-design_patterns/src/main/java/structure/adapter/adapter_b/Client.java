package structure.adapter.adapter_b;

public class Client {
    public static void main(String[] args) {
        Voltage220V voltage220V = new Voltage220V();
        //获取到适配器
        VoltageAdapter voltageAdapter = new VoltageAdapter(voltage220V);

        Phone phone = new Phone();
        phone.charging(voltageAdapter);
    }
}
