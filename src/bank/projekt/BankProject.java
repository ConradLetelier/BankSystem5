/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.projekt;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.Screen;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;

/**
 *
 * @author Micke
 */
public class BankProject extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
//        
//        boolean both = false;
//        Pane root = new Pane();
//        
//        ObservableList<String> names = FXCollections.observableArrayList("Mikael Rusin pNr : 5555");
//          
//        Scene scene = new Scene(root);
//        ListView<String> listView = new ListView<>(names);
//        Label label2 = new Label(listView.getSelectionModel().getSelectedItem());
//        TextField box1 = new TextField();
//        TextField box2 = new TextField();
//        
//        
//        Label label1 = new Label("The Current Selected Customer is: ");
//        
//        Label warningLabel1 = new Label("Numbers/Special Characters are sorted away from the Input.");
//        Label warningLabel2 = new Label("Letters/Special Characters are sorted away from the Input.");
//        
//        
//        Label label3 = new Label("What would you like to name the Customer?");
//        
//        Label errorLabel1 = new Label("Customers cannot have Blank Names");
//        errorLabel1.setTextFill(Color.RED);
//        
//        Label errorLabel2 = new Label("Temp");
//        errorLabel2.setTextFill(Color.RED);
//        
//        Pane root2 = new Pane();
//        
//        Pane root3 = new Pane();
//        
//        Button changeName = new Button();
//        Button Back = new Button();
//        Button Rename = new Button();
//        
//        HBox hb = new HBox();
//        Button closeAccount = new Button();
//        Button withdraw = new Button();
//        Button newAcc = new Button();
//        Button deposit = new Button();
//        Button nyKund = new Button();
//        
//        Button confirmed1 = new Button();
//        Button confirmed2 = new Button();
//        Button confirmed3 = new Button();
//        
//   
//        
//        try{root.getChildren().add(changeName);
//        root.getChildren().add(listView);
//        }
//        catch(Exception e){
//            
//        }
//        
//        Scene scene2 = new Scene(root2);
//        
//        Scene scene3 = new Scene(root3);
//        
//        root2.getChildren().add(label1);
//        root2.getChildren().add(label2);
//        root2.getChildren().add(label3);
//        root2.getChildren().add(Rename);
//        root2.getChildren().add(warningLabel1);
//        
//        root3.getChildren().add(label1);
//        root3.getChildren().add(box1);
//        root3.getChildren().add(Back);
//        root3.getChildren().add(box2);
//        root3.getChildren().add(label2);
//        root3.getChildren().add(confirmed1);
//        root3.getChildren().add(confirmed2);
//        root3.getChildren().add(confirmed3);
//        root3.getChildren().add(warningLabel1);
//        root3.getChildren().add(warningLabel2);
//        root3.getChildren().add(errorLabel1);
//        root3.getChildren().add(errorLabel2);
//        
//        
//        confirmed1.setFont(Font.font("Arial Black", 20));
//        confirmed2.setFont(Font.font("Arial Black", 20));
//        confirmed3.setFont(Font.font("Arial Black", 20));
//        
//        
//        
//
//        
//        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
//        stage.setWidth(primaryScreenBounds.getWidth());
//        stage.setHeight(primaryScreenBounds.getHeight());
//        
//        bank.projekt.capitalize.setLabelofButtons(Back, "Ändra namn för Vald Kund", 18, 1.225, 40, 50, primaryScreenBounds);
//        
//        bank.projekt.capitalize.setLabelofButtons(confirmed1, "check", 1.6, 3, 40, 50, primaryScreenBounds);
//        
//        
//        confirmed1.setOnAction(new EventHandler<ActionEvent>(){
//        @Override
//        public void handle(ActionEvent event){
//            System.out.println("BUTTON 1");
//            
//            box1.setText(bank.projekt.capitalize.Sortera(box1));
//            bank.projekt.capitalize.SetButtons(box1, confirmed1,confirmed2, errorLabel2, "Ny Kund");
//            
//           
//        }
//    });
//        
//        bank.projekt.capitalize.setLabelofButtons(confirmed2, "check", 1.6, 1.7, 40, 50, primaryScreenBounds);
//        
//        confirmed2.setOnAction(new EventHandler<ActionEvent>(){
//        @Override
//        public void handle(ActionEvent event){
//            System.out.println("BUTTON 2");
//            String toUse = box2.getText();
//            toUse = toUse.replaceAll("[^0-9]", "");
//            if(toUse.length() > 0){
//                long number2 = Long.parseLong(toUse);
//            }
//            if(toUse.length() < 8){
//                confirmed2.setText("Failed");
//                confirmed2.setStyle("-fx-font: 20 arial; -fx-base: #FF0000;");
//                box2.setText(toUse);
//            }
//            else{
//                confirmed2.setText("Accepted");
//                confirmed2.setStyle("-fx-font: 20 arial; -fx-base: #006000;");
//            }
//           
//        }
//    });
//
//        bank.projekt.capitalize.setLabelofButtons(confirmed3, "Add Customer", 2.25, 2.3, 40, 50, primaryScreenBounds);
//        
//        confirmed3.setOnAction(new EventHandler<ActionEvent>(){
//        @Override
//        public void handle(ActionEvent event){
//            System.out.println("BUTTON 3");
//            boolean check1, check2 = false;
//            
//            String toUse = box1.getText();
//            String toUse2 = toUse.replaceAll("[^a-zA-Z ]", "");
//            if(toUse.length() == 0){
//                errorLabel2.setText("Blank names are not allowed.");
//            
//            }
//            
//            else if(toUse2.length() < 3){
//                errorLabel2.setText("The name must contain at least three letters.");
//                box1.setText(toUse2);
//                
//            }
//            if(toUse.length() > 0 && toUse2.length() > 2){
//                confirmed1.setText("Accepted");
//                confirmed1.setStyle("-fx-font: 20 arial; -fx-base: #006000;");
//                errorLabel2.setText("");
//                box1.setText(toUse2);
//                check1 = true;
//            }
//            else{
//                confirmed1.setText("Failed");
//                confirmed1.setStyle("-fx-font: 20 arial; -fx-base: #FF0000;");
//            }
//            
//            check1 = false;
//            toUse = box2.getText();
//            toUse = toUse.replaceAll("[^0-9]", "");
//            if(toUse.length() != 8){              
//                confirmed2.setText("Failed");
//                confirmed2.setStyle("-fx-font: 20 arial; -fx-base: #FF0000;");
//                errorLabel1.setText("The Social Security number must consist of 8 numbers.");
//                
//            }
//            else{
//                long number = Long.parseLong(toUse); 
//                confirmed2.setText("Accepted");
//                confirmed2.setStyle("-fx-font: 20 arial; -fx-base: #006000;");
//                errorLabel1.setText("");
//                check1 = true;
//            }
//            
//            if(check1){
//                System.out.println("Check passed.");
//            }
//           
//        }
//    });
//        
//        
//        bank.projekt.capitalize.setLabelofLabels(label2, "Sätta in pengar för Vald Kund", 2.5, 2.3, 40, 50, primaryScreenBounds);
//        
//        
//        
//        bank.projekt.capitalize.setLabelofLabels(label3, "What would you like to name the Customer?", 2.5, 2, 40, 50, primaryScreenBounds);
//        
//        
//
//        bank.projekt.capitalize.setLabelofLabels(label1, label1.getText(), 2.5, 2.5, 40, 50, primaryScreenBounds);
//        
//        box1.setLayoutX(primaryScreenBounds.getWidth()/2.5);
//        box1.setLayoutY(primaryScreenBounds.getHeight()/1.85);
//        box1.setMinHeight(40);
//        box1.setMinWidth(400);
//        
//        
//        
//        box2.setLayoutX(primaryScreenBounds.getWidth()/2.5);
//        box2.setLayoutY(primaryScreenBounds.getHeight()/1.85);
//        box2.setMinHeight(40);
//        box2.setMinWidth(400);
//        
//        errorLabel1.setLayoutX(primaryScreenBounds.getWidth()/2.5);
//        errorLabel1.setLayoutY(primaryScreenBounds.getHeight()/1.6);
//        errorLabel1.setMinHeight(40);
//        errorLabel1.setMinWidth(50);
//
//        errorLabel1.setFont(Font.font("Arial Black", 20));
//        
//        errorLabel2.setLayoutX(primaryScreenBounds.getWidth()/2.5);
//        errorLabel2.setLayoutY(primaryScreenBounds.getHeight()/2.7);
//        errorLabel2.setMinHeight(40);
//        errorLabel2.setMinWidth(50);
//
//        errorLabel2.setFont(Font.font("Arial Black", 20));
//        
//        warningLabel1.setLayoutX(primaryScreenBounds.getWidth()/3);
//        warningLabel1.setLayoutY(primaryScreenBounds.getHeight()/3);
//        warningLabel1.setMinHeight(40);
//        warningLabel1.setMinWidth(50);
//
//        warningLabel1.setFont(Font.font("Arial Black", 20));
//        
//        warningLabel2.setLayoutX(primaryScreenBounds.getWidth()/3);
//        warningLabel2.setLayoutY(primaryScreenBounds.getHeight()/1.5);
//        warningLabel2.setMinHeight(40);
//        warningLabel2.setMinWidth(50);
//
//        warningLabel2.setFont(Font.font("Arial Black", 20));
//        
//        
//        bank.projekt.capitalize.setLabelofButtons(changeName, "Ändra namn på Vald Kund", 18, 1.225, 40, 50, primaryScreenBounds);
//        
//        
//        
//        bank.projekt.capitalize.setLabelofButtons(Back, "Back", 18, 1.225, 40, 50, primaryScreenBounds);
//
//        
//        bank.projekt.capitalize.setLabelofButtons(Rename, Rename.getText(), 2.25, 1.65, 40, 50, primaryScreenBounds);
//
//        
//        changeName.setOnAction(new EventHandler<ActionEvent>(){
//        @Override
//        public void handle(ActionEvent event){
//            System.out.println("BUTTON 4");
////            System.out.println(listView.getSelectionModel().getSelectedItem()); //Use this to get the Selected index of a ListView
//            if(names.size() > 0 && listView.getSelectionModel().getSelectedItem() != null){
//
//                
//                try{
//                    root2.getChildren().add(label1);
//                    root2.getChildren().add(box1);
//                    hb.setSpacing(10);
//                }
//                catch(Exception e){}
//                try{
//                    root2.getChildren().add(Back);
//                
//                root2.getChildren().add(box1);
//                stage.setScene(scene2);
//                }
//                catch(Exception e){
//                    stage.setScene(scene2);
//                }
//                stage.setTitle("The Java Bank (tm)");
//                
//                stage.show();
//            }
//            
//           
//        }
//    });
//        bank.projekt.capitalize.setLabelofButtons(closeAccount, "Stäng konto för Vald kund", 18, 1.15, 40, 50, primaryScreenBounds);
//
//        bank.projekt.capitalize.setLabelofButtons(withdraw, "Ta ut pengar för Vald kund", 3.75, 1.15, 40, 50, primaryScreenBounds);
//
//        bank.projekt.capitalize.setLabelofButtons(newAcc, "Öppna nytt konto för Vald Kund", 6.5, 1.15, 40, 50, primaryScreenBounds);
//
//        bank.projekt.capitalize.setLabelofButtons(deposit, "Sätta in pengar för Vald Kund", 2.75, 1.15, 40, 50, primaryScreenBounds);
//        bank.projekt.capitalize.setLabelofButtons(nyKund, "Lägga till Ny Kund", 6.5, 1.225, 40, 50, primaryScreenBounds);
//
//        
//        
//        
//        try{
//            root.getChildren().add(closeAccount);
//        
//        root.getChildren().add(withdraw);
//        root.getChildren().add(newAcc);
//        root.getChildren().add(deposit);
//        root.getChildren().add(nyKund);
//        }
//        catch(Exception e){
//                
//                }
//        
//        nyKund.setOnAction(new EventHandler<ActionEvent>(){
//        @Override
//        public void handle(ActionEvent event){
//            
//            
//            warningLabel1.setLayoutX(primaryScreenBounds.getWidth()/3);
//            warningLabel1.setLayoutY(primaryScreenBounds.getHeight()/3.5);
//            
//            warningLabel2.setLayoutY(primaryScreenBounds.getHeight()/1.85);
//            
//       
//       
//            
//            
//            label1.setText("Please provide the name of the New Customer:");
//            
//            label2.setText("Please provide the 8 first digits of the persons Social Security Number:");
//            label2.setLayoutX(primaryScreenBounds.getWidth()/3);
//            label2.setLayoutY(primaryScreenBounds.getHeight()/2);
//            
//            label1.setLayoutX(primaryScreenBounds.getWidth()/2.7);
//            label1.setLayoutY(primaryScreenBounds.getHeight()/4);
//            box1.setLayoutY(primaryScreenBounds.getHeight()/3);
//            box2.setLayoutX(primaryScreenBounds.getWidth()/2.5);
//            box2.setLayoutY(primaryScreenBounds.getHeight()/1.7);
//            
//            
//   
//            stage.setScene(scene3);
//            stage.show();
//            
// 
//        }
//    });
//        Back.setOnAction(new EventHandler<ActionEvent>(){
//        @Override
//        public void handle(ActionEvent event){
//            try{
//                confirmed1.setText("Check");
//                confirmed1.setStyle("-fx-font: 20 arial; -fx-base: #DEDEDE;");
//                confirmed2.setText("Check");
//                confirmed2.setStyle("-fx-font: 20 arial; -fx-base: #DEDEDE;");
//                box1.setText("");
//                box2.setText("");
//                errorLabel1.setText("");
//                stage.setScene(scene);
//            
//            stage.show();
//            }
//            catch(Exception e){
//                
//            }
//            };   
//    });
//        
//        Rename.setOnAction(new EventHandler<ActionEvent>(){
//        @Override
//        public void handle(ActionEvent event){
//            String text = box1.getText(); 
//            text = text.replaceAll("[^a-zA-Z]", "");
//            
//           
//            
//            String text2 = label2.getText();
//            
//            text2 = text2.replaceAll("[^0-9]", "");
//            System.out.println(text2);
//            
//            
//            long number = Long.parseLong(text2);
//            BankLogic.changeCustomerName(text, number);
//            if(!text.equals("")){
//                label2.setText(text + "     pNr: " + number);
//            }
//            else{
//                if(box1.getText().replaceAll("[^0-9]", "").length() > 0){
//                    errorLabel1.setText("The remainder of the Name cannot be numbers.");
//                }
//                else if(text.equals("")){
//                    errorLabel1.setText("Blank names are not allowed.");
//                }
//                try{
//                    root2.getChildren().add(errorLabel1);
//                }
//                catch(Exception e){
//            }
//            }
//
//            };     
//    });
//  
//        listView.setLayoutY(primaryScreenBounds.getHeight()/20);
//        listView.setLayoutX(primaryScreenBounds.getWidth()/20);
//
//        stage.setTitle("The Java Bank (tm)");
//        stage.setScene(scene);
//        stage.show();

   Parent root = FXMLLoader.load(getClass().getResource("Test.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("Bank System");
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       launch(args);
      
        
    }
    
}
