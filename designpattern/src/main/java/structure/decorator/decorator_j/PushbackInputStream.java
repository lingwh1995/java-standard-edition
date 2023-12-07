package structure.decorator.decorator_j;

public class PushbackInputStream extends FilterInputStream{

	protected PushbackInputStream(InputStream in) {
		super(in);
	}
	
	@Override
	public int read() {
		super.read();
		System.out.println("读取的时候加入回退功能...");
		return 0;
	}
}
