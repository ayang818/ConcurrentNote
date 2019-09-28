package ConcurrentContainer;

import com.alibaba.fastjson.JSON;
import okhttp3.*;

import javax.print.attribute.standard.Media;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

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
        linkedList.offer(2);
        System.out.println(linkedList);
        final Integer peek = linkedList.peek();
        System.out.println(peek);
        System.out.println(linkedList);
        HashMap<String, String> hashMap = new HashMap<>(16);
        hashMap.put("1","2");
        hashMap.put("1","3");
        hashMap.put("2", "2");
        for (Map.Entry entry : hashMap.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}