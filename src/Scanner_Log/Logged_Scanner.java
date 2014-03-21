package Scanner_Log;

import Basic_log.Log;
import java.util.Scanner;


public class Logged_Scanner extends Log {
    
    private static String logName = "ScannerLog";
    private String data;
    private Scanner scan;
    /**
     * Makes a basic logged scanner with the default log name
     */
    public Logged_Scanner()
    {
        super(getlogName());
        scan = new Scanner(System.in);
    }
    /**
     * Log name override
     * @param name 
     */
    public Logged_Scanner(String name) {
        super(name);
        scan = new Scanner(System.in);
    }
    /**
     * Uses default log name, but the scanner is passed 
     * @param passedScanner 
     */
    public Logged_Scanner(Scanner passedScanner)
    {
        super(getlogName());
        scan = passedScanner;
    }
    /**
     * Makes a Logged Scanner object with the passed name and passed scanner
     * @param passedScanner
     * @param name 
     */
    public Logged_Scanner(Scanner passedScanner, String name)
    {
        super(name);
        scan = passedScanner;
    }
    /**
     * This is almost the same method just like scanner.nextline() but the input is logged, then returned
     * @return Data Entered
     */
    public String nextLine()
    {
        setData(scan.nextLine());
        super.writeData(getData());
        return getData();
    }
    /**
     * 
     * @param prompt
     * @return Calls nextLine Method
     */
    public String nextLinePrompt(String prompt)
    {
        System.out.println(prompt);
        return nextLine();
    }
    /**
     * This method returns the Data that was inputed
     * @return data
     */
    private String getData() {
        return data;
    }
    /**
     * This method sets data to the new data that is passed to it
     * @param newData 
     */
    private void setData(String newData) {
        data = newData;
    }
    @Override
    /**
     * This Method is basiclly just calls the ending method to finally write the log to file
     */
    public void writeLog()
    {
        super.writeLog();
    }
    /**
     * THis method returns the current log name for the Logged Scanner
     * @return logName
     */
    private static String getlogName()
    {
        return logName;
    }
}