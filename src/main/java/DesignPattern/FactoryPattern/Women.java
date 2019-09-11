package DesignPattern.FactoryPattern;

/**
 * @ClassName Women
 * @Dessription TODO
 * @Author 杨丰畅
 * @Date 2019/9/11 18:27
 **/
public class Women implements Human{
    @Override
    public void eat() {
        System.out.println("women eat");
    }

    @Override
    public void run() {
        System.out.println("women run");
    }
}
