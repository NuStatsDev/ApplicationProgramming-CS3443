package application;

import javafx.application.Application;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.stage.Stage;


/**
 * Name: Main
 * Description: Driver the the application
 */
public class Main extends Application {
    /**
     * Name: start()
     * Description: does what the name implies and starts the program. its here just for building the bones of the application
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
        //loader.setController(this);
        Parent root = loader.load();
        primaryStage.setTitle("United Federation of Planets - aes604-lab3");
        Scene s1 = new Scene(root, 800, 800);
        primaryStage.setResizable(false);
        primaryStage.setScene(s1);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}