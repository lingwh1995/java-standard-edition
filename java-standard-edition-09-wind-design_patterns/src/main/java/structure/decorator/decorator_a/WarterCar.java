package structure.decorator.decorator_a;

/**  
 * 具体装饰器/具体装饰角色
 * @author ronin  
 * @date 2019年3月23日  
 *    
 */
public class WarterCar extends SuperCar {

	public WarterCar(ICar car) {
		super(car);
	}

	@Override
	public void run() {
		super.run();
		swim();
	}

	/**  
	 * 增强的功能
	 * @param 
	 * @return void
	 * @throws  
	 */
	private void swim() {
		System.out.println("水里游......");
	}
}
