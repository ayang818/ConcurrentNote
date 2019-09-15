package DesignPattern.DecoratorPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName Test
 * @Dessription TODO
 * @Author 杨丰畅
 * @Date 2019/9/15 16:05
 **/
public class Test {
    public static void main(String[] args) throws IOException {
        Girl americanGirl = new AmericanGirl();
        Girl decoratedGirl = new Tall(new GoldenHair(americanGirl));
        System.out.println(decoratedGirl.getDescription());
        InputStreamReader in = new InputStreamReader(System.in);
        in.read();
        BufferedReader input = new BufferedReader(in);
        System.out.println(input.readLine());
    }
}
