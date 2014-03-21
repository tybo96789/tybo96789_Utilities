package Testing;

import Basic_Menu.Menu;
import Basic_log.Log;
import ConsoleToFile.ConsoleStreamToFile;
import Scanner_Log.Logged_Scanner;
import Wget.WGet;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This program is only meant for testing the rest of the programs in this project :P This will be removed later 
 * @author Tyler Atiburcio
 * @deprecated 
 */
public class Menu_Test {
    
    private static final Scanner SCAN = new Scanner(System.in);
    private static Menu menu;
    private static Log log = new Log();
    private static String temp;
    
    private static Logged_Scanner scanlogged = new Logged_Scanner();
    private static final String hello = "Hello World!";
    private int num =1;
    
    public static void notMain(String args[])
    {   
        try {
            new ConsoleStreamToFile();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Menu_Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       // try {
            //testing();
            //homework();
            //testingClass2();
            //wgetTest();
            //testingClass2();
        /*
            try {
                 File_Downloader.download("https://dl.dropboxusercontent.com/s/nk5qmua62s8y5c3/motd.motd?token_hash=AAEENQT05zCnv_XNUL0P5IpfjjHKe5FulBTjeDA6zrFM8w&dl=1","sample.txt");
            } catch (IOException ex) {
                Logger.getLogger(Menu_Test.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            * 
            */ 
            
            //new VersionChk().versionChk();
            //new VersionChk().updateVerFile();
            /*
            if(new VersionChk().quietVersionChk())
            {
                System.out.println("Okay!");
            }
            else
            {
                System.out.println(":l");
            }
            
            //new MOTD().printMOTD();
            Config_File config = new Config_File();
            Config_Loader configLoader = new Config_Loader(config);
            configLoader.callDefaults();
            //new VersionChk(configLoader.getUPDATE_SERVERSetting()).versionChk();
        } catch (Exception ex) {
            System.out.println("Updater Failed!");
            Logger.getLogger(Menu_Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        */ 
        System.out.println(UserName.UserName.getUserName());
        System.out.println(Dec_to_Any_Base.Decimal_to_Any_Base.decToBase(255, 2));
    }
    private static void menu()
    {
        menu.setItem("Hello");
        menu.setItem("Motto");
        menu.setItem();
        menu.setItemQuestion("Pick any random word :P");
        //menu.setItem(10,"YOLO");
        menu.printAllItems();
    }
    
    private static void testing()
    {
        menu =new Menu();
        menu.toggleniceMenu();
        menu();
        log.writeData("Hello world");
        log.writeData("data 2.0");
        scanlogged.writeData("Hello");
        log.writeData(scanlogged.nextLine());
        scanlogged.writeLog();
        log.writeLog();
    }
    private static void testingClass() //Class lecture 9/11/13
    {
        System.out.println("Please Type your name :P");
        System.out.println("Hello, "+  SCAN.nextLine()+ "!");
        System.out.println(getHello());
        
    }
    private static String getHello()
    {
        return hello;
    }
    private static void homework()
    {
      System.out.println(
      "Hello!");
      System.out.println("Hello"/*comment*/);
    }
    private static void testingClass2()
    {
        System.out.println(Math.pow(5,5)) ;
        System.out.println("'");
    }
    private static void wgetTest()
    {
        String url = "https://dl.dropboxusercontent.com/s/xni4itksf3ybncy/TermsAccepted.txt?token_hash=AAG46CEosHymxT1iYJr4VWOK7VF0JtyNm6ftSxAvjgc3Bg&dl=1";
        try {
            WGet.wget(url);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Menu_Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
