package structure.decorator.decorator_j;

public class BufferedInputStream extends FilterInputStream {

	protected BufferedInputStream(InputStream in) {
		super(in);
	}

	public int read() {
		super.read();
		System.out.println("读取过程中加入缓存....");
		return 0;
	}
}
