package action.state.state_e;

/**
 * 恶意投票状态
 * @author ronin
 * @version V1.0
 * @since 2019/8/27 10:33
 */
public class SpiteVoteState implements VoteState {

    @Override
    public void vote(String user, String voteItem,VoteManager voteManager) {
        //恶意投票
        //取消用户的投票资格，并取消投票记录
        String s = voteManager.getMapVote().get(user);
        if(s!=null){
            voteManager.getMapVote().remove(user);
        }
        System.out.println("你有恶意刷票行为，取消投票资格");
    }
}
