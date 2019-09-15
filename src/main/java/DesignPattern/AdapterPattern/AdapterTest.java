package DesignPattern.AdapterPattern;

/**
 * @ClassName AdapterTest
 * @Dessription TODO
 * @Author 杨丰畅
 * @Date 2019/9/15 12:25
 **/
public class AdapterTest {
    public static void main(String[] args) {
        TwoToThreeAdapter twoToThreeAdapter = new TwoToThreeAdapter();
        ChargeBoard chargeBoard = new ChargeBoard(twoToThreeAdapter);
        chargeBoard.chargeWithThreePins();
    }
}
