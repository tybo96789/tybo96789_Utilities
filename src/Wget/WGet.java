package Wget;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Not my coding :P just took the base code and make it so i can use it for return the downloaded content or prints out the content 
 */
public class WGet {
        /**
         * Gets the file from the passed URL
         * @param url
         * @throws MalformedURLException 
         */
        public static void wget(String url) throws MalformedURLException
        {
            BufferedReader r = null;
            try {
                String s;
                r = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
                while ((s = r.readLine()) != null) 
                {
                    System.out.println(s);
                }
            } catch (IOException ex) {
                Logger.getLogger(WGet.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    r.close();
                } catch (IOException ex) {
                    Logger.getLogger(WGet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        /**
         * This method prints out the first line that of that file
         * @param url
         * @return data from that first line
         */
        public static String wgetOutPutOneLine(String url)
        {
            String output = "";
             {
            BufferedReader r = null;
            try {
                String s;
                r = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
                while ((s = r.readLine()) != null) 
                {
                    output = output.concat(s);
                }
            } catch (IOException ex) {
                Logger.getLogger(WGet.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    r.close();
                } catch (IOException ex) {
                    Logger.getLogger(WGet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
             return output;
        }
        /**
         * This method reads everything from the file from the url passed and returned
         * @param url
         * @return all data from that file based on URL
         */
        public static String wgetOutPut(String url)
        {
            String output = "";
             {
            BufferedReader r = null;
            try {
                String s;
                r = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
                while ((s = r.readLine()) != null) 
                {
                    output = output.concat(s+"\n");
                }
            } catch (IOException ex) {
                Logger.getLogger(WGet.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    r.close();
                } catch (IOException ex) {
                    Logger.getLogger(WGet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
             return output;
        }
}
