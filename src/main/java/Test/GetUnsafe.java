package Test;

import sun.misc.Unsafe;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicInteger;

public class GetUnsafe {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Unsafe> unsafeClass = Unsafe.class;
        Constructor<Unsafe> declaredConstructor = unsafeClass.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        Unsafe unsafe = declaredConstructor.newInstance();
        AtomicInteger atomicInteger = new AtomicInteger();
    }
}
