package design_pattern.template.template_a;

/**
 * 用户数据模型
 * @author ronin
 * @version V1.0
 * @since 2019/8/26 15:32
 */
public class UserModel {

    private String userId,name;

    private int age;

    public UserModel(String userId,String name,int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString(){
        return "userId="+userId+",name="+name+",age="+age;
    }
}
