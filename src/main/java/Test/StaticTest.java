package Test;

public class StaticTest {
    private static Integer num =1;

    public static void main(String[] args) {
        StaticTest staticTest = new StaticTest();
        System.out.println(staticTest.num);
    }

    public static void print() {
        System.out.println(num);
    }
}
