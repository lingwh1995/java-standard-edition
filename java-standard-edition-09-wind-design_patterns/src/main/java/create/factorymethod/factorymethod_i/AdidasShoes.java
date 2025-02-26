package create.factorymethod.factorymethod_i;

public class AdidasShoes implements IShoes {

	@Override
	public void produce() {
		System.out.println("Adidas Shoes produce ok...");
	}

}
