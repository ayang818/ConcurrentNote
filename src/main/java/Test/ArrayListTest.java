package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName ArrayListTest
 * @Dessription TODO
 * @Author 杨丰畅
 * @Date 2019/10/13 18:05
 **/
public class ArrayListTest {
    public static void main(String[] args) {
        int[] list = new int[]{1,2,3,4,5};
        int[] lists = Arrays.copyOf(list, 3);
        System.out.println(Arrays.toString(lists));
        list[0] = 100;
        System.out.println(Arrays.toString(lists));

        ArrayList<Integer> list1 = new ArrayList<>(8);
        for (int i = 0; i < 10; i++) {
            list1.add(i);
        }
        List<Integer> integers = list1.subList(0, 3);
        Object[] objects = integers.toArray();
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }
    }
}
