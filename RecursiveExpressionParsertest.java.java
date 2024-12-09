import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RecursiveExpressionParserTest {

    @Test
    public void testSimpleAddition() {
        assertEquals(8, RecursiveExpressionParser.evaluateExpression("3 + 5"));
    }

    @Test
    public void testSimpleSubtraction() {
        assertEquals(-2, RecursiveExpressionParser.evaluateExpression("3 - 5"));
    }

    @Test
    public void testSimpleMultiplication() {
        assertEquals(15, RecursiveExpressionParser.evaluateExpression("3 * 5"));
    }

    @Test
    public void testSimpleDivision() {
        assertEquals(3, RecursiveExpressionParser.evaluateExpression("15 / 5"));
    }

    @Test
    public void testOperatorPrecedence() {
        assertEquals(13, RecursiveExpressionParser.evaluateExpression("3 + 5 * 2"));
    }

    @Test
    public void testFloatingPointNumbers() {
        assertEquals(5.5, RecursiveExpressionParser.evaluateExpression("2.5 + 3.0"));
    }

    @Test
    public void testParentheses() {
        assertEquals(1, RecursiveExpressionParser.evaluateExpression("(3 + 5) - 7"));
    }

    @Test
    public void testComplexExpression() {
        assertEquals(16, RecursiveExpressionParser.evaluateExpression("3 + 2 * (5 + 3)"));
    }

    @Test
    public void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> {
            RecursiveExpressionParser.evaluateExpression("5 / 0");
        });
    }

    @Test
    public void testInvalidExpression() {
        assertThrows(NumberFormatException.class, () -> {
            RecursiveExpressionParser.evaluateExpression("invalid expression");
        });
    }
}
