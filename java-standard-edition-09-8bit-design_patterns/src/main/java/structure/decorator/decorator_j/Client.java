package structure.decorator.decorator_j;

import org.junit.Test;

public class Client {
	
	@Test
	public void fun() {
		FileInputStream fileInputStream = new FileInputStream();
		BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
		bufferedInputStream.read();
	}

}
