package structure.decorator.decorator_j;

public class SequenceInputStream extends InputStream{

	@Override
	public int read() {
		System.out.println("SequenceInputStream read...");
		return 0;
	}

}
