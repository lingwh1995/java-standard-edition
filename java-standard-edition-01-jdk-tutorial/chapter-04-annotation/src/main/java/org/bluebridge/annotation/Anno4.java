package org.bluebridge.annotation;

/**
 *  注解属性的类型:
 *  	8种基本类型
 * 		String
 * 		Enum
 * 		Class
 * 		注解类型
 * 		以上类型的一维数组类型，如{"",""},
 *	注意事项:
 *		1.Integer是包装类，不属于上述范围
 *		2.当给数组类型的属性赋值时，如果数组元素的个数为1，则赋值时可以省略大括号
 */
public @interface Anno4 {
    int a();
    String b();

    //枚举类型的属性
    ColorEnum c();
    Class d();

    //注解类型的属性
    Anno2 e();
    int[] f();
}
