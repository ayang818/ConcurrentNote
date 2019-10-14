package Test;

/**
 * @ClassName HashCodeTest
 * @Dessription TODO
 * @Author 杨丰畅
 * @Date 2019/10/14 10:15
 **/
public class HashCodeTest {
    static class Node {
        private Integer value;
        private Integer key;
        private Node next;

        public Node(Integer key, Integer value, Node next) {
            this.value = value;
            this.key = key;
            this.next = next;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public Integer getKey() {
            return key;
        }

        public void setKey(Integer key) {
            this.key = key;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
    static Node[] nodes = new Node[8];
    public static void main(String[] args) {
        for (int i = 0; i < 8; i++) {
            nodes[i] = new Node(i, i, null);
        }
        for (int i = 0; i < 8; i++) {
            if (i != 7) {
                nodes[i].setNext(nodes[i+1]);
            }
        }
        for (int i = 0; i < 8; i++) {
            System.out.println(nodes[i].hashCode() % nodes.length);
        }
        System.out.println(9 & 8);
        System.out.println(9 | 5);
        System.out.println(9 ^ 5);
        System.out.println(-3 ^ -2);
        System.out.println(Integer.toBinaryString(2));
        System.out.println(-8 >>> 2);
        System.out.println(-8 >> 2);
        System.out.println(5 % 4);
        System.out.println(5 & 3);
    }
}
