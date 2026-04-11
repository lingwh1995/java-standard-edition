package structure.decorator.decorator_j;

public class ObjectInputStream extends InputStream{

	@Override
	public int read() {
		System.out.println("ObjectInputStream read...");
		return 0;
	}

}
