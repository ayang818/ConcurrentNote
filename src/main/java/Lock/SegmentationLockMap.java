package Lock;

import org.w3c.dom.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName SegmentationLockMap
 * @Dessription TODO
 * @Author 杨丰畅
 * @Date 2019/10/14 9:54
 **/
public class SegmentationLockMap {
    static class Node {
        Integer value;
        Node next;
        Integer key;

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Integer getKey() {
            return key;
        }

        public void setKey(Integer key) {
            this.key = key;
        }
    }
    private final int LOCK_NUM = 16;
    private final Node[] buckets;
    private final Object[] locks;
    public SegmentationLockMap(Integer bucketNum) {
        buckets = new Node[bucketNum];
        locks = new Object[bucketNum];
        for (int i = 0; i < LOCK_NUM; i++) {
            locks[i] = new Object();
        }
    }

    public final Integer hash(Object key) {
//        以除留余数法做hash演算
        int abs = Math.abs(key.hashCode() % buckets.length);
        System.out.println(abs);
        return abs;
    }

    public Object get(Object key) {
        int hash = hash(key);
        synchronized (locks[hash % LOCK_NUM]) {
            for (Node node = buckets[hash]; node != null; node = node.next) {
                if (node.key.equals(key)) {
                    return node.value;
                }
            }
        }
        return null;
    }

    public void clear() {
        for (int i = 0; i < buckets.length; i++) {
            synchronized (locks[i % LOCK_NUM]) {
                buckets[i] = null;
            }
        }
    }
}
