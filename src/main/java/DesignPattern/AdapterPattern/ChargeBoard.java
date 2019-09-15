package DesignPattern.AdapterPattern;

/**
 * @ClassName ChargeBoard
 * @Dessription TODO
 * @Author 杨丰畅
 * @Date 2019/9/15 12:15
 **/
public class ChargeBoard implements ThreePins {
    ThreePins threePins;

    ChargeBoard(ThreePins threePins) {
        this.threePins = threePins;
    }

    @Override
    public void chargeWithThreePins() {
        System.out.println("charge with three pins!");
        charge();
    }

    private void charge() {
        System.out.println("charge success");
    }
}
