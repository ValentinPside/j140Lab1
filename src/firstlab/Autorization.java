/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package firstlab;

import firstlab.Note.Note;
import firstlab.Table.Table;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
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
public class Autorization extends Application {
    
    Scene scene;
    
    @Override
    public void start(Stage primaryStage) {
        
        GridPane root = new GridPane();
        root.setHgap(5);
        root.setVgap(5);
        root.setAlignment(Pos.CENTER);
        
        Label labelTop = new Label("Authorization");
        root.add(labelTop, 0, 0);
        
        Label nameLabel = new Label("Name");
        TextField nameField = new TextField();
        root.add(nameLabel, 0, 1);
        root.add(nameField, 1, 1);
        
        Label lastNameLabel = new Label("Last name");
        TextField lastNameField = new TextField();
        root.add(lastNameLabel, 0, 2);
        root.add(lastNameField, 1, 2);
        
        Label ageLabel = new Label("Age");
        TextField ageField = new TextField();
        root.add(ageLabel, 0, 3);
        root.add(ageField, 1, 3);
        
        
        Label bottom = new Label();
        root.add(bottom, 1, 5);
        
        Button signIn = new Button("Sing in");
        signIn.setOnAction((ActionEvent e) -> {
            String name = nameField.getText();
            String lastName = lastNameField.getText();
            Integer age = Integer.parseInt(ageField.getText().replaceAll("[^\\d]", ""));
            try {
                if(UserController.checkData(name, lastName, age)){
                    User user = new User(name, lastName, age);
                    Note note = new Note(user);
                }
            } catch (UserException ex) {
                bottom.setText(ex.getMessage());
            }
        });
        root.add(signIn, 2, 4);
        
        Button usersList = new Button("Users List");
        usersList.setOnAction((ActionEvent e) -> {
            try {
                new Table();
            } catch (Exception ex) {
                Logger.getLogger(Autorization.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        root.add(usersList, 1, 4);
        
        scene = new Scene(root, 400, 300);
        primaryStage.setTitle("Authorization");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
