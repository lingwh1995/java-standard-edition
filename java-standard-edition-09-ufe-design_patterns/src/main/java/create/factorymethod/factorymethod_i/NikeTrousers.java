package create.factorymethod.factorymethod_i;

public class NikeTrousers implements ITrousers{

	@Override
	public void produce() {
		System.out.println("Nike Trousers produce ok...");
	}

}
