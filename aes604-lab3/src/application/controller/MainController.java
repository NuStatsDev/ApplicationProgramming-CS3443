package application.controller;

import application.model.Fleet;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.io.IOException;

/**
 * Name: MainController()
 * Description: controls all the processes of the main screen
 */
public class MainController implements EventHandler<ActionEvent> {
    Fleet f1;
    @FXML Button submitButton;
    @FXML TextArea outTextArea;
    @FXML TextField inTextField;
    /**
     *  Constructor initializes the fleet and loads in the data needed to populate the fleet
     * @throws IOException
     */
    public MainController() throws IOException {
        f1 = new Fleet("United Federation of Planets");
    }

    /**
     * Name: handleButton()
     * Description: only action that this app provides, just takes in some text and displays some text depending on the
     *              text taken in at the push of a button
     * @param event
     */
    @FXML protected void handleButton(ActionEvent event) {
        String check = inTextField.getText();
        if(check.length() > 5){
            if (check.substring(0, 4).toUpperCase().equals("USS ")) {
                check = check.substring(4);
            }
            check = (check.charAt(0)+"").toUpperCase() + (check.substring(1)).toLowerCase();
        }
        outTextArea.setText( f1.getRequestedStarships("USS "+check));
    }

    @Override
    public void handle(ActionEvent actionEvent) {
    }
}
