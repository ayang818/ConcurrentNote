package Test;

public class LoopInference {
    public static void main(String[] args) {
        A a = new A();
        a.getRef();
        if (a.b == null) {
            System.out.println("have been collected");
        } else {
            System.out.println("have not been collected");
        }
        a.setBBNull();
        System.out.println(a.bb == null);
        if (a.b == null) {
            System.out.println("have been collected");
        } else {
            System.out.println("have not been collected");
        }
    }
}

class A {
    B b;
    B bb = new B();

    public void getRef() {
        this.b = this.bb;
        this.b.a = this;
    }

    public void  setBBNull() {
        b = null;
    }
}

class B {
    A a;

    public void run() {
        System.out.println("run!");
    }
}
