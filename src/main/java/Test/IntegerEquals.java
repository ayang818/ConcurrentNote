package Test;

import java.util.ArrayList;
import java.util.Random;

public class IntegerEquals {
    public static void main(String[] args) {
        // 所有包装类对象的比较，全部用equals,对于-128-127范围内的赋值，Integer对象是在IntegerCache.cache中产生的，会复用已有对象，其它都是在堆上产生
        Integer num1 = 199;
        Integer num2 = 199;
        Integer num3 = 122;
        Integer num4 = 122;
        System.out.println(num1.equals(num2));
        System.out.println(num1.equals(num3));
        System.out.println(num3.equals(num4));
        System.out.println((int) (Math.random() * 1000000));
        Random random = new Random(100);
        for (int i = 0; i < 100; i++) {
            System.out.println(Math.abs(random.nextInt(100)));
        }
    }
}
