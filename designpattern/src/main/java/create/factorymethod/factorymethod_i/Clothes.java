package create.factorymethod.factorymethod_i;

public abstract class Clothes {
	IHat hat;
	IJacket jacket;
	ITrousers trousers;
	IShoes shoes;
	
	void pack() {
		hat.produce();
		jacket.produce();
		trousers.produce();
		shoes.produce();
	}
}
