package org.bluebridge.ioc.anno_one.entity;


import org.bluebridge.ioc.anno_one.anno.Repository;

/**
 * @author ronin
 * @date 2019年3月20日  
 *    
 */
@Repository
public class UserDao {
	
	public void say(){
		System.out.println("sqy()....");
	}
}
