module com.example.lambdaexpression {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lambdaexpression to javafx.fxml;
    exports com.example.lambdaexpression;
}