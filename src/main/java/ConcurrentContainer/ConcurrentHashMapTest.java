package ConcurrentContainer;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @ClassName ConcurrentHashMapTest
 * @Dessription TODO
 * @Author 杨丰畅
 * @Date 2019/9/2 16:39
 **/
public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("1","is map");
        map.put("2","contains a mapping");
        map.put("3","specified");
        map.put("4","inappropriate");
        map.putIfAbsent("5", "test");
        String s = map.computeIfAbsent("6", k -> k);
        String none = map.getOrDefault("7", "none2");
        System.out.println(none);
        System.out.println(s);
        System.out.println(map.toString());
    }

}
