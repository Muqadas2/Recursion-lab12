import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RecursiveExpressionParser {

    /**
     * Parses and evaluates a mathematical expression recursively.
     * Supports +, -, *, and / while maintaining proper operator precedence.
     * 
     * @param expression The string representing the mathematical expression
     * @return The evaluated result as a double
     */
    public static double evaluateExpression(String expression) {
        // Remove spaces for easier parsing
        expression = expression.replaceAll("\\s+", "");

        // Handle parenthetical expressions first
        while (expression.contains("(")) {
            expression = evaluateParentheses(expression);
        }

        // Evaluate * and / first
        double result = evaluateMultiplicationDivision(expression);

        return result;
    }

    /**
     * Handles parenthetical expressions recursively.
     */
    private static String evaluateParentheses(String expression) {
        Pattern pattern = Pattern.compile("\\(([^()]+)\\)");
        Matcher matcher = pattern.matcher(expression);

        while (matcher.find()) {
            String innerExpression = matcher.group(1);
            double evaluated = evaluateMultiplicationDivision(innerExpression);
            expression = expression.replace(matcher.group(0), String.valueOf(evaluated));
            matcher = pattern.matcher(expression);
        }

        return expression;
    }

    /**
     * Handles * and / operations.
     */
    private static double evaluateMultiplicationDivision(String expression) {
        Pattern pattern = Pattern.compile("(-?\\d+(\\.\\d+)?)([\\*/])(-?\\d+(\\.\\d+)?)");
        Matcher matcher = pattern.matcher(expression);

        while (matcher.find()) {
            double operand1 = Double.parseDouble(matcher.group(1));
            String operator = matcher.group(3);
            double operand2 = Double.parseDouble(matcher.group(4));
            double result = 0.0;

            if (operator.equals("*")) {
                result = operand1 * operand2;
            } else if (operator.equals("/")) {
                if (operand2 == 0) throw new ArithmeticException("Division by zero.");
                result = operand1 / operand2;
            }

            expression = expression.replace(matcher.group(0), String.valueOf(result));
            matcher = pattern.matcher(expression);
        }

        return evaluateAdditionSubtraction(expression);
    }

    /**
     * Handles + and - operations.
     */
    private static double evaluateAdditionSubtraction(String expression) {
        Pattern pattern = Pattern.compile("(-?\\d+(\\.\\d+)?)([\\+\\-])(-?\\d+(\\.\\d+)?)");
        Matcher matcher = pattern.matcher(expression);

        while (matcher.find()) {
            double operand1 = Double.parseDouble(matcher.group(1));
            String operator = matcher.group(3);
            double operand2 = Double.parseDouble(matcher.group(4));
            double result = 0.0;

            if (operator.equals("+")) {
                result = operand1 + operand2;
            } else if (operator.equals("-")) {
                result = operand1 - operand2;
            }

            expression = expression.replace(matcher.group(0), String.valueOf(result));
            matcher = pattern.matcher(expression);
        }

        return Double.parseDouble(expression);
    }
}
