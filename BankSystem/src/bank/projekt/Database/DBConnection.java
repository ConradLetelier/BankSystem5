/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.projekt.Database;

import bank.projekt.BankLogic;
import bank.projekt.Customer;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Conrad Letelier <Conrad@Letelier.email>
 */
public class DBConnection {

    Connection connection;
    Statement statement;
    String url = "jdbc:mysql://127.0.0.1:3306/bankprojectdatabase?user=root&password=root";

    public DBConnection() {

        try {
            connection = (Connection) DriverManager.getConnection(url);
            statement = connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void initilize() {

        try {

            ResultSet result = statement.executeQuery("select * from customer");
            while (result.next()) {

                String pnr = result.getString(1);

                long newpnr = Long.valueOf(pnr).longValue();

                String name = result.getString(2);

                int id = result.getInt(3);

                Customer input = new Customer(name, newpnr);
                input.setUniqueID(id);
                BankLogic.kunder.add(input);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public long getPersonNumber(long i) {
        long toReturn = 0;

        try {
            // ResultSet result = statement.executeQuery("select name from customer");
            PreparedStatement pr = connection.prepareStatement("select customerID from customer where uniqueid =?");
            pr.setInt(1, (int) i);
            // pr.setLong(1, i);
            ResultSet result = pr.executeQuery();

            while (result.next()) {
                String toReturnx = result.getString(1);
                toReturn = Long.valueOf(toReturnx);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return toReturn;
    }

    public int getAccOwner(int i) {
        int toReturn = 0;
        try {
            PreparedStatement pr = connection.prepareStatement("select Customer_uniqueID from accounts where accountID=?");
            pr.setInt(1, i);
            ResultSet result = pr.executeQuery();
            while (result.next()) {
                toReturn = result.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return toReturn;
    }

    public void removeCustomer(long i) {

        String id = String.valueOf(getCustomerUniqueID(i));

        try {

            String removecustomer = "delete from customer where uniqueID = " + id;
            String removeTrans ="delete from transaction where Accounts_Customer_uniqueID ="+id;
           statement.executeUpdate(removeTrans);
           statement.executeUpdate(removecustomer);
            
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void updateCustomer(String name, long i) {
        String id = String.valueOf(getCustomerUniqueID(i));

        try {
            String updatecustomer = "update customer set name = ? where uniqueID = " + id;
            PreparedStatement psmt = connection.prepareStatement(updatecustomer);
            psmt.setString(1, name);

            psmt.execute();

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void setBal(int i, double x) {
        try {

            statement.executeUpdate("update accounts set balance =" + x + " where accountID =" + i);

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getCustomerUniqueID(long pnr) {
        int toReturn = 0;
        try {
            PreparedStatement pr = connection.prepareStatement("select uniqueID from customer where customerID=?");
            pr.setLong(1, pnr);
            ResultSet result = pr.executeQuery();
            while (result.next()) {
                toReturn = result.getInt(1);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return toReturn;
    }

    public void addCustomer(String name, long pnr) {
        String newPnr = String.valueOf(pnr);
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO customer (customerID,name) VALUES(" + pnr + ",'" + name + "')");

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void removeTrans(int accNr){
        
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("delete from transaction where Accounts_accountID =" + accNr);

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void removeAcc(int accNr) {

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("delete from accounts where accountID =" + accNr);

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void addAccount(int accountID, double balance, int isSav, int isCred, int amountOfWithdraws, long pnr) {
        String newPnr = String.valueOf(pnr);
        int uniqueID = getID(pnr);
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO accounts (accountID,balance,isSav,isCred,ammountOfWithdraws,Customer_uniqueID)"
                    + " VALUES(" + accountID + "," + balance + "," + isSav + "," + isCred + "," + amountOfWithdraws + "," + uniqueID + ")");

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<Integer> getAccNr() {
        ArrayList<Integer> toReturn = new ArrayList<Integer>();

        try {
            PreparedStatement pr = connection.prepareStatement("select * from accounts");
            ResultSet result = pr.executeQuery();
            while (result.next()) {
                toReturn.add(result.getInt(1));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return toReturn;

    }

    public double getBal(int i) {
        double toReturn = 0;
        try {
            PreparedStatement pr = connection.prepareStatement("select balance from accounts where accountID=?");
            pr.setInt(1, i);
            ResultSet result = pr.executeQuery();
            while (result.next()) {
                toReturn = result.getDouble(1);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return toReturn;
    }

    public void setWiths(int i, int x) {
       
        try {

            statement.executeUpdate("update accounts set ammountOfWithdraws =" + x + " where accountID =" + i);

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int getTransCount(int x){
       int toReturn = 0;
        try {
            PreparedStatement pr = connection.prepareStatement("select count(ammount) from transaction where Accounts_accountID=?");
            pr.setInt(1, x);
            ResultSet result = pr.executeQuery();
            while (result.next()) {
                toReturn = result.getInt(1);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return toReturn;   
    }
    public void addTrans(double amount, double balance,String day, String type, int accNr, int uniqueID) {
       
        try {

            statement.executeUpdate("insert into transaction (ammount,balance,day,type,Accounts_accountID,Accounts_Customer_uniqueID) VALUES ("+amount+","+balance+",'"+day+"','"+type+"',"+accNr+","+uniqueID+")");

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<String> getTrans(int accNr){
           ArrayList<String> toReturn = new ArrayList<String>();
        try {
          ResultSet result=  statement.executeQuery("select * from transaction where Accounts_accountID ="+accNr);
        while(result.next()){
            String amount=String.valueOf(result.getInt(2));
            String balance=String.valueOf(result.getInt(3));
            String time = result.getString(4);
            String date = result.getString(5);
            String type = result.getString(6);
            toReturn.add(accNr+","+amount+","+ balance+","+type+","+date);
        }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
   return toReturn;
    }
    public int getWiths(int i) {
        int toReturn = 0;
        try {
            PreparedStatement pr = connection.prepareStatement("select ammountOfWithdraws from accounts where accountID=?");
            pr.setInt(1, i);
            ResultSet result = pr.executeQuery();
            while (result.next()) {
                toReturn = result.getInt(1);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return toReturn;
    }

    public int getAccTypeSavings(int i) {
        int toReturn = 0;
        try {
            PreparedStatement pr = connection.prepareStatement("select isSav from accounts where accountID=?");
            pr.setInt(1, i);
            ResultSet result = pr.executeQuery();
            while (result.next()) {
                toReturn = result.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return toReturn;
    }

    public static void addCust(String name, long pnr) {
        DBConnection con = new DBConnection();
        con.addCustomer(name, pnr);
    }

    public static int getID(long i) {
        int toReturn = 0;
        try {
            DBConnection con = new DBConnection();
            toReturn = con.getCustomerUniqueID(i);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return toReturn;
    }

    public static long getPNR(int i) {
        long toReturn = 0;
        try {
            DBConnection con = new DBConnection();
            toReturn = con.getPersonNumber(i);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return toReturn;
    }

    public static void addAcc(int accountID, double balance, int isSav, int isCred, int amountOfWithdraws, long pnr) {
        DBConnection con = new DBConnection();
        con.addAccount(accountID, balance, isSav, isCred, amountOfWithdraws, pnr);
    }

    public static int getAccountOwner(int i) {
        DBConnection con = new DBConnection();
        int x = con.getAccOwner(i);
        return x;
    }

    public static int getAccountType(int i) {
        DBConnection con = new DBConnection();
        int x = con.getAccTypeSavings(i);
        return x;
    }

    public static void initilizeCustomerList() {
        DBConnection con = new DBConnection();
        con.initilize();
    }

    public static double getBalance(int accNr) {
        DBConnection con = new DBConnection();
        double x = con.getBal(accNr);
        return x;
    }

    public static void setBalance(int accNr, double balance) {
        DBConnection con = new DBConnection();
        con.setBal(accNr, balance);
    }

    public static int getWithdraws(int accNr) {
        DBConnection con = new DBConnection();
        int x = con.getWiths(accNr);
        return x;
    }

    public static void setWithdraws(int accNr, int amount) {
        DBConnection con = new DBConnection();
        con.setWiths(accNr, amount);
    }

    public static void removeAccount(int accNr) {
        DBConnection con = new DBConnection();
        con.removeAcc(accNr);
    }

    public static ArrayList<Integer> getAllAccountNumbers() {
        ArrayList<Integer> toReturn;
        DBConnection con = new DBConnection();
        toReturn = con.getAccNr();
        return toReturn;
    }
       public static void removeTransaction(int accNr) {

        DBConnection remove = new DBConnection();

        remove.removeTrans(accNr);

    }

    public static void removeStatic(long id) {

        DBConnection remove = new DBConnection();

        remove.removeCustomer(id);

    }

    public static void updateStatic(String name, long id) {

        DBConnection update = new DBConnection();
        update.updateCustomer(name, id);
    }
    public static ArrayList<String> getTransactions(int accNr){
        DBConnection con = new DBConnection();
        ArrayList<String> toReturn = con.getTrans(accNr);
        return toReturn;
    }
    public static void addTransaction(double amount, double balance,String day, String type, int accNr, int uniqueID){
        DBConnection con = new DBConnection();
        con.addTrans(amount, balance, day, type, accNr, uniqueID);
    }
    public static int getTransactionCount(int accNr){
        DBConnection con = new DBConnection();
        int x =con.getTransCount(accNr);
        return x;
    }
}
