package netutil;

import okhttp3.OkHttpClient;

/**
 * @ClassName OkhttpclientSingleton
 * @Dessription TODO
 * @Author 杨丰畅
 * @Date 2019/9/10 19:06
 **/
public class OkhttpclientSingleton {
    private static volatile OkHttpClient okHttpClient;

    public static OkHttpClient getInstance() {
        if (okHttpClient == null) {
            synchronized (OkhttpclientSingleton.class) {
                if (okHttpClient == null) {
                    okHttpClient = new OkHttpClient();
                }
            }
        }
        return okHttpClient;
    }
}
