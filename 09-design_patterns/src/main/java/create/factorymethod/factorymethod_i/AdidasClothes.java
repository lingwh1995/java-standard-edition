package create.factorymethod.factorymethod_i;

public class AdidasClothes extends Clothes{

	public AdidasClothes(IClothesProduceFactory adidasClothesProduceFactory) {
		hat = adidasClothesProduceFactory.produceHat();
		jacket = adidasClothesProduceFactory.produceJacket();
		trousers = adidasClothesProduceFactory.produceTrousers();
		shoes = adidasClothesProduceFactory.produceShoes();
	}
	
}
