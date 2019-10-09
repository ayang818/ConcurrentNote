package ClassLoader;

/**
 * @ClassName StaticTest
 * @Dessription TODO
 * @Author 杨丰畅
 * @Date 2019/10/9 20:38
 **/
public class StaticTest {
    static {
        i = 1;
//        非法向前引用
//        System.out.println(i);
    }
    static int i;
}
