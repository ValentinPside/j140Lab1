/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstlab;

import java.io.File;

/**
 *
 * @author Valentin
 */
public class User {
    
    private String firstName;
    private String lastName;
    private Integer age;
    private String id;
    private File note;


    public User(String firstName, String lastName, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        id = firstName + lastName + String.valueOf(age);
        note = new File(id + ".txt");
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    
    public File getNote() {
        return note;
    }

    public void setNote(File note) {
        this.note = note;
    }
    
    public String getId() {
        return id;
    }
    
}
