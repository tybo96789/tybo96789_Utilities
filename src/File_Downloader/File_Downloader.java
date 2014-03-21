/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package File_Downloader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

/**
 *
 * 
 */
public class File_Downloader {
    /**
     * This methods takes in a String that is a URL, and downloads the file and names the file the name by the passed second string 
     * @param url
     * @param fileName
     * @return If File Exists
     * @throws IOException 
     */
    public static boolean download(String url, String fileName) throws IOException
    {
        URL website = new URL(url);
        ReadableByteChannel rbc = Channels.newChannel(website.openStream());
        FileOutputStream fos = new FileOutputStream(fileName);
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        File file = new File(fileName);
        return file.exists();
    }
}
