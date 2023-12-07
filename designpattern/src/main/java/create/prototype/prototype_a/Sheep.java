package create.prototype.prototype_a;

import java.util.Date;

/**  
 * 浅客隆/浅复制实体
 * @author ronin  
 * @date 2019年3月23日  
 */
public class Sheep implements Cloneable{
	/*
	 * Cloneable接口:空接口，标记接口
	 */
	private String name;
	private Date birthday;

	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		//直接调用Object的clone()方法
		Object obj = super.clone();
		return obj;
	}

	/**  
	 * 创建一个新的实例 Sheep.  
	 *    
	 */ 
	public Sheep() {
		super();
	}

	/**  
	 * 创建一个新的实例 Sheep.  
	 *  
	 * @param name
	 * @param birthday  
	 */ 
	public Sheep(String name, Date birthday) {
		super();
		this.name = name;
		this.birthday = birthday;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	
	@Override
	public String toString() {
		return "Sheep [name=" + name + ", birthday=" + birthday + "]";
	}
	
}
