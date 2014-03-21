package Timestamp;

/**
 *
 * @author Tyler Atiburcio
 */
public final class Timestamp {
    /**
     * 
     * @return Timestamp MM/DD/YYYY HH:MM:SS
     */
    public static java.sql.Timestamp gettimestamp()
    {
        return new java.sql.Timestamp(new java.util.Date().getTime());
    }
}