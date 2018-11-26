
package flexbox;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Order {
    
    public static void addToOrder(String lengthS, String widthS, String heightS, int grade, int colour, String quantityS, boolean btmRein, boolean crnrRein, boolean seal){
        double length = 0, width = 0, height = 0;
        int quantity = 0;
        
        try {
            length = Double.valueOf(lengthS);
            width = Double.valueOf(widthS);
            height = Double.valueOf(heightS);
            quantity = Integer.valueOf(quantityS);
        }
        
        catch(Exception IllegalArgumentException ) {
            //Add error to GUI
            
        }
        int type = getBoxType(grade, colour, btmRein, crnrRein);
        switch (type){
            case 1: {
                Box1 box = new Box1(5, length, width, height, grade, colour, btmRein, crnrRein, seal, quantity);
            }
            
        }
    }
    
    public static int noColours(boolean botReinf, boolean cornReinf){
        boolean bot = botReinf;
        boolean corn = cornReinf;
         if (!bot)
         {
            if(!corn)
            {
                return 1;
            }
            else
            {
                return 6;
            }
         }
         else
        {
            return 6;
        }
    }
    public static int oneColours(boolean botReinf, boolean cornReinf){
        boolean bot = botReinf;
        boolean corn = cornReinf;
        if (!bot)
        {
            return 6;
        }
        else
        {
            if(!corn)
            {
                return 2;
            }
            else
            {
                return 6;
            }
        }
    }
    public static int multiColors(boolean botReinf, boolean cornReinf){
        boolean bot = botReinf;
        boolean corn = cornReinf;
        if(!bot)
        {
            if(!corn)
            {
                return 3;
            }
            else
            {                            
                return 6;
            }
        }
        else
        {
            if(!corn)
            {
                return 4;
            }
            else
            {
                return 5;
            }
        }        
    }
    public static int getBoxType(int grade, int colour, boolean bottomReinforcement, boolean cornerReinforcement){
        int type;        
        switch(grade){
            case 1:{
                if (colour == 0)
                {
                    type = noColours(bottomReinforcement, cornerReinforcement);
                    return type;
                }
                else{
                    type = 6;
                    return type;
                }
            }
            case 2:
            {
                switch (colour)
                {
                    case 0:
                        type = noColours(bottomReinforcement, cornerReinforcement);
                        return type;
                    case 1:
                        type = oneColours(bottomReinforcement, cornerReinforcement);
                        return type;
                    default:
                        if(!bottomReinforcement)
                        {
                            if(!cornerReinforcement)
                            {
                                type = 3;
                                return type;
                            }
                            else
                            {
                                type = 6;
                                return type;
                            }
                        }
                        else
                        {
                            if(!cornerReinforcement)
                        {
                            type = 4;
                            return type;
                        }
                        else
                        {
                            type = 6;
                            return type;
                        }
                    }
                }
            }
            case 3:
            {
                switch (colour)
                 {
                        case 0:
                        {
                            type = noColours(bottomReinforcement, cornerReinforcement);
                            return type;
                        }
                        case 1:
                        {
                            type = oneColours(bottomReinforcement, cornerReinforcement);
                            return type;
                        }
                        default:
                        {
                            type = multiColors(bottomReinforcement, cornerReinforcement);
                            return type;
                        }
                 }
            }
            case 4:
            {
                switch (colour)
                {
                    case 0:
                    {
                        type = 6;
                        return type;
                    }
                    case 1:
                    {
                        type = oneColours(bottomReinforcement, cornerReinforcement);
                        return type;
                    }
                    default:
                    {
                        type = multiColors(bottomReinforcement, cornerReinforcement);
                        return type;
                    }
                }
            }
            default:
            {
                switch (colour)
                {
                    case 0:
                    {
                        type = 6;
                        return type;
                    }
                    case 1:
                    {
                        type = 6;
                        return type;
                    }
                    default:
                    {
                        type = multiColors(bottomReinforcement, cornerReinforcement);
                        return type;
                    }
                }
            }
        }
    }
}
