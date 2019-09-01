package BasicSetupModule;

import java.util.Vector;

/**
* @Date 16:30 2019/9/1
* @Author 杨丰畅
* @Description 单例模式——懒汉模式
*/
public class SafeContainerHungry {
    private Vector<Integer> vector;
    private static SafeContainerHungry safeContainerHungry;

    private SafeContainerHungry() {
        vector = new Vector<>();
    }

    public static SafeContainerHungry getSafeContainerHungry() {
        if (safeContainerHungry == null) {
            safeContainerHungry = new SafeContainerHungry();
        }
        for (int i = 0; i < 50; i++) {
            safeContainerHungry.addLast(i);
        }
        return safeContainerHungry;
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
