package lambda.functional;

import java.util.function.Consumer;

class ConsumerImpl implements Consumer<String>{ // Consumer can have only input Consumer<T>

    @Override
    public void accept(String sd) {
        System.out.println(sd);
    }
}
public class ConsumerDemo {
    public static void main(String[] args) {

        Consumer<String> consumer = (sd) -> System.out.println(sd);
        consumer.accept("Hello World");
    }

}
