package ConcurrentContainer;

import com.alibaba.fastjson.JSON;
import okhttp3.*;

import javax.print.attribute.standard.Media;
import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.LinkedList;

/**
 * @ClassName LinkedListTest
 * @Dessription TODO
 * @Author 杨丰畅
 * @Date 2019/9/4 16:25
 **/
public class LinkedListTest {
    private static LinkedList<Integer> linkedList = new LinkedList<>();

    public static void main(String[] args) {
        linkedList.offer(1);
        System.out.println(linkedList.toString());
        linkedList.offer(2);
        System.out.println(linkedList.toString());
        OkHttpClient okHttpClient = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://www.baidu.com")
                .build();

        try (Response response = okHttpClient.newCall(request).execute()) {
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }

        MediaType JSON = MediaType.get("application/json; charset=utf-8");

        RequestBody body = RequestBody.create(JSON, "{'User-Agent': 'Mozilla/5.0'}");

        Request postrequest = new Request.Builder()
                .url("https://www.baidu.com")
                .post(body)
                .build();

        try(Response response = okHttpClient.newCall(postrequest).execute()) {
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}