package org.bluebridge.ioc.anno_one.entity;


import org.bluebridge.ioc.anno_one.anno.Controller;

/**
 * @author ronin
 * @date 2019年3月20日  
 */

@Controller
public class UserController {
	private IUserService userService;
	public void say(){
		userService.say();
	}
}
