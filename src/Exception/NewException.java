/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;

/**
 *  Incomplete Exception Class
 * @author Tyler Atiburcio
 * @deprecated Incomplete
 */
public class NewException extends Exception {
    
    private static final String DEFAULT_ERROR_MSG = "Something Broke :l";

    /**
     * Creates a new instance of
     * <code>NewException</code> without detail message.
     */
    public NewException() {
        super(DEFAULT_ERROR_MSG);
    }

    /**
     * Constructs an instance of
     * <code>NewException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public NewException(String msg) {
        super(msg);
    }
    
}
