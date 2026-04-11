package action.state.state_i;

/**
 * @author by lingwh
 */
//奖品发完 状态;
public class NoPrizesState extends State{
    //关联抽奖活动;
    private RaffleActivity raffleActivity;
    //初始化;
    public NoPrizesState(RaffleActivity raffleActivity) {
        this.raffleActivity = raffleActivity;
    }

    //扣除积分发放;
    @Override
    public void deductIntegral() {
        System.out.println("奖品没了,就不扣您的积分了");
    }

    @Override
    public boolean raffle() {
        System.out.println("奖品都没了,您还抽什么奖啊!");
        return false;
    }

    @Override
    public void offeringPrizes() {
        System.out.println("奖品都没了,不用来领奖了!");
    }
}

