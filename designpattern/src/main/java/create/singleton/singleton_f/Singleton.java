package create.singleton.singleton_f;

/**
 * @author ronin
 */
public class Singleton {
    /**
     * 注意下面三行代码的顺序决定了Singleton.x和Singleton.y的值
     */
    private static Singleton instance = new Singleton();
    public static int x = 0;
    public static int y;
    private Singleton(){
        x++;
        y++;
    }
    public static Singleton getInstance(){
        return instance;
    }
}
