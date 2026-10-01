package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static boolean isValidInput(String input){
        final String SIMPLE_COUNT = "-?\\d+(\\.\\d+)?([+\\-*/]-?\\d+(\\.\\d+)?)*";
        final Pattern INTERNAL_PARENTHESES = Pattern.compile("\\(([^()]+)\\)");

        if(input == null || input.trim().isEmpty()) return false;

        String exp = input.replaceAll("\\s+", "");
        Matcher matcher =  INTERNAL_PARENTHESES.matcher(exp);
        while(matcher.find()){
            String internalParentheses = matcher.group(1);

            if(!internalParentheses.matches(SIMPLE_COUNT)) return false;

            exp = exp.substring(0,matcher.start()) + 1 + exp.substring(matcher.end());

            matcher = INTERNAL_PARENTHESES.matcher(exp);
        }

        return exp.matches(SIMPLE_COUNT);
    }
}
