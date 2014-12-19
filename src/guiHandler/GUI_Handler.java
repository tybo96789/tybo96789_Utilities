package guiHandler;


import java.awt.Container;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Tyler_Atiburcio
 */
public abstract class GUI_Handler extends JFrame{
    private final int WIDTH, HEIGHT;
    private final String TITLE;
    protected final GUI_Handler INSTANCE = this;
    protected ArrayList<Container> containers = new ArrayList<Container>();
    
    protected JPanel panel = new JPanel();

    public GUI_Handler(int WIDTH, int HEIGHT, String TITLE) {
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.TITLE = TITLE;
        this.setSize(WIDTH, HEIGHT);
        this.setTitle(TITLE);
    }
    
    public abstract void makeContainers();
  
}
