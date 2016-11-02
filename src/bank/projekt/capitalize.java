/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.projekt;

import java.util.regex.Pattern;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.geometry.Rectangle2D;
import javafx.scene.text.Font;

/**
 *
 * @author Micke
 */
public class capitalize {

    public static String capitalize(String input){
        String to_return = "";
        int count = 0;
        
        if(!input.equals("")){
            String[] parts = new String[2];
            try{
                parts = input.split(" ");
          

                for(int i = 0; i < parts.length ; i++){
                    parts[i] = parts[i].toLowerCase();
                    
                to_return += Character.toUpperCase(parts[i].charAt(0)) + parts[i].substring(1);
                if(i < 1){
                    to_return += " ";
                }
                count += 1;
                
            }
                if(count == 1 || count > 2){
                    return " ";
                }
            }
            catch(Exception e){
                return to_return;
            }
            
            
        }
        
        
        
    return to_return;
    }
    
    public static String Sortera(TextField box1){
        
            
            String toUse = box1.getText();
            toUse = toUse.replaceAll("[^a-zA-Z -]", "");
            
           
            toUse = toUse.trim().replaceAll(" +", " ");
       
            return toUse;

    }
    
    public static String SorteraNummer(TextField box2){
        String toUse = box2.getText();
        toUse = toUse.replaceAll("[^0-9]", "");
        
        toUse = toUse.trim().replaceAll(" +", "");
        return toUse;
    }
    
    public static void SetButtons(TextField box1, Button confirmed1, Button confirmed2, Label errorLabel2, String button){
        if(box1.getText().length() == 0 || box1.getText().equals(" ")){
                confirmed1.setText("Failed");
                confirmed1.setStyle("-fx-font: 20 arial; -fx-base: #FF0000;");
                if(button.equals("Ny Kund")){
                    if(box1.getText().equals(" ")){
                    errorLabel2.setText("You must provide a First Name and a Last Name");
                }
                else{
                    errorLabel2.setText("You cannot have a Blank Name");
                }
            }
        }
            else{
                errorLabel2.setText("");
                confirmed1.setText("Accepted");
                confirmed1.setStyle("-fx-font: 20 arial; -fx-base: #006000;");
            }
    }
    
    public static void setLabelofButtons(Button label, String name, double X, double Y, int height, int width, Rectangle2D rect){
        label.setText(name);
        label.setLayoutX(rect.getWidth()/X);
        label.setLayoutY(rect.getHeight()/Y);
        label.setMinHeight(height);
        label.setMinWidth(width);
    }
    
    public static void setLabelofLabels(Label label, String name, double X, double Y, int height, int width, Rectangle2D rect){
        label.setText(name);
        label.setLayoutX(rect.getWidth()/X);
        label.setLayoutY(rect.getHeight()/Y);
        label.setMinHeight(height);
        label.setMinWidth(width);
        label.setFont(Font.font("Arial Black", 20));
    }
}
