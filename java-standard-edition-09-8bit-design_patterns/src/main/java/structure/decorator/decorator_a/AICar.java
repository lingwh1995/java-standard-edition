package structure.decorator.decorator_a;

/**  
 * 具体装饰器/具体装饰角色
 * @author ronin  
 * @date 2019年3月23日  
 *    
 */
public class AICar extends SuperCar{

	public AICar(ICar car) {
		super(car);
	}

	@Override
	public void run() {
		super.run();
		autoRun();
	}

	/**  
	 * 增强的功能
	 * @param 
	 * @return void
	 * @throws  
	 */
	private void autoRun() {
		System.out.println("自动驾驶......");
	}
}
