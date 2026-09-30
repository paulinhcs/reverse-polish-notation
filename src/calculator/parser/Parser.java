package calculator.parser;

import calculator.Token;
import calculator.stack.Stack;

public class Parser {

    public static Stack<String> toRPNStack(String expression) {
        Tokenizer tokenizer = new Tokenizer(expression, "+-*/() ");
        Stack<String> output = new Stack<>();
        Stack<String> operator = new Stack<>();

        while(tokenizer.hasToken()){
            String token = tokenizer.nextToken();
            if(token.equals(" ")) continue;

            if(Token.isNumber(token)){
                output.push(token);
            } else {
                if(
                        !operator.isEmpty()
                        && Token.isOperator(token)
                        && !(operator.peek().equals("(") || operator.peek().equals(")"))
                        && hasHigherOrEqualPriority(token, operator.peek())
                ){
                    output.push(operator.pop());
                    while(
                            !operator.isEmpty()
                            && Token.isOperator(operator.peek())){
                            output.push(operator.pop()
                        );
                    }
                    operator.push(token);
                } else if(Token.isOperator(token)) {
                    operator.push(token);
                } if(token.equals("(")) {
                    operator.push(token);
                } else if(token.equals(")")) {
                    while(!operator.isEmpty() && !operator.peek().equals("(")){
                        output.push(operator.pop());
                    }
                    operator.pop();
                }
            }
        }

        while(!operator.isEmpty()){
            output.push(operator.pop());
        }

        while(!output.isEmpty()){
            operator.push(output.pop());
        }

        return operator;
    }

    public static String toRPNString(String expression){
        Stack<String> stack = toRPNStack(expression);
        String output = "";

        while(!stack.isEmpty()){
            output += stack.pop() + " ";
        }
        return output;
    }

    private static boolean hasHigherOrEqualPriority(String token, String topStack){
        if(token.equals(topStack)) return true;

        int tokenPriority = 0;
        int topPriority = 0;

        if(token.equals("*") || token.equals("/")){
            tokenPriority = 2;
        }

        if(topStack.equals("*") || topStack.equals("/")){
            topPriority = 2;
        }

        return tokenPriority <= topPriority;
    }
}
