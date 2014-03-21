package Runnable;

import File_Downloader.File_Downloader;
import Version_Checker.VersionChk;

/**
 *Running the jar will cause it to update Only given -update param in args
 * @author Tyler Atiburcio
 */
public class Startable {
    private static VersionChk VERCHK;
    private static final String DOWNLOAD_URL = "https://dl.dropboxusercontent.com/s/ej4cgt9oidqb7o5/tybo96789_Utilities.jar?dl=1&token_hash=AAGNco-ihUTcOI-dsdRzDvzbdEBjxsOfvEJ5yJvtXcWwiA";
    private static final String JAR_NAME = "tybo96789_Utilities.jar";

    
    public static void main(String args[])
    {
        try
        {
            if(args[0].equalsIgnoreCase("-update")) update();
            else System.out.println("Argument Unknown");
        }catch(Exception e)
        {
           System.exit(0);
        }
    }
    private static void update()
    {
        try{
            VERCHK = new VersionChk();
            if(!VERCHK.versionChk())
            {
                System.out.println("Downloading the new version!");
                File_Downloader.download(DOWNLOAD_URL, JAR_NAME);
                VERCHK.updateVerFile();
            }
        }catch(Exception e)
        {
            System.out.println("UPDATING FAILED!");
        }
    }
}
