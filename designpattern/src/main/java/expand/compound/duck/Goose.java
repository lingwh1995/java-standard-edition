package expand.compound.duck;

/**
 * 鹅
 * 问题:在DuckSimulatorClient(鸭子模拟器客户端)中不能使用simulate(Quackable mallardDuck)
 *      这个方法调用Goose(鹅)的honk(),因为Goose不是Quackable接口的实现类,但是又想实现在
 *      DuckSimulatorClient(鸭子模拟器客户端)中使用simulate(Quackable mallardDuck)调用
 *      Goose(鹅)的honk()，该怎么办呢?
 *      使用适配器模式解决这个问题,编写一个GooseAdapter实现Quackable,并实现Quackable接口的
 *      quack()方法，同时GooseAdapter持有一个Goose类型的引用,GooseAdapter中的quack()方法
 *      的实际实现调用的就是Goose类型对象的方法
 * @author ronin
 * @version V1.0
 * @since 2019/10/10 9:55
 */
public class Goose {
    /**
     * 鹅也会鸣叫,但是不是像鸭子一样Quack，而是honk
     */
    public void honk(){
        System.out.println("Goose honk......");
    }
}
