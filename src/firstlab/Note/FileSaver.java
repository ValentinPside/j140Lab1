/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package firstlab.Note;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Valentin
 */
public class FileSaver {
    public static void saveFile(String id, String text) {
        try {
            File file = new File(id + ".txt");
            if(!file.exists())file.createNewFile();
            try (FileWriter fileWriter = new FileWriter(file)){
                fileWriter.append(text);
            }
        } catch (IOException ex) {
            ex.getMessage();
        }
    }
}
