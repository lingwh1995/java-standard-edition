/**
 * @author ronin
 */
public class ClassActiveObject {
    public static void main(String[] args) {
        //类会初始化
        //System.out.println(Obj.i);
        //访问被final修饰的类,不会初始化类
        //System.out.println(Obj.j);

        //通过子类访问父类静态变量:父类会初始化,子类不会初始化
        //System.out.println(Son.i);
        //访问子类静态变量:父类和子类都会初始化
        System.out.println(Son.k);
    }
}

class Obj{
    public static int i = 0;
    public final static int j = 0;
    static {
        System.out.println("Obj初始化了....");
    }
}
class Son extends Obj {
    public static int k = 0;
    static {
        System.out.println("Obj的子类son初始化了....");
    }
}
