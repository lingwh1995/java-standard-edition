/**  
 * @author ronin
 * @date 2019年3月11日  
 * @version V1.0  
 */ 
package create.factorymethod.factorymethod_a;

/**  
 * @author ronin
 * @date 2019年3月11日  
 *    
 */
public class BydFactory extends CarFactory{

	/**
	 * <p>Title: createCar</p>  
	 * <p>Description: </p>  
	 * @return  
	 * @see CarFactory#createCar()
	 */  
	
	@Override
	protected Car createCar() {
		return new Byd();
	}

}
