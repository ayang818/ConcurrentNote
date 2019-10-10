package Test;

/**
 * @ClassName GetAviableProcesser
 * @Dessription TODO
 * @Author 杨丰畅
 * @Date 2019/10/8 18:13
 **/
public class GetAviableProcesser {
    public static void main(String[] args) {
        int N_CPUS = Runtime.getRuntime().availableProcessors();
        System.out.println(N_CPUS);
    }
}
