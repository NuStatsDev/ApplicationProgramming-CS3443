package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	/**
	 * The sole purpose of this class is the initial setup of the stage and the scene as well as launching the program.
	 */
	
	public Parent root;
	public static Stage tmpStage;
	@Override
	public void start(Stage primaryStage) {
		try {
			tmpStage = primaryStage;
			root = FXMLLoader.load(getClass().getResource("../application/view/Login.fxml"));
			primaryStage.setTitle("Login");
			primaryStage.setScene(new Scene(root,800,800));
			primaryStage.show();
			primaryStage.setResizable(false);

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	public static void main(String[] args) {
		launch(args);
	}

}
