package lk.ijse;

public class Main {
    public static void main(String[] args) {
        Main outer = new Main();
        A a = outer.new A();

        Thread t1 = new Thread(outer.new Producer(a), "Thread 1");
        Thread t2 = new Thread(outer.new Consumer(a), "Thread 2");

        t1.start();
        t2.start();
    }


    class A {
        int num;
        volatile boolean valueSet = false;

        public void put(int num) {
            while (valueSet) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            this.num = num;
            valueSet = true;
            System.out.println("PUT " + num + " by " + Thread.currentThread().getName());
        }

        public void get() {
            while (!valueSet) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            System.out.println("GET " + num + " by " + Thread.currentThread().getName());
            valueSet = false;
        }
    }


    class Producer implements Runnable {
        private final A a;

        Producer(A a) {
            this.a = a;
        }

        public void run() {
            int i = 1;
            while (i <= 2) {
                a.put(i++);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
    }


    class Consumer implements Runnable {
        private final A a;

        Consumer(A a) {
            this.a = a;
        }

        public void run() {
            int count = 0;
            while (count < 2) {
                a.get();
                count++;
                try {
                    Thread.sleep(700);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
    }
}