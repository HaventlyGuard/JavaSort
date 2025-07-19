package filterapp.cli;

import java.util.List;

public class DataValidator {
    public  static boolean isInteger(String str){
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public static boolean isFloat(String str){
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public  static boolean isString(String str){
        return !str.matches("/d+");
    }
}
