package DesignPattern.AdapterPattern;

/**
 * @ClassName TwoToThreeAdapter
 * @Dessription TODO
 * @Author 杨丰畅
 * @Date 2019/9/15 12:20
 **/
public class TwoToThreeAdapter implements ThreePins{
    TwoPins twoPins = () -> System.out.println("charge with two pins");

    @Override
    public void chargeWithThreePins() {
        twoPins.chargeWithTwoPins();
    }
}
