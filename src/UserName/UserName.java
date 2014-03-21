/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserName;

/**
 *  This is a helper class that gets the Various system properties
 * @author Tyler Atiburcio
 */
public final class UserName {
    
    public static String getUserName()
    {
        return System.getProperty("user.name");
    }
}
