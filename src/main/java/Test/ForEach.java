package Test;

import javax.naming.CompositeName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName ForEach
 * @Dessription TODO
 * @Author 杨丰畅
 * @Date 2019/9/2 11:01
 **/
public class ForEach {
    private static List<String> list = new ArrayList<>();
    public static void main(String[] args) {
        list.add("1");
        list.add("2");

        // 不要再foreach循环中add/remove元素
        for (String s : list) {
            if ("2".equals(s)) {
                list.remove(s);
                break;
            }
        }

        // 使用Iterator
//        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            String next = iterator.next();
//            if ("2".equals(next)) {
//                iterator.remove();
//            }
//        }
        System.out.println(list);
    }
}
