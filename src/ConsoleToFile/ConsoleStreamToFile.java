package ConsoleToFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * Pipes console stream to a file
 * @author Tyler Atiburcio
 */
public class ConsoleStreamToFile {
    
    private static final String DEFAULT_NAME = "PipedConsole.txt";
    
    /**
    *Pipes console to the Default name of "PipedConsole.txt"
     * @throws java.io.FileNotFoundException
    */
    public ConsoleStreamToFile() throws FileNotFoundException
    {
        File file = new File(DEFAULT_NAME);
        if(file.exists()) file.delete();
        System.setOut(new PrintStream(new FileOutputStream(DEFAULT_NAME)));
    }
    /**
    *@param fileName
     * @throws java.io.FileNotFoundException
    */
    public ConsoleStreamToFile(String fileName) throws FileNotFoundException
    {
        File file = new File(fileName);
        if(file.exists()) file.delete();
        System.setOut(new PrintStream(new FileOutputStream(fileName)));
    }

}
