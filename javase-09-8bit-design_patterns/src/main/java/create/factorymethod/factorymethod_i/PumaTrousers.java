package create.factorymethod.factorymethod_i;

public class PumaTrousers implements ITrousers {

	@Override
	public void produce() {
		System.out.println("Puma Trousers produce ok...");
	}

}
