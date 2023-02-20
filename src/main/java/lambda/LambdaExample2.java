package lambda;
interface Shape1{
    void draw();

}
class Rectangle implements Shape1{


    @Override
    public void draw() {

    }
}

public class LambdaExample2 {
    public static void main(String[] args) {
        Shape1 rectangle = () -> {
            System.out.println(" rectangle draw method");

        };
        rectangle.draw();

    }
}
