package lambda;

class ThreadDemo2 implements Runnable{

    @Override
    public void run() {
        System.out.println("run method is called .....");
    }
}
public class RunnableLambdaExample {
    public static void main(String[] args) {
        //Thread thread = new Thread(new ThreadDemo2());
        //thread.start();

         Runnable run1 =() ->
            System.out.println("run method is called  using lambda...");
       run1.run();
    }
    }
