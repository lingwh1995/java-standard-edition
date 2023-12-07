package action.command.command_j;


/**
 * 音响设备打开命令对象
 * @author ronin
 * @version V1.0
 * @since 2019/9/4 15:16
 */
public class StereoOnWithCDCommand implements Command {

    Stereo stereo;

    public StereoOnWithCDCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    /**
     * 打开音响设备命令
     */
    @Override
    public void execute() {
        stereo.on();
    }

    /**
     * 撤销打开音响设备命令
     */
    @Override
    public void undo() {
        stereo.off();
    }
}
