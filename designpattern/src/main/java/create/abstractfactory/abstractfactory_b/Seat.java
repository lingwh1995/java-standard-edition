package create.abstractfactory.abstractfactory_b;

/**  
 * @author ronin
 * @date 2019年3月11日  
 *    
 */
public interface Seat {
	void massage();
}

class LuxurySeat implements Seat{

	@Override
	public void massage() {
		System.out.println("高端座椅有自动按摩功能...");
	}
	
}

class LowSeat implements Seat{

	@Override
	public void massage() {
		System.out.println("低端座椅没有自动按摩的功能...");
	}
}