/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package firstlab.Table;

import firstlab.User;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Valentin
 */
public class Table extends Stage{
    public Table() throws Exception {
        init();
    }

    private void init() throws Exception {
        TableView <User> tableView = new TableView<>();
        
        TableColumn<User, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableView.getColumns().add(nameCol);
        
        TableColumn<User, String> lastNameCol = new TableColumn<>("Last name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        tableView.getColumns().add(lastNameCol);
        
        TableColumn<User, Integer> numberCol = new TableColumn<>("Age");
        numberCol.setCellValueFactory(new PropertyValueFactory<>("age"));
        tableView.getColumns().add(numberCol);
        
        tableView.setItems(new DBServer().getUsers());

        StackPane root = new StackPane();
        root.getChildren().add(tableView);
        Scene scene = new Scene(root, 300, 250);
        
        BorderPane brPane = new BorderPane();
        Button button = new Button("Add User");
        brPane.setBottom(button);
        root.getChildren().add(brPane);
        button.setOnAction((e) -> {
            new NewUser();
        });
        
        setTitle("Users List");
        setScene(scene);
        show();
    }
}
