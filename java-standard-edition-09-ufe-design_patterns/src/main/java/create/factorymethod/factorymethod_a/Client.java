package create.factorymethod.factorymethod_a;

/**  
 * 调用者
 * @author ronin  
 * @date 2019年3月11日  
 *    
 */
public class Client {
	public static void main(String[] args) {
		CarFactory audiFactory = new AudiFactory();
		audiFactory.run();

		CarFactory bydFactory = new BydFactory();
		bydFactory.run();
	}
}
