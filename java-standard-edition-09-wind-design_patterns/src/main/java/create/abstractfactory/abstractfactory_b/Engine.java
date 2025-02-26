package create.abstractfactory.abstractfactory_b;

/**  
 * @author ronin
 * @date 2019年3月11日  
 *    
 */
public interface Engine {
	void run();
}

class LuxuryEngine implements Engine{

	@Override
	public void run() {
		System.out.println("高端发动机跑的快...");
	}
	
}

class LowEngine implements Engine{

	@Override
	public void run() {
		System.out.println("低端发动机跑的慢...");
	}
	
}