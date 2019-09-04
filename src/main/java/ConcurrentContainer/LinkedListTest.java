package ConcurrentContainer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName LinkedListTest
 * @Dessription TODO
 * @Author 杨丰畅
 * @Date 2019/9/4 16:25
 **/
public class LinkedListTest {
    private static final Queue queue = new LinkedList();


    public static void main(String[] args) {
        queue.offer(1);
        queue.offer(2);
        System.out.println(queue.toString());
        Object poll = queue.poll();
        System.out.println(poll);
        System.out.println(queue);
        Object peek = queue.peek();
        System.out.println(poll);
        System.out.println(queue);
    }
}