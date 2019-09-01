package BasicSetupModule;

import java.util.Vector;

public enum SafeContainEnum {
    SAFE_CONTAIN_ENUM();
    private Vector<Integer> vector;

    SafeContainEnum() {
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
