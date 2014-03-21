/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Core_Config;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Tyler Atiburcio
 */
public class Config_Loader {
    
    private Config_File config;
    
    protected final String UPDATE_SETTING = "update-setting";
    protected final String UPDATE_SERVER = "update-server";
    protected final String MOTD_SERVER = "motd-server";
    
    protected final String TRUE = "true", FALSE = "false";
    protected final String UPDATE_SERVER_URL = "https://dl.dropboxusercontent.com/s/va5jn3bvqflhyt4/version.ver?token_hash=AAEy_iJoRHNAQX1FDNA4GkfYyaTyfKK2nks5Ijn7N5DpjQ&dl=1";
    protected final String MOTD_SERVER_URL = "https://dl.dropboxusercontent.com/s/nk5qmua62s8y5c3/motd.motd?token_hash=AAEENQT05zCnv_XNUL0P5IpfjjHKe5FulBTjeDA6zrFM8w&dl=1";
    
    /**
     * This method is passed a config_file type and is referenced to variable config
     * @param file 
     */
    public Config_Loader(Config_File file)
    {
        config=file;
    }
    /**
     * This makes a new instance of a Config_File if no config file is referenced 
     * @throws IOException 
     */
    public Config_Loader() throws IOException
    {
        config = new Config_File();
    }
    /**
     * This method returns the updating setting for the program
     * @return update Setting
     */
    public String getUpdateSetting()
    {
        return config.getConfigField(UPDATE_SETTING);
    }
    /**
     * This method returns the data that is reported from the config file of the update server to locate and determine if there is an update
     * @return update server URL
     */
    public String getUPDATE_SERVERSetting() {
        return config.getConfigField(UPDATE_SERVER);
    }
    
    /**
     * When this method is called it rewirtes the config files to the programs set defaults
     * @return if operation is complete
     */
    public boolean callDefaults()
    {
        
        ArrayList<Config_object> data = getArray();
        for(int x = 0;x<data.size();x++)
        {
            config.mkConfigField(data.get(x).getField(), data.get(x).getData());
        }
        return true;
    }
    /**
     * This method makes a new instance of the config defaults arraylist
     * @return the arraylist that contatins the defaults
     */
    private ArrayList<Config_object> getArray()
    {
        Config_Defaults defaults = new Config_Defaults();
        return defaults.getArray();
    }

    private class Config_object
    {
        private String field, data;
        public Config_object(String name, String value)
        {
            field = name;
            data = value;
        }

        public String getField() {
            return field;
        }

        public String getData() {
            return data;
        }
        
    }
    private class Config_Defaults
    {
        private ArrayList<Config_object> configOB = new ArrayList<Config_object>();
        
        public Config_Defaults()
        {
            addAllDefaults();
        }
        
        private boolean addAllDefaults()
        {
            configOB.add(new Config_object(UPDATE_SETTING,TRUE));
            configOB.add(new Config_object(UPDATE_SERVER,UPDATE_SERVER_URL));
            configOB.add(new Config_object(MOTD_SERVER,MOTD_SERVER_URL));
            
            return true;
        }
        
        public ArrayList<Config_object> getArray()
        {
            return configOB;
        }
        
    }
    
    
}
