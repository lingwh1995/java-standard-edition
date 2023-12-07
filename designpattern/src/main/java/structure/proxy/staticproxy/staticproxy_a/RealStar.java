package structure.proxy.staticproxy.staticproxy_a;

/**  
 * 真实的歌手
 * @author ronin  
 * @date 2019年3月23日  
 *    
 */
public class RealStar implements Star {

	@Override
	public void confer() {
		System.out.println("RealStar(周杰伦)......confer()");
	}

	@Override
	public void signContract() {
		System.out.println("RealStar(周杰伦)......signContract()");
	}

	@Override
	public void bookTicket() {
		System.out.println("RealStar(周杰伦)......bookTicket()");
	}

	@Override
	public void sing() {
		System.out.println("RealStar(周杰伦)......sing()");
	}

	@Override
	public void clollectMoney() {
		System.out.println("RealStar(周杰伦)......clollectMoney()");
	}

}
