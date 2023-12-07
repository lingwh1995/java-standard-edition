package structure.decorator.decorator_b;

/**
 * 星巴克咖啡：被装饰者
 */
public class StartBuckCoffee extends Coffee{
    public StartBuckCoffee(){
        super.setDesc("星巴克咖啡");
        super.setPrice(25.9);
    }
}
