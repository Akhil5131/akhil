package methodReferenceDemo;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

@FunctionalInterface
interface Printable{
    void print(String msg);
}

public class MethodReferenceDemo {


    public  void display(String msg){
        msg = msg.toUpperCase();
        System.out.println(msg);

    }
    public static int addition ( int a, int b){
        return (a + b);
    }
    public static void main(String[] args) {

        //1.Method reference to a static method
        //lambda expression
        Function<Integer, Double> function = (input) -> Math.sqrt(input);
        System.out.println(function.apply(4));

        // using method reference
        Function<Integer, Double> functionMethod = Math::sqrt;
        System.out.println(functionMethod.apply(4));

        //lambda expression
        BiFunction<Integer, Integer, Integer> bifunctinlambda = (a, b) -> MethodReferenceDemo.addition(a, b);
        System.out.println(bifunctinlambda.apply(10,20));

        //using an reference
        BiFunction<Integer, Integer, Integer> bifunctinlambda1 =MethodReferenceDemo::addition;
        System.out.println(bifunctinlambda1.apply(10,20));

        // Using method reference to an instance method of an object
        MethodReferenceDemo methodReferenceDemo = new MethodReferenceDemo();

        //lambda expression
     Printable printable = (msg)-> methodReferenceDemo.display(msg);
     printable.print("Hello World!");

      //using method reference
        Printable printable1 = methodReferenceDemo::display;
        printable1.print("HHHHHHH");

        //3.Reference to the instance method of an arbitary object
        // somtimes ,we call a method of argument in the lambda expression
        //In that case, we can use a method reference to call an instance method of an arbitary object of a specific type .
   Function<String,String> stringFunction = (String inputs) -> inputs.toLowerCase();
        System.out.println(stringFunction.apply("Java Guides"));

        //Method Reference
        Function<String,String> stringFunction1 = String::toLowerCase;
        stringFunction1.apply("gtgtgtg");

        String[] strArray = {"A","E","I","O","U","a","I","O","U"};

        Arrays.sort(strArray,(s1,s2)->s1.compareToIgnoreCase(s2));
        //using method reference
        Arrays.sort(strArray,String::compareToIgnoreCase);
        System.out.println("Sorted Array:"+strArray);
        for (String str :strArray){
            System.out.println(str);
        }
        //4.reference to a constructor
        List<String> fruits = new ArrayList<>();
        fruits.add("Banana");
        fruits.add("apple");
        fruits.add("watermelon");

        Function<List<String>, Set<String>> setFunction = (FruitsList) -> new HashSet<>(FruitsList);
        System.out.println(setFunction.apply(fruits));


    }
}