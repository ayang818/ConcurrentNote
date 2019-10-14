package Lock;

import org.w3c.dom.Node;

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
        public Integer value;
        public Node next;
        public Integer key;
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
        int abs = Math.abs(key.hashCode() % buckets.length);
        System.out.println(abs);
        return abs;
    }

    public Object get(Object key) {
        int hash = hash(key);
        synchronized (locks[hash % LOCK_NUM]) {
            for (Node m = buckets[hash]; m!=null; m = m.next) {
                if (m.key.equals(key)) {
                    return m.value;
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
