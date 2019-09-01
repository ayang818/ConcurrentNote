package BasicSetupModule;

import java.util.Vector;

/**
 * @ClassName SafeContainerStaticLoad
 * @Dessription 静态类内部加载
 * @Author 杨丰畅
 * @Date 2019/9/1 16:32
 **/
public class SafeContainerStaticLoad {
    private Vector<Integer> vector;

    private static class SingletonHelper {
        private static SafeContainerStaticLoad safeContainerStaticLoad= new SafeContainerStaticLoad();
    }

    public static SafeContainerStaticLoad getInstance() {
        return SingletonHelper.safeContainerStaticLoad;
    }

    private SafeContainerStaticLoad() {
        vector = new Vector<>();
    }

    public synchronized Integer deleteLast() {
        int lastIndex = vector.size() - 1;
        Integer remove = vector.remove(lastIndex);
        return remove;
    }

    public synchronized void addLast(Integer integer) {
        vector.add(integer);
    }

    public synchronized boolean isEmpty() {
        return vector.isEmpty();
    }

    public synchronized Integer getLast() {
        int size = vector.size() - 1;
        Integer integer = vector.get(size);
        return integer;
    }
}
