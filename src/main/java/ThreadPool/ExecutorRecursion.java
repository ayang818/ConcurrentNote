package ThreadPool;

import okhttp3.Call;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.*;

/**
 * @ClassName ExecutorRecursion
 * @Dessription TODO
 * @Author 杨丰畅
 * @Date 2019/10/13 10:37
 **/
public class ExecutorRecursion {
    static LinkedBlockingQueue<Callable> queue = new LinkedBlockingQueue<>();
    static List<Integer> list = new ArrayList<>();
    static ExecutorService exec = Executors.newFixedThreadPool(10);

    static class Node {
        private Integer value;
        private Node left;
        private Node right;

        public Node(Integer value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Node root = generator();
        recursion(root);
        Thread.sleep(1000);
        List<Future<Integer>> ansList = invokeAll(queue, exec);
        int ans = 0;
        for (Future<Integer> future : ansList) {
            ans += (future.get());
        }
        System.out.println(ans);
        exec.shutdown();
    }

    public static Node generator() {
        Node root = new Node(5, null, null);
        Node left1 = new Node(5, null, null);
        Node right1 = new Node(5, null, null);
        Node left11 = new Node(5, null, null);
        Node right12 = new Node(5, null, null);
        Node left21 = new Node(5, null, null);
        Node right22 = new Node(5, null, null);
        root.setLeft(left1);
        root.setRight(right1);
        left1.setLeft(left11);
        left1.setRight(right12);
        right1.setLeft(left21);
        right1.setRight(right22);
        return root;
    }

    public static List invokeAll(Queue queue, ExecutorService exec) throws InterruptedException {
        List<Future<Integer>> list = exec.invokeAll(queue);
        return list;
    }

    public static void recursion(Node node) {
        if (node != null) {
            task(node);
            recursion(node.getLeft());
            recursion(node.getRight());
        }
    }

    public static void task(Node node) {
        Callable<Integer> callable = () -> {
            int e = node.getValue() + 1;
            list.add(e);
            return e;
        };
        queue.offer(callable);
    }
}
