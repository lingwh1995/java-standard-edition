package structure.bridge.bridge_a;

/**  
 * 电脑类型的维度
 * @author ronin  
 * @date 2019年3月23日  
 *    
 */
public abstract class Computer2 {

 	protected Brand brand;

	public Computer2(Brand brand) {
		this.brand = brand;
	}
	
	public void sale(){
		brand.sale();
	}
}

class Desktop2 extends Computer2 {

	public Desktop2(Brand brand) {
		super(brand);
	}

	@Override
	public void sale() {
		super.sale();
		System.out.println("销售台式机......");
	}
}

class Laptop2 extends Computer2 {

	public Laptop2(Brand brand) {
		super(brand);
	}

	@Override
	public void sale() {
		super.sale();
		System.out.println("销售手提电脑......");
	}
}

class Pad2 extends Computer2 {

	public Pad2(Brand brand) {
		super(brand);
	}

	@Override
	public void sale() {
		super.sale();
		System.out.println("销售平板电脑......");
	}
}



