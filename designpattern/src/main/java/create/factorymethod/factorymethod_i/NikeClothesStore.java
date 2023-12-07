package create.factorymethod.factorymethod_i;

public class NikeClothesStore extends ClothesStore {

	@Override
	Clothes produce() {
		IClothesProduceFactory nikeClothesProduceFactory = new NikeClothesProduceFactory();
		return new NikeClothes(nikeClothesProduceFactory);
	}

}
