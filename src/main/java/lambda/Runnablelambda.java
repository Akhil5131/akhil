package lambda;
class ThreadDemo implements Runnable {

    @Override
    public void run() {
        System.out.println("run method called...");

    }
}
public class Runnablelambda {
    public static void main(String[] args) {
        //  Thread thread = new Thread(new ThreadDemo());//Instance of Thread class
        //thread.start();

        Runnable run = () ->System.out.println("run method called using lambda....");
        Thread threadlambda = new Thread(run);
        threadlambda.start();
    }
}
