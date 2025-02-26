package structure.decorator.decorator_j;

public class ByteArrayInputStream extends InputStream{

	@Override
	public int read() {
		System.out.println("ByteArrayInputStream read...");
		return 0;
	}

}
