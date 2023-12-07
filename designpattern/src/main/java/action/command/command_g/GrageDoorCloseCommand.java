package action.command.command_g;

/**
 * 汽车库门关闭命令
 * @author ronin
 * @version V1.0
 * @since 2019/9/4 14:14
 */
public class GrageDoorCloseCommand implements Command{
    GrageDoor grageDoor;

    public GrageDoorCloseCommand(GrageDoor grageDoor) {
        this.grageDoor = grageDoor;
    }

    @Override
    public void execute() {
        grageDoor.close();
    }
}
