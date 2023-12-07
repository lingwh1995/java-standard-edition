package action.state.state_i;

/**
 * @author by lingwh
 */

//不许抽奖状态(待抽奖状态);
public class NotRaffleState extends State{

    //关联抽奖活动;
    private RaffleActivity raffleActivity;
    //初始化;
    public NotRaffleState(RaffleActivity raffleActivity) {
        this.raffleActivity = raffleActivity;
    }

    //扣除积分;
    @Override
    public void deductIntegral() {
        System.out.println("扣掉50分啦,可以去抽奖啦!!!");
        //状态转换==>可抽奖状态;
        raffleActivity.setState(raffleActivity.getRaffleState());
    }

    @Override
    public boolean raffle() {
        System.out.println("对不起,扣除积分才能参与抽奖!");
        return false;
    }

    @Override
    public void offeringPrizes() {
        System.out.println("没参与抽奖,不发奖品!!!");
    }
}

