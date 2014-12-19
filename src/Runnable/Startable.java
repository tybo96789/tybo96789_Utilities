package Runnable;

import File_Downloader.File_Downloader;
import Version_Checker.VersionChk;
import guiHandler.GUI_Handler;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *Running the jar will cause it to update Only given -update param in args
 * @author Tyler Atiburcio
 */
public class Startable {
    private static VersionChk VERCHK;
    private static final String DOWNLOAD_URL = "https://dl.dropboxusercontent.com/s/ej4cgt9oidqb7o5/tybo96789_Utilities.jar?dl=1&token_hash=AAGNco-ihUTcOI-dsdRzDvzbdEBjxsOfvEJ5yJvtXcWwiA";
    private static final String JAR_NAME = "tybo96789_Utilities.jar";

    
    public static void main(String args[])
    {
        try
        {
            /*
            if(args[0] != null){
                if(args[0].equalsIgnoreCase("-update")) update();
                else System.out.println("Argument Unknown");
            }
                    */
            
            new updaterGUI();
        }catch(Exception e)
        {
           System.out.println(e.getMessage());
           System.exit(0);
        }
    }
    private static void update()
    {
        try{
            VERCHK = new VersionChk();
            if(!VERCHK.versionChk())
            {
                System.out.println("Downloading the new version!");
                File_Downloader.download(DOWNLOAD_URL, JAR_NAME);
                VERCHK.updateVerFile();
            }
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("UPDATING FAILED!");
        }
    }
    
    static class updaterGUI extends GUI_Handler{
        
        private JTextArea text;
        private JScrollPane pane;
        private JLabel label;
        private JButton update;
        private JButton close;
        
        
        public updaterGUI()
        {
             super(500,500,"Utility Updater");
             this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             this.makeContainers();
             for(Container c : this.containers) this.panel.add(c);
             this.add(this.panel);
             this.setVisible(true);
        }

        @Override
        public void makeContainers() {
            String area = "Hit Update to check for updates!";
            
            this.text = new JTextArea(area);
            this.text.setEditable(false);
            this.text.setText(area);
            
            this.pane = new JScrollPane(this.text);
            this.pane.setBounds(0, 0, this.getWidth(), this.getHeight()-100);
            this.pane.setPreferredSize(new Dimension(this.getWidth(), this.getHeight()-100));
            this.pane.setAutoscrolls(true);
            this.pane.setViewportView(this.text);
            this.containers.add(this.pane);
            
            this.update = new JButton("Update");
            this.update.addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent e) {
                    VERCHK = new VersionChk();
                    try{
                        if(!VERCHK.versionChk())
                        {
                            text.setText("\nThere is an update\nDownloading new version");
                            File_Downloader.download(DOWNLOAD_URL, JAR_NAME);
                            text.setText("\nDownload Complete");
                            if(VERCHK.updateVerFile()) text.setText("\nUpdate Successful");
                            else throw new Exception("Could not update!");

                        }
                        else text.setText("There is no update\nHit 'close' to close");
                    }catch(Exception ex)
                    {
                        JOptionPane.showMessageDialog(panel, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                        INSTANCE.dispose();
                    }
                }
                
            });
            this.containers.add(this.update);
            
            this.close = new JButton("Close");
            this.close.addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent e) {
                    INSTANCE.dispose();
                }
            
            });
            this.containers.add(this.close);
           
        }
    }
}
