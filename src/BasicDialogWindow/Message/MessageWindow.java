/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasicDialogWindow.Message;

import javax.swing.JOptionPane;

/**
 *
 * @author Tyler_Atiburcio
 */
public class MessageWindow {
    
    public static void messageWindow(String[] str)
    {
        String display = "";
        for(String s : str) display = display.concat("\n" + s);
        messageWindow(display);
    }
    
    private static void messageWindow(String str)
    {
        JOptionPane.showMessageDialog(null, str);
    }
    
}
