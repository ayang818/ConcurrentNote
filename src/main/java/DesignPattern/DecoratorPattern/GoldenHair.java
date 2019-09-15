package DesignPattern.DecoratorPattern;

/**
 * @ClassName GoldenHair
 * @Dessription TODO
 * @Author 杨丰畅
 * @Date 2019/9/15 16:01
 **/
public class GoldenHair extends GirlDecoration {
    Girl girl;

    public GoldenHair(Girl g) {
        girl = g;
    }

    @Override
    public String getDescription() {
        return girl.getDescription()+" with golden hair";
    }
}
