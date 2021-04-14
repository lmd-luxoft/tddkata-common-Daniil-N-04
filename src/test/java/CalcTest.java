import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalcTest {
    Calc calc;

    @BeforeEach
    void setUp(){
        calc = new Calc();
    }

    @Nested
    class Positive {

        @Test
        void sum_lineSeparator() {
            int actual = calc.sum("2\n5");
            int expected = 7;
            assertEquals(expected, actual);
        }

        @Test
        void sum_defaultSeparators() {
            int actual = calc.sum("2\n5,1");
            int expected = 8;
            assertEquals(expected, actual);
        }

        @Test
        void sum_emptyExpression() {
            int actual = calc.sum("");
            int expected = 0;
            assertEquals(expected, actual);
        }

        @Test
        void sum_twoDifferentDigitsSeparatedByComma() {
            int actual = calc.sum("1,2");
            int expected = 3;
            assertEquals(expected, actual);
        }

        @Test
        void sum_twoDigitsWithCommaSeparator() {
            int actual = calc.sum("1,1");
            int expected = 2;
            assertEquals(expected, actual);
        }

        @Test
        void sum_threeDigitsSeparatedByComma() {
            int actual = calc.sum("1,1,5");
            int expected = 7;
            assertEquals(expected, actual);
        }

        @Test
        void sum_customSeparate() {
            int actual = calc.sum("//;\n1;2");
            int expected = 3;
            assertEquals(expected, actual);
        }
    }

    @Nested
    class Negative {

        @Test
        void sum_floatNumbers() {
            int actual = calc.sum("1.1,2.6");
            int expected = -1;
            assertEquals(expected, actual);
        }

        @Test
        void sum_whiteSpaceSeparator() {
            int actual = calc.sum("1 3");
            int expected = -1;
            assertEquals(expected, actual);
        }

        @Test
        void sum_oneWordExpression() {
            int actual = calc.sum("один");
            int expected = -1;
            assertEquals(expected, actual);
        }

        @Test
        void sum_oneDigit() {
            int actual = calc.sum("1");
            int expected = -1;
            assertEquals(expected, actual);
        }

        @Test
        void sum_lineWithCommaSeparator() {
            int actual = calc.sum("2\n,5");
            int expected = -1;
            assertEquals(expected, actual);
        }

        @Test
        void sum_commaWithLineSeparator() {
            int actual = calc.sum("2,\n5");
            int expected = -1;
            assertEquals(expected, actual);
        }

        @Test
        void sum_doubleCommaSeparator() {
            int actual = calc.sum("2,,5");
            int expected = -1;
            assertEquals(expected, actual);
        }

        @Test
        void sum_doubleLineSeparator() {
            int actual = calc.sum("2\n\n5");
            int expected = -1;
            assertEquals(expected, actual);
        }

        @Test
        void sum_nullExpression() {
            int actual = calc.sum(null);
            int expected = -1;
            assertEquals(expected, actual);
        }

        @Test
        void sum_notUsedCustomSeparator() {
            int actual = calc.sum("//;\n1\n2");
            int expected = -1;
            assertEquals(expected, actual);
        }

        @Test
        void sum_incorrectlySetCustomSeparator() {
            int actual = calc.sum("//;1;2");
            int expected = -1;
            assertEquals(expected, actual);
        }

        @Test
        void sum_invalidExpression() {
            int actual = calc.sum("//\n\n1\n2");
            int expected = -1;
            assertEquals(expected, actual);
        }

        @Test
        void sum_negativeDigitByCustomSeparator() {
            Throwable throwable = assertThrows(Calc.CustomNumberFormatError.class, () -> calc.sum("//;\n-1;2"));
            assertEquals("Negatives are not allowed! Negative: -1", throwable.getMessage());
        }

        @Test
        void sum_negativeDigitsByCommaSeparator() {
            Throwable throwable = assertThrows(Calc.CustomNumberFormatError.class, () -> calc.sum("-1,-2"));
            assertEquals("Negatives are not allowed! Negative: -1,-2", throwable.getMessage());
        }
    }
}
