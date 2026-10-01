import calculator.Validator;
import calculator.evaluator.Evaluator;
import calculator.parser.Parser;

public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    System.out.println("Please enter an expression: ");
    String input = sc.nextLine();

    if(Validator.isValidInput(input)){
        System.out.println("Input: " + input);
        System.out.println("RPN: " + Parser.toRPNString(input));
        System.out.println("Result: " + Evaluator.calculate(input));
    } else {
        throw new IllegalArgumentException("Invalid input: " + input);
    }
}

