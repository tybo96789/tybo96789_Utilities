/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StringTokenizerExtended;

import java.util.StringTokenizer;

/**
 *
 * @author Tyler_Atiburcio
 */
public class StringTokenizerExtender extends StringTokenizer {
    
    private StringTokenizerExtender intance = this;

    public StringTokenizerExtender(String str, String delim, boolean returnDelims) {
        super(str, delim, returnDelims);
    }
    
    public StringTokenizerExtender(String str, String delim)
    {
        super(str,delim);
    }
    
    public StringTokenizerExtender(String str)
    {
        super(str);
    }
    
    public boolean equals(StringTokenizer str)
    {
        return this.toString().equals(str.toString());
    }
    
    public boolean equals(String str)
    {
        return this.toString().equals(str);
    }
    
    public boolean equalsIgnoreCase(StringTokenizer str)
    {
        return this.toString().equalsIgnoreCase(str.toString());
    }
    
    public boolean equalsIgnoreCase(String str)
    {
        return this.toString().equalsIgnoreCase(str);
    }
    
    public char[] getCharArray()
    {
        return this.toString().toCharArray();
    }
    
    public String toUpperCase()
    {
        return this.toString().toUpperCase();
    }
    
    public String toLowerCase()
    {
        return this.toString().toLowerCase();
    }

    @Override
    public String toString() {
        String s  = "";
        for (int i = 0; i <super.countTokens(); i++) {
            s = s.concat(super.nextToken());
        }
        return s;
    }
    
    
}
