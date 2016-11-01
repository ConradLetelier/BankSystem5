/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.projekt;

import static bank.projekt.RemoveComfirmController.removeChecker;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Conrad
 */
public class MainpageController implements Initializable {

    public static boolean isSavingsAccount = false;
    public static boolean isCreditAccount = false;
    public static int withdrawAmount = 0;
    public static int depositamount = 0;
    @FXML
    private Label labelText;
    @FXML
    private Button regButton;
    @FXML
    private Button addSaveAccButton;
    @FXML
    private Button addCredAccButton;
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
    private Button infoButton;
    @FXML
    private TableView<Customer> table1;
    @FXML
    private TableView<Account> table2;
    @FXML
    private TableColumn<Account, String> accountTypeColumn;
    @FXML
    private TableColumn<Account, Integer> idColumn;
    @FXML
    private TableColumn<Account, Double> balanceColumn;
    @FXML
    private TableColumn<Customer, String> NameColumn;
    @FXML
    private TableColumn<Customer, Long> pnrColumn;
    @FXML
    private TableColumn<Account, Integer> withdrawColumn;
    @FXML
    private TextField nameInputSearch;

    //Table data
    public static ObservableList<Customer> data = FXCollections.observableArrayList();
    public static ObservableList<Account> data2 = FXCollections.observableArrayList();

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

        if (!(table1.getSelectionModel().getSelectedIndex() == -1)) {
            Stage stage;
            Parent root;

            stage = new Stage();
            root = FXMLLoader.load(getClass().getResource("RemoveComfirm.fxml"));
            stage.setScene(new Scene(root));
            stage.setTitle("Comfirm");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(removeCustomerButton.getScene().getWindow());
            stage.showAndWait();

            if (removeChecker) {
                BankLogic.kunder.remove(table1.getSelectionModel().getSelectedIndex());
                data.remove(table1.getSelectionModel().getSelectedIndex());
            }
            removeChecker = false;


        } else {
            labelText.setText("Please choose a customer");

 
        }
    }
    @FXML
    private void addCredAcc(ActionEvent event){
        
    }
    @FXML
    private void addSaveAcc(ActionEvent event) throws IOException{
        if (!(table1.getSelectionModel().getSelectedIndex() == -1)){
           // BankLogic.addSavingsAccount(pnrColumn.getCellData(table1.getSelectionModel().getSelectedIndex()));
           //BankLogic.addSavingsAccount(33);
            System.out.println(BankLogic.addSavingsAccount(33));
           System.out.println((pnrColumn.getCellData(table1.getSelectionModel().getSelectedIndex())));
//         Parent root2 = FXMLLoader.load(getClass().getResource("Test.fxml"));
//            Scene s = new Scene(root2);
//            Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            stg.setScene(s);
//            stg.show();
        }
            else {
            labelText.setText("Please choose a customer");

 
        }
       
        
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
    private void accountInfo(ActionEvent event) throws IOException {
        if (!(table2.getSelectionModel().getSelectedIndex() == -1)) {

            if (table2.getSelectionModel().getSelectedItem().getAcct_type().equals("Savingsaccount")) {
                isSavingsAccount = true;
            } else {
                isCreditAccount = true;
            }

            Stage stage;
            Parent root;
            stage = new Stage();
            root = FXMLLoader.load(getClass().getResource("AccountInfo.fxml"));
            stage.setScene(new Scene(root));
            stage.setTitle("Account Information");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(infoButton.getScene().getWindow());
            stage.showAndWait();
            isCreditAccount = false;
            isSavingsAccount = false;
        } else {
            labelText.setText("Please choose an account");

        }

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
        BankLogic.kunder.get(table1.getSelectionModel().getSelectedIndex()).getName();
    }

    @FXML
    private void withdraw(ActionEvent event) throws IOException {
        if (!(table2.getSelectionModel().getSelectedIndex() == -1)) {
            Stage stage;
            Parent root;
            stage = new Stage();
            root = FXMLLoader.load(getClass().getResource("Withdraw.fxml"));
            stage.setScene(new Scene(root));
            stage.setTitle("Withdraw");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(withdrawButton.getScene().getWindow());
            stage.showAndWait();
            BankLogic a = new BankLogic();

            long pnr = BankLogic.kunder.get(table1.getSelectionModel().getSelectedIndex()).getPnr();
            int accNr = withdrawColumn.getCellData(table2.getSelectionModel().getSelectedIndex());

            a.withdraw(pnr, accNr, withdrawAmount);
            withdrawAmount = 0;
            
        } else {
            labelText.setText("Please choose an account");

        }

    }

    @FXML
    private void deposit(ActionEvent event) throws IOException {
        if (!(table2.getSelectionModel().getSelectedIndex() == -1)) {
            Stage stage;
            Parent root;
            stage = new Stage();
            root = FXMLLoader.load(getClass().getResource("Deposit.fxml"));
            stage.setScene(new Scene(root));
            stage.setTitle("Deposit");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(depositButton.getScene().getWindow());
            stage.showAndWait();

            BankLogic a = new BankLogic();

            long pnr = pnrColumn.getCellData(table1.getSelectionModel().getSelectedIndex());
            int accNr = withdrawColumn.getCellData(table2.getSelectionModel().getSelectedIndex());

            a.deposit(pnr, accNr, depositamount);
            depositamount = 0;
        }
        {
            labelText.setText("Please choose an account");

        }

    }

    @FXML
    public void search(ActionEvent event) throws IOException {
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        NameColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("Name"));
        pnrColumn.setCellValueFactory(new PropertyValueFactory<Customer, Long>("pnr"));
        accountTypeColumn.setCellValueFactory(new PropertyValueFactory<Account, String>("accountType"));
        idColumn.setCellValueFactory(new PropertyValueFactory<Account, Integer>("accountNumber"));
        balanceColumn.setCellValueFactory(new PropertyValueFactory<Account, Double>("balance"));
        withdrawColumn.setCellValueFactory(new PropertyValueFactory<Account, Integer>("ammountOfWithdraws"));
        BankLogic.InitilizeList();
        table1.setItems(data);
        table2.setItems(data2);

    }

}
