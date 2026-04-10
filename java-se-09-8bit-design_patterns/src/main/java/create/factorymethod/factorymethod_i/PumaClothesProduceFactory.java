package create.factorymethod.factorymethod_i;

public class PumaClothesProduceFactory implements IClothesProduceFactory {

	@Override
	public IHat produceHat() {
		return new PumaHat();
	}

	@Override
	public IJacket produceJacket() {
		return new PumaJacket();
	}

	@Override
	public ITrousers produceTrousers() {
		return new PumaTrousers();
	}

	@Override
	public IShoes produceShoes() {
		return new PumaShoes();
	}

}
