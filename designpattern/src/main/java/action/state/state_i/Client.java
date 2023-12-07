package action.state.state_i;

/**
 * @author by lingwh
 */
public class Client {
    public static void main(String[] args) {
        //开始活动;
        RaffleActivity raffleActivity = new RaffleActivity(1);
        //抽奖10次;
        for (int i = 0; i < 10; i++) {
            System.out.println("第"+(i+1)+"次抽奖--->");
            //扣积分;抽奖
            raffleActivity.deductIntegral();
            raffleActivity.raffle();
        }
    }
}

