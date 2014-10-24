/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Basic_Menu;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *  This is mostly a Tool to use in the background to make menu entires without a lot of system.out.println statements
 * @author Tyler Atiburcio
 */
public class Menu {

    private ArrayList<String> menu; //;mem space for a ArrayList called menu created but not int.
    private final Scanner scan = new Scanner(System.in); //A Class wide scanner 
    private String title = "Menu"; //Default menu title
    private boolean niceMenu = false;
    private int size;
    
    /**
     * This constructor makes a new instance of menu with the default menu name
     */
    public Menu()
    {
        menu = new ArrayList<String>();
    }
/**
 * This constructor, passed a string will set the menu to the given string
 * @param newTitle 
 */
    public Menu(String newTitle){
        menu = new ArrayList<String>();
        this.setTitle(newTitle);
    }
    /**
     * This method adds a new menu entry
     * @param item 
     */
    public void setItem(String item)
    {
        menu.add(item);
    }
    /**
     * This method sets a menu entry with a given menu point
     * @param point
     * @param item 
     */
    private void setItem(int a, String item)
    {
        menu.add(a, item); //broken :l
    }
    /**
     * This method is meant for a end-user made menu with scanners and nextlines
     */
    public void setItem()
    {
        System.out.println("Program is asking for user input of String type");
        menu.add(scan.nextLine());
    }
    /**
     * This method passed a string will print the string to user asking for menu entry input
     * @param Prompt 
     */
    public void setItemQuestion(String Prompt)
    {
        System.out.println(Prompt);
        menu.add(scan.nextLine());
    }
    /**
     * This method calls the menu entry place and returns the data
     * @param place
     * @return menu entry
     */
    public String getItem(int place)
    {
        return menu.get(place);
    }
    /**
     * This method prints all menu entries
     */
    public void printAllItems() 
    {
        size = getSize();
        System.out.println(getTitle());
        if (niceMenu == true) {
            niceMenuMode();
        } else {
            for (int x = 0; x < size; x++) {
                System.out.println(x + ": " + menu.get(x).toString());
            }

        }

    }
    /**
     *
     * @return Size of Menu array
     */
    public int getSize() 
    {
        return menu.size();
    }
    /**
     * This method renames the menu instance with the given passed name
     * @param newTitle 
     */
    public void setTitle(String newTitle) 
    {
        title = newTitle;
    }
    /**
     * 
     * @return Menu Title
     */
    private String getTitle() 
    {
        return title;
    }
    /**
     * This method is a toggle menu that adds some fancy things to it to make it look nice during the print
     */
    public void toggleniceMenu() 
    {
        if (niceMenuStatus() == false) {
            setniceMenu(true);
        } else {
            setniceMenu(false);
        }
    }
    /**
     * This method takes in a boolean for direct change of what the nice menu status is
     * @param boolean 
     */
    private void setniceMenu(Boolean a) 
    {
        niceMenu = a;
    }
    /**
     * This method returns the status of the nice menu
     * @return Nice menu status
     */
    public boolean niceMenuStatus() 
    {
        return niceMenu;
    }
    /**
     * This menu is the framework that prints an opening line before printing all menu entries then a closing line
     */
    private void niceMenuMode()
    {
        System.out.println("------------------------------------");
        for (int x = 0; x < size; x++) {
            System.out.println(x + ": " + menu.get(x).toString());
        }
        System.out.println("------------------------------------");
    }
}