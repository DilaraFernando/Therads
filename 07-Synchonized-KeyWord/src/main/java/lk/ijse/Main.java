package lk.ijse;

public class Main {
    public static void main(String[] args) {

        Calculation calculation = new Calculation();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {

                calculation.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {

                calculation.increment();

            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(calculation.num);
    }

    static class Calculation{
        int num;
        void increment(){
            num++;
        }
    }
}