/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.projekt;

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
import javafx.stage.Stage;

/**
 *
 * @author Conrad
 */
public class AccInfoController implements Initializable {

   private final ObservableList
            currentlist=FXCollections.observableArrayList();
    @FXML
    private Button cancelButton;
    @FXML
    private ListView listView1;

    @FXML
    private void cancel(ActionEvent event) throws IOException {

        Stage stage = (Stage) cancelButton.getScene().getWindow();

        stage.close();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        if(MainpageController.isCreditAccount){
           CreditAccount creditInput = new CreditAccount();
            
            for(int i = 0; i < 4; i++){
                if (i==0){
                    String a ="Account type: " +creditInput.getAccountType();
                    currentlist.add(a);
                }
                if (i==1){
                    String a = "Debt interest: " + creditInput.getDebt_interest();
                    currentlist.add(a);
                }
                if (i==2){
                    String a = "Interest" + creditInput.getInterest();
                    currentlist.add(a);
                }
                if(i == 3){
                    String a = "Credit limit: " + creditInput.getLimit();
                    currentlist.add(a);
                }
                
            }
        }
        else{
            SavingsAccount saveInput = new SavingsAccount();
   
             for(int i = 0; i < 4; i++){
                if (i==0){
                    String a ="Account type: " +saveInput.getAccountType();
                    currentlist.add(a);
                }
                if (i==1){
                    String a = "Number of free withdraws: 1";
                    currentlist.add(a);
                }
                if (i==2){
                    String a = "Interest rate: 10%";
                    currentlist.add(a);
                }
                if(i == 3){
                    String a = "Withdraw rate: 2%";
                    currentlist.add(a);
                }
                
            }       
        }
        listView1.setItems(currentlist);
    }
    

}
