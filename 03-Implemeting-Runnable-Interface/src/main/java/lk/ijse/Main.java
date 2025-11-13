package lk.ijse;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable1 myRunnable = new MyRunnable1();
        Thread thread = new Thread(myRunnable);
        thread.start();

        Thread.sleep(1000);

        MyRunnable2 myRunnable2 = new MyRunnable2();
        Thread thread2 = new Thread(myRunnable2);
        thread2.start();
    }
}

class MyRunnable1 implements Runnable {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("MyRunnable1 is running");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class MyRunnable2 implements Runnable {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("MyRunnable2 is running");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}