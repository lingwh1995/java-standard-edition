package create.factorymethod.factorymethod_i;

public class AdidasClothesStore extends ClothesStore {

	@Override
	Clothes produce() {
		IClothesProduceFactory adidasClothesProduceFactory = new AdidasClothesProduceFactory();
		return new AdidasClothes(adidasClothesProduceFactory);
	}

}
