package calculator.parser;

public class Tokenizer {
    private final String str;
    private final String delimiter;
    private int tokenCount = 0;

    //StringTokenizer
    public Tokenizer(String str, String delimiter) {
        this.str = str;
        this.delimiter = delimiter;
    }

    public boolean hasToken() {
        return tokenCount < str.length();
    }

    public String nextToken() {
        if (!hasToken()) return null;

        String token = String.valueOf(this.str.charAt(this.tokenCount++));
        if (token.matches(formatDelimiterToRegex(this.delimiter))) {
            return token;
        } else {
            if(this.str.length() - 1 < tokenCount) return token;
            while(!(String.valueOf(this.str.charAt(this.tokenCount))).matches(formatDelimiterToRegex(this.delimiter))) {
                token += String.valueOf(this.str.charAt(this.tokenCount++));
                if(this.str.length() - 1 < tokenCount) break;
            }
            return token;
        }
    }

    private String formatDelimiterToRegex(String delimiter) {
        String formattedDelimiter = "";
        for(int i = 0; i < delimiter.length(); i++) {
            switch (delimiter.charAt(i)) {
                case '*':
                case '+':
                case '(':
                case ')':
                    formattedDelimiter += String.valueOf(delimiter.charAt(i));
                    break;
                case '/':
                case '-':
                    formattedDelimiter += "\\" + String.valueOf(delimiter.charAt(i));
                    break;
                case ' ':
                    formattedDelimiter += "\\s";
                    break;
                default:
                    break;
            }
        }
        if(!delimiter.isEmpty()) formattedDelimiter = "[" + formattedDelimiter + "]";
        return formattedDelimiter;
    }
}
