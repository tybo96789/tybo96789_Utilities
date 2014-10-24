/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasicDialogWindow;

import javax.swing.JOptionPane;

/**
 *
 * @author Tyler_Atiburcio
 */
public class BasicDialogWindow {
    
    /**
     * inputWindow method makes a Input dialog window given the messages and returns what the user typed in as a String.
     * @param message Message to be displayed to the user
     * @return The input from the user
     */
    public static String inputWindow(String message)
    {
        return JOptionPane.showInputDialog(null, message);
    }
    
}
