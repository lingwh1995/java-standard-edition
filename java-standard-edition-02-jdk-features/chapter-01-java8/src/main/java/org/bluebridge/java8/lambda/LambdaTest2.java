package org.bluebridge.java8.lambda;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 验证lambda表达式实际上是函数式接口的实例对象，只要是对象，实现了Serializable接口可以在网络传输中进行传输
 */
public class LambdaTest2 {
    static class Server {
        public static void main(String[] args) throws IOException {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("server start......");
            while(true) {
                Socket socket = serverSocket.accept();
                Thread.ofVirtual().start(() -> {
                    try {
                        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                        LambdaTest1.LambdaCalculator lambdaCalculator = (LambdaTest1.LambdaCalculator)ois.readObject();
                        System.out.println("lambdaCalculator = " + lambdaCalculator);
                        int a = ThreadLocalRandom.current().nextInt(10);
                        int b = ThreadLocalRandom.current().nextInt(10);
                        System.out.printf("%s %d op %d = %d%n", socket.getRemoteSocketAddress().toString(), a, b, lambdaCalculator.calc(a,b));
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
        }
    }

    static class Client01 {
        public static void main(String[] args) {
            try {
                Socket socket = new Socket("127.0.0.1", 8080);
                LambdaTest1.LambdaCalculator add = (a, b) -> a + b;
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                oos.writeObject(add);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class Client02 {
        public static void main(String[] args) {
            try {
                Socket socket = new Socket("127.0.0.1", 8080);
                LambdaTest1.LambdaCalculator sub = (a, b) -> a - b;
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                oos.writeObject(sub);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class Client03 {
        public static void main(String[] args) {
            try {
                Socket socket = new Socket("127.0.0.1", 8080);
                LambdaTest1.LambdaCalculator mul = (a, b) -> a * b;
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                oos.writeObject(mul);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class Client04 {
        public static void main(String[] args) {
            try {
                Socket socket = new Socket("127.0.0.1", 8080);
                LambdaTest1.LambdaCalculator div = (a, b) -> a / b;
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                oos.writeObject(div);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
