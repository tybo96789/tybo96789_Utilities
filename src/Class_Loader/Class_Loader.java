/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Class_Loader;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *  This is still experimental, Not Done
 * @author Tyler Atiburcio
 * @deprecated Experimental
 */
public class Class_Loader {
    /**
     * Makes a new instance of the Class Loader
     */
    public Class_Loader()
    {
        
    }
    /**
     * This method loads a jar file
     * @param filePath
     * @param packageName
     * @throws SecurityException
     * @throws InstantiationException
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     * @throws MalformedURLException 
     */
    public void loadJar(String filePath, String packageName) throws SecurityException, InstantiationException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, MalformedURLException
    {
        try {
            File file = new File(filePath);
            ClassLoader loader = URLClassLoader.newInstance(
            new URL[] { file.toURL() },
            getClass().getClassLoader());
            Class<?> clazz = Class.forName(packageName, true, loader);
            Class<? extends Runnable> runClass = clazz.asSubclass(Runnable.class);
            // Avoid Class.newInstance, for it is evil.
            Constructor<? extends Runnable> ctor = runClass.getConstructor();
            Runnable doRun = ctor.newInstance();
            doRun.run();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Class_Loader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
