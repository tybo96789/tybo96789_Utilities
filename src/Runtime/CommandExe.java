package Runtime;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tyler Atiburcio
 */
public class CommandExe {
    
    private String cmd;
    protected Runtime rt = Runtime.getRuntime();
    protected Thread th;

    public CommandExe(String cmd) {
        this.cmd = cmd.trim();
    }
    
    public Thread build()
    {
        if(this.cmd.trim().isEmpty()) return null;
        else
        {
            th = new Thread(new Runnable() {

                @Override
                public void run() {
                    try {
                        rt.exec(cmd);
                    } catch (IOException ex) {
                        Logger.getLogger(CommandExe.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            return th;
        }
    }
    
    public boolean run()
    {
        try{
            th.start();
        }catch(NullPointerException ex)
        {
            this.th = this.build();
            return run();
        }
        catch(Exception exc)
        {
            System.exit(0);
        }
        return true;
    }
    
    

}
