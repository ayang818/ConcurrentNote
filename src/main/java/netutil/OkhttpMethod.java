package netutil;

import com.alibaba.fastjson.JSON;
import okhttp3.*;

import java.io.IOException;

/**
 * @ClassName OkhttpMethod
 * @Dessription TODO
 * @Author 杨丰畅
 * @Date 2019/9/10 19:09
 **/
public class OkhttpMethod {

    private final OkHttpClient okHttpClient = OkhttpclientSingleton.getInstance();

    public Response get(String url) {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try(Response response = okHttpClient.newCall(request).execute()) {
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }

    public Response post(String url, Object jsonObject) {
        MediaType jsonType = MediaType.parse("application/json");

        RequestBody requestBody = RequestBody.create(jsonType, JSON.toJSONString(jsonObject));

        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();

        try(Response response = okHttpClient.newCall(request).execute()) {
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
