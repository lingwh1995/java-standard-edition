package action.command.command_g;

/**
 * 电灯打开命令
 * @author ronin
 * @version V1.0
 * @since 2019/9/4 14:04
 */
public class LightOnCommand implements Command{
    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}
