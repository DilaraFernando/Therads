package lk.ijse;

public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i =0; i < 10; i++){
                System.out.println("Thread 1 is running");
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    throw new RuntimeException(e);
                }

            }
        });
        Thread t2 = new Thread(() ->{
            for (int i=0; i <10; i++){
                System.out.println("Thread 2 is running");
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    throw new RuntimeException(e);
                }
            }
        });
        t1.start();
        try {
            t1.join();
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        System.out.println(t1.isAlive());
        t2.start();
        try{
            t2.join();
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        System.out.println(t2.isAlive());
        System.out.println("Bye");

    }
}