package action.command.command_i;

/**
 * 命令接口
 * @author ronin
 * @version V1.0
 * @since 2019/9/4 14:03
 */
public interface Command {

    /**
     * 执行命令
     */
    public void execute();

    /**
     * 撤销命令
     */
    public void undo();
}
