package structure.proxy.synchronizedproxy;

public interface Task {

    void task();
    Thread createThread1();
    Thread createThread2();
}
