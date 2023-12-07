package action.visitor.visitor_a;

/**
 * 被访问的元素的接口
 * @author ronin
 * @version V1.0
 * @since 2019/10/11 9:19
 */
public abstract class Element {

    /**
     * 接受访问者的访问
     * @param visitor 访问者对象
     */
    abstract void accept(Visitor visitor);
}
