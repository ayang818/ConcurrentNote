package Lock;

public class ObjectLock {
    private static Runnable releaseO = () -> {
        System.out.print("O");
    };
    private static Runnable releaseH = () -> {
        System.out.print("H");
    };
    private static H2O h2O = new H2O();
    private static String inputStr = "OOHHHHOHH";

    public static void main(String[] args) {
        for (int i = 0; i < inputStr.length(); i++) {
            if ("O".equals(Character.toString(inputStr.charAt(i)))) {
                new Thread(() -> {
                    try {
                        h2O.oxygen(releaseO);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();
            } else if ("H".equals(Character.toString(inputStr.charAt(i)))) {
                new Thread(() -> {
                    try {
                        h2O.hydrogen(releaseH);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        }
    }

}

class H2O {

    private static final Object LOCK = new Object();

    private int HCounter = 0;

    H2O() {

    }

    void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        synchronized(LOCK)
        {
            while(HCounter >= 2)
            {
                LOCK.wait();
            }
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
            this.HCounter++;
            LOCK.notifyAll();
        }

    }

    void oxygen(Runnable releaseOxygen) throws InterruptedException {
        synchronized(LOCK)
        {
            while(HCounter < 2)
            {
                LOCK.wait();
            }
            // releaseOxygen.run() outputs "H". Do not change or remove this line.
            releaseOxygen.run();
            this.HCounter = 0;
            LOCK.notifyAll();
        }

    }
}