package create.abstractfactory.abstractfactory_b;

/**  
 * @author ronin
 * @date 2019年3月11日  
 *    
 */
public class LuxuryCarFactory implements CarFactory{

	@Override
	public Engine createEngine() {
		return new LuxuryEngine();
	}

	@Override
	public Seat createSeat() {
		return new LuxurySeat();
	}

	@Override
	public Tyre createTyre() {
		return new LuxuryTyre();
	}

}
