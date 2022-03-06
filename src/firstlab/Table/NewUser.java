/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package firstlab.Table;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Valentin
 */
public class NewUser extends Stage{
    public NewUser (){
        init();
    }
    
    private void init(){
        GridPane root = new GridPane();
        root.setHgap(5);
        root.setVgap(5);
        root.setAlignment(Pos.CENTER);
        
        Label labelTop = new Label("Write information");
        root.add(labelTop, 1, 0);
        
        Label nameLabel = new Label("Name");
        TextField nameField = new TextField();
        root.add(nameLabel, 0, 1);
        root.add(nameField, 1, 1);
        GridPane.setColumnSpan(nameField, 2);
        
        Label lastNameLabel = new Label("Last Name");
        TextField lastNameField = new TextField();
        root.add(lastNameLabel, 0, 2);
        root.add(lastNameField, 1, 2);
        GridPane.setColumnSpan(lastNameField, 2);
        
        Label ageLable = new Label("Age");
        TextField ageField = new TextField();
        root.add(ageLable, 0, 3);
        root.add(ageField, 1, 3);
        GridPane.setColumnSpan(ageField, 2);
        
        Button button = new Button("Add User");
        root.add(button, 1, 4);
        button.setOnAction((ActionEvent e) -> {
           String name = nameField.getText();
           String lastName = nameField.getText();
           Integer age = Integer.parseInt(ageField.getText().replaceAll("[^\\d]", ""));
            try {
                DBServer db = new DBServer();
                db.addNewUser(name, lastName, age);
            } catch (Exception ex) {
                ex.getMessage();
            }
           
        });
        
        Scene scene = new Scene(root, 400, 250);
        setTitle("Add User");
        setScene(scene);
        show();
    }
}
