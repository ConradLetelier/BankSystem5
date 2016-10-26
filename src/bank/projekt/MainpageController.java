/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.projekt;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 *
 * @author Micke
 */
public class MainpageController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private void addCustomer(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("RegCustomer.fxml"));
        Scene s = new Scene(root);
        Stage stg =(Stage)((Node)event.getSource()).getScene().getWindow();
        stg.setScene(s);
        stg.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    
}
