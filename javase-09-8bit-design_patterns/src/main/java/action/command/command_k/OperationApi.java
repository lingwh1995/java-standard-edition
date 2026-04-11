package action.command.command_k;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/9/10 16:08
 */
public interface OperationApi {
    /**
     * 获取计算完成后的结果
     * @return
     */
    public int getResult();

    /**
     * 设置计算开始时的初始值
     * @param result 结果
     */
    public void setResult(int result);

    /**
     * 执行加法
     * @param num 被加数
     */
    public void add(int num);

    /**
     * 执行减法
     * @param num 被减数
     */
    public void subStract(int num);
}
