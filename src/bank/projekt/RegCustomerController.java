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
        Customer listCust;
        boolean pass = false;
        String special = "";
    
        
        
        
    if(txtfirstname.getText().isEmpty() || txtlastname.getText().isEmpty() || txtpn.getText().isEmpty()){
        notification.setText("Fill all the values");
      System.err.println("One/More of the inputs, are empty.");

  
    }
    
    try{
                
            
            
        String name = capitalize.Sortera(txtfirstname);
       
        txtfirstname.setText(name);
         if(name.length() == 0){
            throw new Exception();
        }
        name = capitalize.Sortera(txtlastname);
        
        txtlastname.setText(name);
        
         if(name.length() == 0){
            throw new Exception();
        }
        
        name = capitalize.SorteraNummer(txtpn);
        
        
        txtpn.setText(name);
        
        if(name.length() == 0){
            throw new Exception();
        }
        
//        listCust = new Customer(txtfirstname.getText() + " " + txtlastname.getText(), Long.parseLong(txtpn.getText()));
        if(!BankLogic.addCustomer(txtfirstname.getText() + " " + txtlastname.getText(), Long.parseLong(txtpn.getText()))){
            special = "1";
            throw new Exception();
        };
            
//            data.add(listCust);
            
            pass = true;
        }
        catch(Exception e){
            pass = false;
            if(special.equals("")){
           notification.setText("One of the inputs, ended up being empty. Please try again.");
                System.err.println("One of the inputs, ended up being empty. Please try again.");
            }
        }
 
    
           
    if(pass){
    Stage stage = (Stage) cancelButton.getScene().getWindow();
    stage.close();
    }
    
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
