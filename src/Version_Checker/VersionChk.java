package Version_Checker;

import File_Downloader.File_Downloader;
import File_Reader.File_Reader;
import Wget.WGet;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This Program Checks a local version hashcheck and compares it to the server version, and returns either a true or false respectively
 * @author Tyler Atiburcio
 */
public class VersionChk {
    
    private static String serverURL = "https://dl.dropboxusercontent.com/s/va5jn3bvqflhyt4/version.ver?token_hash=AAEy_iJoRHNAQX1FDNA4GkfYyaTyfKK2nks5Ijn7N5DpjQ&dl=1";
    private static final String fileName = "version.ver";
    private static String localHash, serverHash;
    /**
     * Makes a basic Version check check object
     */
    public VersionChk()
    {
        
    }
    /**
     * 
     * @param overrideURL 
     */
    public VersionChk(String overrideURL)
    {
        serverURL= overrideURL;
    }
    /**
     * This Method is one version of the checking, but this method has println statements during the checking and returns a boolean if version is the same or different from the server
     * @return boolean
     * @throws java.lang.Exception
     */
    public boolean versionChk() throws Exception
    {
        boolean isNew =false;
        System.out.println("Program is checking for an update!");
        File f = new File(fileName);
        if(f.exists())
        { 
            localHash = fileRead("version.ver").get(0);
            serverHash = WGet.wgetOutPutOneLine(serverURL);
        }
        else
        {
            boolean status = false;
            System.out.println("version.ver File Not Found....Downloading From Server");
            status = updateVerFile();
            isNew = true;
            localHash = fileRead("version.ver").get(0);
            serverHash = WGet.wgetOutPutOneLine(serverURL);
            if(status)
            {
                System.out.println("Download Done!");
            }
            else 
            {
                throw new Exception("Download Failed!");
            }
            
            
        }
        boolean status = compareVer(localHash,serverHash);
        //System.out.println(localHash);
        //System.out.println(serverHash);
        if(status == true && isNew ==false)
            {
                System.out.println("Program is at the most current version!");
            }
            else
            {
                System.out.println("There is an update!");
            }
        return status;

    }
     /**
     * This Method is a quiet version of the checking compared to the other versionChk Method, but this method has no println statements during the checking and returns a boolean to show if the versions are different or the same as the server
     * @return 
     * @throws java.lang.Exception
     */
    public boolean quietVersionChk() throws Exception
    {
        boolean isNew = false;
        boolean verdict;
        File f = new File(fileName);
        if(f.exists()) 
        { 
            localHash = fileRead("version.ver").get(0);
            serverHash = WGet.wgetOutPutOneLine(serverURL);
        }
        else
        {
            boolean status = false;
            status = updateVerFile();
            isNew = true;
            localHash = fileRead("version.ver").get(0);
            serverHash = WGet.wgetOutPutOneLine(serverURL);
            if(status == false)
            {
                throw new Exception("Download Failed!");
            }
        }
        if(isNew){
            verdict = false;
        }
        else
        {
           verdict = compareVer(localHash,serverHash);
        }
        return verdict;

    }
    /**
     * 
     * @param fileName
     * @return A File reader with the file that was specified, in a ArrayList form
     */
    private ArrayList<String> fileRead(String fileName)
    {
        return File_Reader.readFileReturnArrayList(fileName);
    }
    
    /**
     * 
     * @param localHash
     * @param serverHash
     * @return true if they are the same, else false
     */
    private boolean compareVer(String a,String b)
    {
        int compare = b.compareToIgnoreCase(a);
        //System.out.println(compare);
        if(compare == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }
/**
 * 
 * @return status of operation
 */
    public boolean updateVerFile()
    {
        boolean status = false;
        try {
            File_Downloader.download(serverURL,fileName);
            status = true;
        } catch (IOException ex) {
            Logger.getLogger(VersionChk.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }
}
