package DesignPattern.FactoryPattern;

/**
 * @ClassName Man
 * @Dessription TODO
 * @Author 杨丰畅
 * @Date 2019/9/11 18:25
 **/
public class Man implements Human {
    @Override
    public void eat() {
        System.out.println("man eat");
    }

    @Override
    public  void run() {
        System.out.println("man run");
    }
}
