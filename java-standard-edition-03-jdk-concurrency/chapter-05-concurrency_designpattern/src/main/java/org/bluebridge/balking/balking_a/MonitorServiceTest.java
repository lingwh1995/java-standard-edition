package org.bluebridge.balking.balking_a;

public class MonitorServiceTest {
    public static void main(String[] args) {
        MonitorService monitorService = new MonitorService();
        monitorService.start();
        monitorService.start();
        monitorService.start();
        monitorService.start();
    }
}
