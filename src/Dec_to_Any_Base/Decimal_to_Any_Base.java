package Dec_to_Any_Base;

/**
 *
 * @author Tyler Atiburcio
 */
public class Decimal_to_Any_Base {
    
    private static final int ZERO_MARK = 48, ALPHA_MARK = 65;
    
    public static String decToBase(int num, int base)
    {
        String answer = "";
        String validBounds = getValidBaseRange(base);
        if(num<0 || base<=0)
        {
            answer = null;
        }else if(num==0)
        {
            answer = "0";
        }
        else
        {
            int requiredPlaces;
            int temp =0;
            for(requiredPlaces = 0;temp != num;requiredPlaces++)
            {
                temp = (int) (num%(Math.pow(base, requiredPlaces)));
            }
            requiredPlaces--;
            int remainder = num;
            for(int i =requiredPlaces-1;remainder!=0;i--)
            {
                int temp1 = (int) (remainder/(Math.pow(base, i)));
                remainder = (int) (remainder%(Math.pow(base, i)));
                answer = answer + validBounds.charAt(temp1);
            }
        }
        return answer;
    }
    
    private static String getValidBaseRange(int base)
    {
        String bounds = "";
        for(int x = 0;x<=base;x++)
        {
            if(base>=10 && x>=10)
            {
                bounds = bounds + (char) ((x+ALPHA_MARK)-10);
            }
            else
            {
                bounds = bounds +(char)(x+ZERO_MARK);             
            }
        }
        return bounds;
    }

}
