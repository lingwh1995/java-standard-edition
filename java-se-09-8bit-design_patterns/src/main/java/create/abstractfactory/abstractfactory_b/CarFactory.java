package create.abstractfactory.abstractfactory_b;

/**  
 * @author ronin
 * @date 2019年3月11日  
 *    
 */
public interface CarFactory {
	Engine createEngine();
	Seat createSeat();
	Tyre createTyre();
}
