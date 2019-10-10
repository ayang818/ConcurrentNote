package Volatile;

/**
 * @ClassName Singleton
 * @Dessription TODO
 * @Author 杨丰畅
 * @Date 2019/10/10 11:23
 **/
public class Singleton {
    private static volatile Singleton instance;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}
