package calculator.evaluator;

import calculator.Token;
import calculator.parser.Parser;
import calculator.stack.Stack;

public class Evaluator {

    public static Double calculate(String input){
        Stack<String> stack = Parser.toRPNStack(input);
        Stack<Double> operandStack = new Stack<>();

        while(!stack.isEmpty()){
            if(Token.isOperator(stack.peek())){
                double rightOperand = operandStack.pop();
                double leftOperand = operandStack.pop();
                String operator = stack.pop();
                operandStack.push(operation(leftOperand, rightOperand, operator));
            } else if (Token.isNumber(stack.peek())) {
                operandStack.push(Double.parseDouble(stack.pop()));
            }
        }

        return operandStack.pop();
    }

    private static double operation(double leftOperand, double rightOperand, String operator){
        double result = 0;
        switch (operator){
            case "+" -> result = leftOperand + rightOperand;
            case "-" -> result = leftOperand - rightOperand;
            case "*" -> result = leftOperand * rightOperand;
            case "/"  -> result = leftOperand / rightOperand;
            default -> throw new IllegalArgumentException("Invalid operator:  " + operator);
        }
        return result;
    }
}
