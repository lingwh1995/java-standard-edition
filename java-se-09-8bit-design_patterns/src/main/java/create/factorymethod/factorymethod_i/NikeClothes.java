package create.factorymethod.factorymethod_i;

public class NikeClothes extends Clothes {

	public NikeClothes(IClothesProduceFactory nikeClothesProduceFactory) {
		hat = nikeClothesProduceFactory.produceHat();
		jacket = nikeClothesProduceFactory.produceJacket();
		trousers = nikeClothesProduceFactory.produceTrousers();
		shoes = nikeClothesProduceFactory.produceShoes();
	}
}
