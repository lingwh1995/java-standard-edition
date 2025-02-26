package create.factorymethod.factorymethod_i;

public class AdidasTrousers implements ITrousers {

	@Override
	public void produce() {
		System.out.println("Adidas Trousers produce ok...");
	}

}
