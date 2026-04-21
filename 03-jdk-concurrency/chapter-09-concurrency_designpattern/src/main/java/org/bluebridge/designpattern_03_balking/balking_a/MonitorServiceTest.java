package org.bluebridge.designpattern_03_balking.balking_a;

public class MonitorServiceTest {
    public static void main(String[] args) {
        MonitorService monitorService = new MonitorService();
        monitorService.start();
        monitorService.start();
        monitorService.start();
        monitorService.start();
    }
}
