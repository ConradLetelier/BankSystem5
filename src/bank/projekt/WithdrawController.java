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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Conrad
 */
public class WithdrawController implements Initializable {

    @FXML
    private Button withdrawButton;
    @FXML
    private Button cancelButton;
    @FXML
    private TextField amountField;

    @FXML
    private void cancel(ActionEvent event) throws IOException {

        Stage stage = (Stage) cancelButton.getScene().getWindow();

        stage.close();

    }
       @FXML
    private void withdraw(ActionEvent event) throws IOException {

        MainpageController.withdrawAmount = Integer.parseInt(amountField.getText());
        Stage stage = (Stage) withdrawButton.getScene().getWindow();
        stage.close();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
