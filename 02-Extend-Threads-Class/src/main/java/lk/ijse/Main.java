package lk.ijse;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        A a = new A();
        B b = new B();
        a.start();
        Thread.sleep(1000);
        b.start();
    }
}

class A extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("A is running...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class B extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("B is running...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}