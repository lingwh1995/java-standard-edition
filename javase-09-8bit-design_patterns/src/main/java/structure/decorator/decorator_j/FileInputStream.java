package structure.decorator.decorator_j;

public class FileInputStream extends InputStream {

	@Override
	public int read() {
		System.out.println("FileInputStream read...");
		return 0;
	}

}
