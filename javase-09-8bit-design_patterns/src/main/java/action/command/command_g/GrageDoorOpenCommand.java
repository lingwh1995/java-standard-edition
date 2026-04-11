package action.command.command_g;

/**
 * 汽车库门打开命令
 * @author ronin
 * @version V1.0
 * @since 2019/9/4 14:14
 */
public class GrageDoorOpenCommand implements Command{
    GrageDoor grageDoor;

    public GrageDoorOpenCommand(GrageDoor grageDoor) {
        this.grageDoor = grageDoor;
    }

    @Override
    public void execute() {
        grageDoor.open();
    }
}
