package DesignPattern.AbstractFactoryPattern;

/**
 * @ClassName ManFactory
 * @Dessription TODO
 * @Author 杨丰畅
 * @Date 2019/9/11 19:05
 **/
public class ManFactory implements Provider{
    @Override
    public Human produce() {
        return new Man();
    }
}
