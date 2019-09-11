package DesignPattern.AbstractFactoryPattern;

/**
 * @ClassName WomenFactory
 * @Dessription TODO
 * @Author 杨丰畅
 * @Date 2019/9/11 19:06
 **/
public class WomenFactory implements Provider{
    @Override
    public Human produce() {
        return new Women();
    }
}
