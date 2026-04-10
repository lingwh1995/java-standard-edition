package create.factorymethod.factorymethod_a;

/**  
 * @author ronin
 * @date 2019年3月11日  
 *    
 */
public class AudiFactory extends CarFactory {

	/**
	 * <p>Title: createCar</p>  
	 * <p>Description: </p>  
	 * @return  
	 * @see CarFactory#createCar()
	 */

	@Override
	protected Car createCar() {
		return new Audi();
	}

}
