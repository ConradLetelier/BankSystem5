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
// * @author Conrad
 */
public class ChangeController implements Initializable {
    @FXML
    private Button cancelButton;
    @FXML
    private TextField txtfirstname;
    @FXML
    private TextField txtpn;
    @FXML
    private Button change;
    @FXML
    private Button clear;
    @FXML
    private TextField txtlastname;
    @FXML
    private Label notification1;

    @FXML
    private void cancel(ActionEvent event) throws IOException {
 
        
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
       
    }
    
    @FXML
    private void reset(ActionEvent event) throws IOException{
        
    }
    
    @FXML
    private void clear(ActionEvent event) throws IOException{
        txtfirstname.setText("");
        txtlastname.setText("");
        
    }
    
@FXML
 
    private void changename(ActionEvent event) throws IOException {

 
    try{
        if(txtfirstname.getText().isEmpty() || txtlastname.getText().isEmpty() || txtpn.getText().isEmpty()){
            notification1.setText("Empty fields. Try again");
    }
    else{
       
        String toUse = bank.projekt.capitalize.Sortera(txtfirstname);
        txtfirstname.setText(toUse);
        
        if(toUse.length() == 0){
                throw new Exception();
        }
        
        toUse = bank.projekt.capitalize.Sortera(txtlastname);
        txtlastname.setText(toUse);
        
        if(toUse.length() == 0){
                throw new Exception();
        }
        
        String pNr = txtpn.getText();
        pNr = pNr.replaceAll("[^0-9]", "");
        txtpn.setText(pNr);
        
        if(pNr.length() == 0){
            throw new Exception();
        }
        
        data.setAll(bank.projekt.BankLogic.kunder);
        Long pNr_input = Long.parseLong(pNr);
        toUse = txtfirstname.getText() + " " + txtlastname.getText();
        if(bank.projekt.BankLogic.changeCustomerName(toUse, pNr_input) == true){
            Stage stage = (Stage) cancelButton.getScene().getWindow();
            stage.close();
        }
        else{
            notification1.setText("Empty fields. Try again");
        }
        }
    }
    catch(Exception e){
        notification1.setText("Empty fields. Try again");
    }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String pNr = Long.toString(MainpageController.CustomerPNR);
        txtpn.setText(pNr);
    }

}
