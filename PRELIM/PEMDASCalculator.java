import java.util.Stack;
import java.util.Scanner;

public class PEMDASCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

            System.out.print("Enter an equation (or 'e' to exit): ");
            String input = sc.nextLine();

            if (input.equalsIgnoreCase("e")) {
            }

            try {
                double result = evaluateExpression(input);
                System.out.println("Result: " + result);
            } catch (Exception e) {
                System.out.println("Invalid expression: " + e.getMessage());
            }
        sc.close();
    }

    public static double evaluateExpression(String expression) throws Exception {
        // Remove whitespace from the expression
        expression = expression.replaceAll("\\s+", "");

        // Split the expression into individual tokens
        String[] tokens = expression.split("(?=[-+*/()])|(?<=[-+*/()])");

        // Initialize stacks for operators and operands
        Stack<Character> operators = new Stack<>();
        Stack<Double> operands = new Stack<>();

        for (String token : tokens) {
            char c = token.charAt(0);
            if (Character.isDigit(c) || (c == '-' && token.length() > 1 && Character.isDigit(token.charAt(1)))) {
                // Parse and push operands onto the stack
                operands.push(Double.parseDouble(token));
            } else if (isOperator(c)) {
                // Process operators
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(c)) {
                    performOperation(operators, operands);
                }
                operators.push(c);
            } else if (c == '(') {
                operators.push(c);
            } else if (c == ')') {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    performOperation(operators, operands);
                }
                if (!operators.isEmpty() && operators.peek() == '(') {
                    operators.pop();
                } else {
                    throw new Exception("Mismatched parentheses");
                }
            } else {
                throw new Exception("Invalid character: " + c);
            }
        }

        // Process any remaining operators
        while (!operators.isEmpty()) {
            if (operators.peek() == '(') {
                throw new Exception("Mismatched parentheses");
            }
            performOperation(operators, operands);
        }

        if (operands.size() != 1) {
            throw new Exception("Invalid expression");
        }

        return operands.pop();
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return 0;
        }
    }

    private static void performOperation(Stack<Character> operators, Stack<Double> operands) throws Exception {
        if (operands.size() < 2 || operators.isEmpty()) {
            throw new Exception("Invalid expression");
        }
        char operator = operators.pop();
        double operand2 = operands.pop();
        double operand1 = operands.pop();
        double result = applyOperator(operator, operand1, operand2);
        operands.push(result);
    }

    private static double applyOperator(char operator, double operand1, double operand2) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return operand1 / operand2;
            case '^':
                return Math.pow(operand1, operand2);
            default:
                return 0.0;
        }
    }
}