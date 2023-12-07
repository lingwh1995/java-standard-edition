package create.factorymethod.factorymethod_i;

public class PumaClothes extends Clothes {
	
	public PumaClothes(IClothesProduceFactory pumaClothesProduceFactory) {
		hat = pumaClothesProduceFactory.produceHat();
		jacket = pumaClothesProduceFactory.produceJacket();
		trousers = pumaClothesProduceFactory.produceTrousers();
		shoes = pumaClothesProduceFactory.produceShoes();
	}
}
