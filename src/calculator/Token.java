package calculator;

public class Token {
    public static boolean isNumber(String str){
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    public static boolean isOperator(String token){
        if(token == null) return false;
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }
}
