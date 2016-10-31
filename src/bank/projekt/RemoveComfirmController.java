/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.projekt;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ULTRA
 */
public class RemoveComfirmController implements Initializable {
    
    public static boolean removeChecker = false;
    @FXML
    private Button yesremove;
    @FXML
    private Button cancel;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleyesremove(ActionEvent event) {
        removeChecker=true;
         Stage stage = (Stage) yesremove.getScene().getWindow();

        stage.close();
    
    }

    @FXML
    private void handlecancel(ActionEvent event) {
        
         Stage stage = (Stage) cancel.getScene().getWindow();

        stage.close();
    }
    
}
