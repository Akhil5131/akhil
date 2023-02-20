package lambda;

interface Shape{
    void draw();
}

class Circle implements Shape{

    @Override
    public void draw() {
        System.out.println("Circle class : draw() method");
    }
}
public class LambdaExample {
    public static void main(String[] args) {

        Shape Rectangle = () -> System.out.println("Rectangle class : draw() method");
                //Rectangle.draw();
                Shape Square = () -> System.out.println("Square class : draw() method");
                //Square.draw();
        Shape Circle = () -> System.out.println("Circle class : draw() method");
        //Circle.draw();

        print1 (Rectangle);
        print1 (Square);
        print1(Circle);

    }
    private static void print1(Shape shape){
        shape.draw();
    }
}
