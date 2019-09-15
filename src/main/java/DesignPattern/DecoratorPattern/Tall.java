package DesignPattern.DecoratorPattern;

/**
 * @ClassName Tall
 * @Dessription TODO
 * @Author 杨丰畅
 * @Date 2019/9/15 16:04
 **/
public class Tall extends GirlDecoration {
    Girl girl;

    public Tall(Girl girl) {
        this.girl = girl;
    }

    @Override
    public String getDescription() {
        return girl.getDescription()+" is very tall";
    }
}
