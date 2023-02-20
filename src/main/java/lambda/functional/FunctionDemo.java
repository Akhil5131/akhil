package lambda.functional;
//BiConsumer Interface
import java.util.function.Function;

class functionImpl implements Function<String,Integer>{


    @Override
    public Integer apply(String s) {
        return s.length();
    }
}
public class FunctionDemo {
    public static void main(String[] args) {
      //  Function<String,Integer> Fun = new functionImpl();
      //  System.out.println(Fun.apply("Ramesh"));
        Function<String,Integer> Fun = (String s) -> s.length();
        System.out.println(Fun.apply("Ramesh"));

    }

}
