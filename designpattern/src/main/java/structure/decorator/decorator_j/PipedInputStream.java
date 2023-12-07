package structure.decorator.decorator_j;

public class PipedInputStream extends InputStream {

	@Override
	public int read() {
		System.out.println("PipedInputStream read...");
		return 0;
	}

}
