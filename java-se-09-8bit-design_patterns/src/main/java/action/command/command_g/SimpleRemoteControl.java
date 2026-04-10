package action.command.command_g;

/**
 * 遥控器对象
 * @author ronin
 * @version V1.0
 * @since 2019/9/4 14:07
 */
public class SimpleRemoteControl {
    Command solt;

    public SimpleRemoteControl(){

    }

    public void setCommand(Command command){
        solt = command;
    }

    public void buttonWasPressed(){
        solt.execute();
    }
}
