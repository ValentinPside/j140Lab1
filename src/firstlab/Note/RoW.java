/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package firstlab.Note;

import firstlab.User;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


/**
 *
 * @author user
 */
public class RoW {
    public static void saveFile(User user, String text){
        try {
            File file = new File(user.getId() + ".txt");
                try (FileWriter fileWriter = new FileWriter(file)) {
                    fileWriter.write(text);
                    fileWriter.close();
                }
                
            }catch(IOException e){
            e.getMessage();
        }
        
    }
}
