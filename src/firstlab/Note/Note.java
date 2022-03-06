/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package firstlab.Note;

import firstlab.User;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class Note extends Stage{
    public Note(User user) {
        init(user);
    }

    private void init(User user) {
        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(10);
        root.setAlignment(Pos.CENTER);
        
        Label labelTop = new Label("Новая запись");
        root.add(labelTop, 0, 1);
        GridPane.setColumnSpan(labelTop, 3);
        GridPane.setHalignment(labelTop, HPos.CENTER);
        
        TextArea text = new TextArea();
        text.setPrefSize(450, 100);
        root.add(text, 0, 2);
        GridPane.setColumnSpan(text, 3);
        
        Button saveButton = new Button("Сохранить");
        root.add(saveButton, 0, 3);
        GridPane.setHalignment(saveButton, HPos.LEFT);
        Button clearButton = new Button("Очистить");
        root.add(clearButton, 1, 3);
        GridPane.setHalignment(clearButton, HPos.RIGHT);
        Button showButton = new Button("Открыть файл");
        root.add(showButton, 2, 3);
        GridPane.setHalignment(showButton, HPos.RIGHT);
        
        saveButton.setOnAction((e) -> {
            RoW.saveFile(user, text.getText());
        });
        
        clearButton.setOnAction((e) -> {
            text.clear();
        });
        
        showButton.setOnAction((e) -> {
            FileChooser fileChooser = new FileChooser();
            Stage stage = new Stage();
            File file = fileChooser.showOpenDialog(stage);
            try (FileReader fileReader = new FileReader(file)){
                text.clear();
                char[] temp = new char[1024];
                int i;
                while ((i = fileReader.read(temp)) > 0){
                    String line = new String(temp, 0, i);
                    text.appendText(line);
                }
            } catch (FileNotFoundException ex) {
                ex.getMessage();
            } catch (IOException ex) {
                ex.getMessage();
            }
        });
        
        Scene scene = new Scene(root, 500, 250);
        setTitle("Note");
        setScene(scene);
        show();
    }
}
