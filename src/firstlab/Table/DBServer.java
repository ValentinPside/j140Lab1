/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package firstlab.Table;

import firstlab.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Valentin
 */
public class DBServer implements IDbServer{
    
    public DBServer() throws Exception{
    }
    
    @Override
    public void addNewUser(String name, String lastName, Integer age){
        if(!name.isBlank() && !lastName.isBlank() && age != 0){
            try(Connection conn = DriverManager.getConnection(
                "jdbc:derby://localhost:1527/Users", "Users", "Users")){
                try (PreparedStatement pstmt = conn.prepareStatement(
                    "insert into USERS (NAME, LASTNAME, AGE, USERID) values (?, ?, ?, ?)")) {
                pstmt.setString(1, name);
                pstmt.setString(2, lastName);
                pstmt.setInt(3, age);
                pstmt.setString(4, name + lastName + age);
                pstmt.executeUpdate();
                }
            } catch (SQLException ex) {
                ex.getMessage();
            }
        }
        else{
            System.out.println("All fields should be filled in correctly");
        }
    }

    @Override
    public ObservableList<User> getUsers() {
        ArrayList<User> arrayList = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(
                "jdbc:derby://localhost:1527/Users", "Users", "Users")){
             try(PreparedStatement prst = conn.prepareStatement("SELECT * FROM USERS\n")){
                ResultSet rs = prst.executeQuery();
                while (rs.next()) {                    
                    arrayList.add(new User(rs.getString(1), rs.getString(2), rs.getInt(3)));
                }
               }
        return FXCollections.observableArrayList(arrayList);
    }   catch (SQLException ex) {
            ex.getMessage();
        }return null;
}

    @Override
    public void close() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}