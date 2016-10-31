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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Conrad
 */
public class MainpageController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private Button regButton;
    @FXML
    private Button removeCustomerButton;
    @FXML
    private Button removeAccountButton;
    @FXML
    private Button changeCustomerButton;
    @FXML
    private Button withdrawButton;
    @FXML
    private Button depositButton;
    @FXML
    private  TableView<Customer> table1;
    @FXML
    private TableView<SavingsAccount> table2;
    @FXML
    private TableColumn<SavingsAccount, String> accountTypeColumn;
    @FXML
    private TableColumn<SavingsAccount, Integer> idColumn;
    @FXML
    private TableColumn<SavingsAccount, Double> balanceColumn;
    @FXML
    private TableColumn<Customer, String> NameColumn;
    @FXML
    private TableColumn<Customer, Long> pnrColumn;
    
 

    //Table data
    public static ObservableList<Customer> data = FXCollections.observableArrayList();
    public static ObservableList<SavingsAccount> data2 = FXCollections.observableArrayList();

    @FXML
    private void addCustomer(ActionEvent event) throws IOException {

        Stage stage;
        Parent root;

        stage = new Stage();
        root = FXMLLoader.load(getClass().getResource("RegCustomer.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Register new customer");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(regButton.getScene().getWindow());
        stage.showAndWait();

    }
     @FXML
    private void removeCustomer(ActionEvent event) throws IOException {

        Stage stage;
        Parent root;

        stage = new Stage();
        root = FXMLLoader.load(getClass().getResource("RemoveComfirm.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Comfirm");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(removeCustomerButton.getScene().getWindow());
        stage.showAndWait();

    }
     @FXML
    private void changeCustomer(ActionEvent event) throws IOException {

        Stage stage;
        Parent root;
        stage = new Stage();
        root = FXMLLoader.load(getClass().getResource("ChangeCustomer.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Modify customer");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(changeCustomerButton.getScene().getWindow());
        stage.showAndWait();

    }
       @FXML
    private void removeAccount(ActionEvent event) throws IOException {

        Stage stage;
        Parent root;
        stage = new Stage();
        root = FXMLLoader.load(getClass().getResource("RemoveComfirm.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Comfirm");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(removeAccountButton.getScene().getWindow());
        stage.showAndWait();

    }
       @FXML
    private void withdraw(ActionEvent event) throws IOException {

        Stage stage;
        Parent root;
        stage = new Stage();
        root = FXMLLoader.load(getClass().getResource("Withdraw.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Withdraw");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(withdrawButton.getScene().getWindow());
        stage.showAndWait();

    }
       @FXML
    private void deposit(ActionEvent event) throws IOException {

        Stage stage;
        Parent root;
        stage = new Stage();
        root = FXMLLoader.load(getClass().getResource("Deposit.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Deposit");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(depositButton.getScene().getWindow());
        stage.showAndWait();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Customer a = new Customer("Frank", 232);
        SavingsAccount b = new SavingsAccount(12);
        data2.add(b);
        BankLogic.kunder.add(a);

        for (int i = 0; i < BankLogic.kunder.size(); i++) {

            Customer listCust = new Customer(BankLogic.kunder.get(i).getName(), BankLogic.kunder.get(i).getPnr());
            data.add(listCust);

        }
        NameColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("Name"));
        pnrColumn.setCellValueFactory(new PropertyValueFactory<Customer, Long>("pnr"));
        accountTypeColumn.setCellValueFactory(new PropertyValueFactory<SavingsAccount, String>("accountType"));
        idColumn.setCellValueFactory(new PropertyValueFactory<SavingsAccount, Integer>("kontoNummer"));
        balanceColumn.setCellValueFactory(new PropertyValueFactory<SavingsAccount, Double>("saldo"));

        
        table1.setItems(data);
        table2.setItems(data2);

    }
    
    
}

