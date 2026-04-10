package create.factorymethod.factorymethod_i;

public abstract class ClothesStore {
	
	/**
	 * 工厂方法
	 * @return
	 */
	abstract Clothes produce();
	
	void pack() {
		Clothes clothes = produce();
		clothes.pack();
	}
}
