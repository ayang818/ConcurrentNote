package BasicSetupModule;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Vector;

public class VectorSimpleTest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

//        Vector<Integer> list = new Vector<>();

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        new Thread(() -> {
            while (!list.isEmpty()) {
                Integer index = list.size() - 1;
                Integer integer = list.get(index);
                System.out.println("Read"+integer);
                System.out.println(list);
            }
        }).start();
        new Thread(() -> {
            while (!list.isEmpty()) {
                Integer index = list.size() - 1;
                System.out.println("Remove"+list.get(index));
                list.remove(index);
            }
        }).start();

        Method checkForComodification = ArrayList.class.getDeclaredMethod("checkForComodification");
        checkForComodification.setAccessible(true);
        checkForComodification.invoke(list);

    }
}
