/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Core_Config;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**A config file system thats is designed for this utilies core 
 * 
 * @author Tyler Atiburcio
 */
public class Config_File {
    private Properties configFile;
    private File file;
    private FileWriter fileWrite;
    private String configDesc = "This is a config file for the program";
    private String fileName;
    private final String NAME = "utilities_core.properties";
    
    /**
     * This contructor is passed an override name to store the config information into
     * @param overrideName
     * @throws IOException 
     */
    public Config_File(String overrideName) throws IOException
    {
        fileName = overrideName;
        configFile = new Properties();
        file = new File(fileName);
        if(file.exists())
        {
        configFile.load(new FileInputStream(fileName));
        }
        else
        {
            mkFile(fileName);
        }
    }
    /**
     * This contructor makes a config file using the default name
     * @throws IOException 
     */
    public Config_File() throws IOException
    {
        fileName = NAME;
        configFile = new Properties();
        file = new File(fileName);
        if(file.exists())
        {
        configFile.load(new FileInputStream(fileName));
        }
        else
        {
            mkFile(fileName);
        }
    }
    /**
     * This method makes a config field, being passed the key and the data, then saves the config to file
     * @param key
     * @param data 
     */
    public void mkConfigField(String key, String data)
    {
        configFile.setProperty(key, data);
        saveFile();
    }
    /**
     * This method returns the property of the given key
     * @param key
     * @return property field
     */
    public String getConfigField(String key)
    {
        return configFile.getProperty(key);
    }
    /**
     * This method makes the config file
     * @param name
     * @return if operation is complete
     */
    private boolean mkFile(String name)
    {
        try {
            fileWrite = new FileWriter(name);
        } catch (IOException ex) {
            Logger.getLogger(Config_File.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    /**
     * This method returns the method delete 
     * @return if operation is complete
     */
    private boolean delFile()
    {
        return file.delete();
    }
    /**
     * This method saves the config file that is currently loaded in the program to file
     * @return if opration is true
     */
    private boolean saveFile()
    {
        try {
            fileRecreate();
            BufferedWriter writer = new BufferedWriter(fileWrite);
            configFile.store(writer, getConfigDesc());
        } catch (IOException ex) {
            Logger.getLogger(Config_File.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    /**
     * This method deletes the config file and then remakes it 
     * @return if operation is true
     */
    private boolean fileRecreate()
    {
        delFile();
        mkFile(getFileName());
        return true;
    }
/**
 * This method returns the config desciption
 * @return config Desc
 */
    private String getConfigDesc() {
        return configDesc;
    }
/**
 * This method sets the config desc
 * @param configDesc 
 */
    public void setConfigDesc(String configDesc) {
        this.configDesc = configDesc;
    }
    /**
     * This method returns the file name of the config file
     * @return fileName
     */
    private String getFileName()
    {
        return fileName;
    }
}
