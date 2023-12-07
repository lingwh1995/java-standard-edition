package structure.decorator.decorator_a;

/**  
 * 装饰器
 * @author ronin  
 * @date 2019年3月23日  
 *    
 */
public class SuperCar implements ICar {

	private ICar car;

	public SuperCar(ICar car) {
		this.car = car;
	}

	@Override
	public void run() {
		car.run();
	}

}
