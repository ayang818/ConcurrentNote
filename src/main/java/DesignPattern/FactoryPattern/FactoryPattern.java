package DesignPattern.FactoryPattern;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @ClassName FactoryPattern
 * @Dessription TODO
 * @Author 杨丰畅
 * @Date 2019/9/11 18:20
 **/
public class FactoryPattern {
    /**
     * @Date 18:32 2019/9/11
     * @Author 杨丰畅
     * @Description 普通静态工厂方法
     * @Param [type]
     * @Return DesignPattern.FactoryPattern.Human
     */
    public static Human getHuman(String type) {
        if (type.equals("man")) {
            return new Man();
        }

        if (type.equals("woman")) {
            return new Women();
        }
        return null;
    }

    /**
     * @Date 18:32 2019/9/11
     * @Author 杨丰畅
     * @Description 多个静态工厂方法
     * @Param []
     * @Return DesignPattern.FactoryPattern.Man
     */
    public static Man getMan() {
        return new Man();
    }

    public static Women getWomen() {
        return new Women();
    }


    // 看到getInstance突然想到newInstance
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        ArrayList<Object> list1 = new ArrayList<>();
        list1.add(1);
        ArrayList list = ArrayList.class.getDeclaredConstructor(Collection.class).newInstance(list1);
        list.add(1);
        System.out.println(list);

    }
}
