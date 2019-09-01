package BasicSetupModule;

public class SafeContainerTest {
    public static void main(String[] args) {
        // 懒汉模式
//        SafeContainerHungry safeContainerHungry = SafeContainerHungry.getSafeContainerHungry();
        // 静态类内部加载
//        SafeContainerStaticLoad  =  SafeContainerStaticLoad.getInstance();
        SafeContainEnum safeContainerHungry = SafeContainEnum.SAFE_CONTAIN_ENUM;
        for (int i = 0; i < 100; i++) {
            safeContainerHungry.addLast(i);
        }
        new Thread(() -> {
            while (!safeContainerHungry.isEmpty()) {
                System.out.println("Get"+ safeContainerHungry.getLast());
            }
        }).start();
        new Thread(() -> {
            while (!safeContainerHungry.isEmpty()){
                System.out.println("Delete"+ safeContainerHungry.deleteLast());
            }
        }).start();
    }
}
