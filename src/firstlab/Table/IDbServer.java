/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package firstlab.Table;

import firstlab.User;
import javafx.collections.ObservableList;

/**
 *
 * @author Valentin
 */
public interface IDbServer extends AutoCloseable{
    
    void addNewUser(String name, String lastName, Integer age);
    ObservableList<User> getUsers();
}
