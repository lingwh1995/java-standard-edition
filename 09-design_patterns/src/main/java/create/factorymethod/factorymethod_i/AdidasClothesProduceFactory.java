package create.factorymethod.factorymethod_i;

public class AdidasClothesProduceFactory implements IClothesProduceFactory{

	@Override
	public IHat produceHat() {
		return new AdidasHat();
	}

	@Override
	public IJacket produceJacket() {
		return new AdidasJacket();
	}

	@Override
	public ITrousers produceTrousers() {
		return new AdidasTrousers();
	}

	@Override
	public IShoes produceShoes() {
		return new AdidasShoes();
	}

}
