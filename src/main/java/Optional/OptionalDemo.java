package Optional;

import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        String email = "akhil@gmail.com";

        //off , empty,ofNullable
        /*Optional<Object> emptyOptional = Optional.empty();
        System.out.println(emptyOptional);

        Optional<String> emialOptional=Optional.of("email");
        System.out.println(emialOptional);*/

        Optional<String> stringOptional = Optional.ofNullable(email);
        String defaultOptional = stringOptional.orElse(null);
       System.out.println(defaultOptional);

        String defaultOptional2 = stringOptional.orElseGet(()->"default@gmail.com");
        System.out.println(defaultOptional2);

        String optionalObject = stringOptional.orElseThrow(() -> new IllegalArgumentException("Email is not exist"));
        System.out.println(optionalObject);

        Optional<String> gender = Optional.of("male");
        Optional<String> emptyOptional = Optional.empty();

        gender.ifPresent((s) -> System.out.println("value is present"));
        emptyOptional.ifPresent((s) -> System.out.println("no value present"));
       /* if(stringOptional.isPresent()){
            System.out.println(stringOptional.get());
        }else{
            System.out.println("no value present");
        }*/
        String result = "abc";
        if(result != null && result.contains("abc")){
            System.out.println(result);
        }
        Optional<String> optionalstr = Optional.of(result);
        optionalstr.filter(res -> res.contains("abc"));
        //.ifPresent((res)-> System.out.println(res));

    }
}
