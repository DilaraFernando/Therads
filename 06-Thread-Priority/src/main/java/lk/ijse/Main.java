package lk.ijse;

public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(() ->{
            for (int i =0; i <10; i++){
                System.out.println("T1" +" -"+Thread.currentThread().getPriority());

            }
        });
        Thread t2 = new Thread(() ->{
            for (int i = 0; i < 10; i++){
                System.out.println("T2" +" -"+ Thread.currentThread().getPriority());
            }
        });
        t1.start();
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.start();
        t2.setPriority(Thread.MIN_PRIORITY);
//        MAX = 10
//        MIN = 1
//        NORM= 5

    }

}