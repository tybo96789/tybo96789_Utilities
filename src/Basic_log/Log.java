package Basic_log;

import Timestamp.Timestamp;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *  This Records everything that goes on console to a file
 * @author Tyler Atiburcio
 */

public class Log {
    
    private FileWriter file;
    private BufferedWriter writer;
    private static String logName = "Log.log";
    
    /**
     * This makes a new instance of log with the default name and opens the log in the program to use
     */
    public Log() 
    {
        try {
            this.file = new FileWriter(getLogName());
        } catch (IOException ex) {
            System.out.println("Error Creating Log file");
            Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.writer = new BufferedWriter(file);
        try {
            this.writer.write(Timestamp.gettimestamp()+": "+"------LOG OPENED------");
            this.writer.newLine();
        } catch (IOException ex) {
            System.out.println("Error Writing");
            Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * This constructor passed a string names the log file to that name ending with the ".log"
     * @param name 
     */
    public Log(String name) 
    {
        this.setLogName(name);
        try {
            this.file = new FileWriter(getLogName());
        } catch (IOException ex) {
            System.out.println("Error Creating Log File");
            Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.writer = new BufferedWriter(file);
        try {
            this.writer.write(Timestamp.gettimestamp()+": "+"------LOG OPENED------");
            this.writer.newLine();
        } catch (IOException ex) {
            System.out.println("Error Writing");
            Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    /**
     * This method returns the log name
     * @return logname
     */
    private String getLogName() {
        return logName;
    }
    /**
     * This method renames the logname
     * @param newName 
     */
    private void setLogName(String newName) {
        logName = newName +".log";
    }
    /**
     * This method writes new data to the buffered writer
     * @param log 
     */
    public void writeData(String log)
    {
        try {
            this.writer.write(Timestamp.gettimestamp()+": "+log);
            this.writer.newLine();
        } catch (IOException ex) {
            System.out.println("Error writing to log");
            Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * This method is called just before the program is about the close to finally write the log to file
     */
    public void writeLog()
    {
        try {
            this.writer.write(Timestamp.gettimestamp()+": "+"-----LOG CLOSED------");
            this.writer.close();
        } catch (IOException ex) {
            System.out.println("Error Writing Log");
            Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}