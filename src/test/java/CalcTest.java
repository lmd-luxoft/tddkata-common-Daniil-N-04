import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalcTest {

    @Test
    public void newSeparator() {
        Calc calc = new Calc();
        int actual = calc.sum("2\n5");
        int expected = 7;
        assertEquals(expected, actual);
    }

    @Test
    public void newAndOld_Separator() {
        Calc calc = new Calc();
        int actual = calc.sum("2\n5,1");
        int expected = 8;
        assertEquals(expected, actual);
    }

    @Test
    public void emptyExpression() {
        Calc calc = new Calc();
        int actual = calc.sum("");
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void sum_twoNumbers1() {
        Calc calc = new Calc();
        int actual = calc.sum("1,2");
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    public void sum_twoNumbers2() {
        Calc calc = new Calc();
        int actual = calc.sum("1,1");
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    public void sum_threeNumbers() {
        Calc calc = new Calc();
        int actual = calc.sum("1,1,5");
        int expected = 7;
        assertEquals(expected, actual);
    }

    @Test
    public void sum_twoRealNumbers() {
        Calc calc = new Calc();
        int actual = calc.sum("1.1,2.6");
        int expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    public void sum_twoNumbers_negative() {
        Calc calc = new Calc();
        int actual = calc.sum("1 3");
        int expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    public void invalidExpression1() {
        Calc calc = new Calc();
        int actual = calc.sum("один");
        int expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    public void invalidExpression2() {
        Calc calc = new Calc();
        int actual = calc.sum("1");
        int expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    public void invalidExpression3() {
        Calc calc = new Calc();
        int actual = calc.sum("2\n,5");
        int expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    public void invalidExpression4() {
        Calc calc = new Calc();
        int actual = calc.sum("2,\n5");
        int expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    public void invalidExpression5() {
        Calc calc = new Calc();
        int actual = calc.sum("2,,5");
        int expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    public void invalidExpression6() {
        Calc calc = new Calc();
        int actual = calc.sum("2\n\n5");
        int expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    public void nullExpression() {
        Calc calc = new Calc();
        int actual = calc.sum(null);
        int expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    public void newSeparator1() {
        Calc calc = new Calc();
        int actual = calc.sum("//;\n1;2");
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    public void invalidExpression7() {
        Calc calc = new Calc();
        int actual = calc.sum("//;\n1\n2");
        int expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    public void invalidExpression8() {
        Calc calc = new Calc();
        int actual = calc.sum("//;1;2");
        int expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    public void invalidExpression9() {
        Calc calc = new Calc();
        assertThrows(NumberFormatException.class
                , () -> calc.sum("//;-1;2")
                , "Negatives are not allowed! Negative: -1" );
    }

    @Test
    public void invalidExpression10() {
        Calc calc = new Calc();
        assertThrows(NumberFormatException.class
                , () -> calc.sum("-1;-2")
                , "Negatives are not allowed! Negative: -1,-2" );
    }

}
