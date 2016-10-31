/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.projekt;

import static bank.projekt.MainpageController.data;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Conrad
 */
public class RegCustomerController implements Initializable {

    @FXML
    private Button cancelButton;
    @FXML
    private TextField txtfirstname;
    @FXML
    private TextField txtpn;
    @FXML
    private Button register;
    @FXML
    private Button clear;
    @FXML
    private TextField txtlastname;
    @FXML
    private Label notification;

    private void cancel(ActionEvent event) throws IOException {

        Stage stage = (Stage) cancelButton.getScene().getWindow();

        stage.close();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleregister(ActionEvent event) throws IOException {
    if(txtfirstname.getText().isEmpty() || txtlastname.getText().isEmpty() || txtpn.getText().isEmpty()){
    notification.setText("Fill all the values");
    
    
    }
    else{
       
        
        BankLogic.addCustomer(txtfirstname.getText(), Integer.parseInt(txtpn.getText()));
        

            Customer listCust = new Customer(txtfirstname.getText(), Integer.parseInt(txtpn.getText()));
            data.add(listCust);

        
        
           
    }
    Stage stage = (Stage) cancelButton.getScene().getWindow();
    stage.close();
    
    }

    @FXML
    private void handleclear(ActionEvent event) {
    txtfirstname.setText("");
    txtlastname.setText("");
    txtpn.setText("");
    
    }

    @FXML
    private void handelcancel(ActionEvent event) throws IOException {
   
           Stage stage = (Stage) cancelButton.getScene().getWindow();

        stage.close();
    
    }

}
