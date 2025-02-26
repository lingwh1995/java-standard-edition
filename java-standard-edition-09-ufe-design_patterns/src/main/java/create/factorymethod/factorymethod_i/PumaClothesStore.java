package create.factorymethod.factorymethod_i;

public class PumaClothesStore extends ClothesStore {

	@Override
	Clothes produce() {
		IClothesProduceFactory pumaClothesProduceFactory = new PumaClothesProduceFactory();
		return new PumaClothes(pumaClothesProduceFactory);
	}

}
