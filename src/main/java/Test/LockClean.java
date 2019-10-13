package Test;

/**
 * @ClassName LockClean
 * @Dessription TODO
 * @Author 杨丰畅
 * @Date 2019/10/10 21:09
 **/
public class LockClean {
    public static void main(String[] args) {
        String s1 = "1";
        String s2 = "2";
        String s3 = "3";
        String string = concatString(s1, s2, s3);
        System.out.println(string);

    }

    public static String concatString(String s1, String s2, String s3) {
        return s1 + s2 + s3;
    }
}
