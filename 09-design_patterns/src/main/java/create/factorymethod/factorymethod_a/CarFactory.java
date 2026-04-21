package create.factorymethod.factorymethod_a;

/**  
 * 工厂的接口
 * @author ronin  
 * @date 2019年3月11日  
 *    
 */
public abstract class CarFactory {

	public void run(){
		Car car = createCar();
		car.run();
	}
	/**
	 * 工厂方法
	 * @return
	 */
	protected abstract Car createCar();
}
