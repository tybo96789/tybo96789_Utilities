/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EnhancedScanner;

import java.io.InputStream;
import java.util.Scanner;

/**
 *@deprecated Not finished
 * @author Tyler_Atiburcio
 */
public class EnhancedScanner{
    
    private Scanner scan;

    public EnhancedScanner(InputStream source) {
        this.scan = new Scanner(source);
    }
    
    public EnhancedScanner()
    {
        this.scan = new Scanner(System.in);
    }
    
    public String next()
    {
        String input = this.scan.next();
        this.scan.remove();
        return input;
    }
    
}
