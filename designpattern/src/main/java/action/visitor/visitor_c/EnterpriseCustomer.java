package action.visitor.visitor_c;

/**
 * 企业客户
 * @author ronin
 * @version V1.0
 * @since 2019/10/10 17:45
 */
public class EnterpriseCustomer extends Customer{

    /**
     * 联系人
     */
    private String linkman;

    /**
     * 联系电话
     */
    private String linkTelephone;

    /**
     * 企业注册地址
     */
    private String registerAddress;

    /**
     * 企业客户提出服务请求的方法，示意一下
     */
    @Override
    public void serviceRequest(){
        //企业客户提出的具体服务请求
        System.out.println(this.getName()+"企业提出服务请求");
    }

    /**
     * 企业客户对公司产品的偏好分析，示意一下
     */
    @Override
    public void predilectionAnalyze(){
        //根据过往购买的历史、潜在购买意向
        //以及客户所在行业的发展趋势、客户的发展预期等的分析
        System.out.println("现在对企业客户"+this.getName()+"进行产品偏好分析");
    }

    /**
     * 企业客户价值分析，示意一下
     */
    @Override
    public void worthAnalyze(){
        //根据购买的金额大小、购买的产品和服务的多少、购买的频率等进行分析
        //企业客户的标准会比个人客户的高
        System.out.println("现在对企业客户"+this.getName()+"进行价值分析");
    }
}
