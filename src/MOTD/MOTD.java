/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MOTD;

import Wget.WGet;

/**
 * This class query a server file that contains one string line that is the MOTD, Where it is then returns the String that contains the MOTD
 * @author Tyler Atiburcio
 */
public class MOTD {
    
    private String serverURL = "https://dl.dropboxusercontent.com/s/nk5qmua62s8y5c3/motd.motd?token_hash=AAEENQT05zCnv_XNUL0P5IpfjjHKe5FulBTjeDA6zrFM8w&dl=1";
    private static final String DEFAULT_MESSAGE_PREFIX = "Message of the Day: ";
    public MOTD()
    {
        
    }
    /**
     * @param overrideURL URL That contains the motd file and data
     * This constructor provided with a override URL with make a motd instance which stores the URL into the serverURL String
     */
    public MOTD(String overrideURL)
    {
        serverURL=overrideURL;
    }
    /*
     * This method querys the server for the motd file and returns the motd as a string
     */
    public String getMOTD()
    {
       return WGet.wgetOutPutOneLine(serverURL);
    }
    /*
     * This method querys the server containg the motd file and println the motd
     */
    public void printMOTD()
    {
        System.out.println(DEFAULT_MESSAGE_PREFIX + "\n"+ WGet.wgetOutPutOneLine(serverURL));
    }
    
    
    
}
