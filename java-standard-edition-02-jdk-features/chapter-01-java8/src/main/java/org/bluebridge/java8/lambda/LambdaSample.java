package org.bluebridge.java8.lambda;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ThreadLocalRandom;

public class LambdaSample {

	/**
	 * 普通的方法
	 * @param a
	 * @param b
	 * @return
	 */
	static int add(int a, int b) {
		return a + b;
	}
	
	/**
	 * 函数式接口
	 */
	@FunctionalInterface
	interface LambdaCalculator {
		int calc(int a, int b);
	}
	
	// 使用对象来表示函数
	static LambdaCalculator add = (a,b) -> a + b;
	static LambdaCalculator sub = (a,b) -> a - b;
	static LambdaCalculator mul = (a,b) -> a * b;
	static LambdaCalculator div = (a,b) -> a / b;
	
	
	public static void main(String[] args) {
		// 调用普通的方法
		System.out.println(LambdaSample.add(1, 2));
		
		//调用Lambda对象
		System.out.println(add.calc(100,10));
		System.out.println(sub.calc(100,10));
		System.out.println(mul.calc(100,10));
		System.out.println(div.calc(100,10));
	}
	
	static class Server {
		public static void main(String[] args) throws IOException {
			ServerSocket serverSocket = new ServerSocket(8080);
			System.out.println("server start......");
			while(true) {
				Socket socket = serverSocket.accept();
				new Thread(() -> {
					try {
						ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
						LambdaCalculator lambdaCalculator = (LambdaCalculator)ois.readObject();
						int a = ThreadLocalRandom.current().nextInt(10);
						int b = ThreadLocalRandom.current().nextInt(10);
						System.out.printf("%s %d op %d = %d%n", socket.getRemoteSocketAddress().toString(), a, b, lambdaCalculator.calc(a,b));
					} catch (IOException | ClassNotFoundException e) {
						// TODO Auto-generated catch block
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
				LambdaCalculator add = (a,b) -> a + b;
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				oos.writeObject(add);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	static class Client02 {
		public static void main(String[] args) {
			try {
				Socket socket = new Socket("127.0.0.1", 8080);
				LambdaCalculator sub = (a,b) -> a - b;
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				oos.writeObject(add);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	static class Client03 {
		public static void main(String[] args) {
			try {
				Socket socket = new Socket("127.0.0.1", 8080);
				LambdaCalculator mul = (a,b) -> a * b;
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				oos.writeObject(add);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	static class Client04 {
		public static void main(String[] args) {
			try {
				Socket socket = new Socket("127.0.0.1", 8080);
				LambdaCalculator div = (a,b) -> a / b;
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				oos.writeObject(add);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
