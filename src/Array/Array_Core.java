/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Array;

/**
 * This is hand-build array...Not Finished DO NOT USE
 * @author Tyler Atiburcio
 * @deprecated 
 */
public class Array_Core {
    private int arrayCount;
    private Data_Node node;
    
    public Array_Core()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public void newNode()
    {
        
    }

    
    

private class Data_Node{
    private Data_Node front, back;
    private int loc;
    public Data_Node()
    {
        
    }

        public Data_Node getFront() {
            return front;
        }

        public void setFront(Data_Node front) {
            this.front = front;
        }

        public Data_Node getBack() {
            return back;
        }

        public void setBack(Data_Node back) {
            this.back = back;
        }

        public int getLoc() {
            return loc;
        }

        public void setLoc(int loc) {
            this.loc = loc;
        }
    
}    
}

