/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstlab;


/**
 *
 * @author denis
 */
public class UserController {
    
    public static boolean checkData(String firstName, String lastName, Integer age) throws UserException{
        if (firstName.isEmpty() || lastName.isEmpty()) throw new UserException("FirstName and LastName should not be empty!");
        if(age == 0) throw new UserException("Age field should not be empty!");
        return true;
    }
}
