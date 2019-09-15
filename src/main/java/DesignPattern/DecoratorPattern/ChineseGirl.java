package DesignPattern.DecoratorPattern;

/**
 * @ClassName ChineseGirl
 * @Dessription TODO
 * @Author 杨丰畅
 * @Date 2019/9/15 15:58
 **/
public class ChineseGirl extends Girl {

    public ChineseGirl() {
        StringBuilder stringBuilder = new StringBuilder(description);
        stringBuilder.append(" Chinese Girl");
        description = stringBuilder.toString();
    }
}
