import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalcTest {

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
    public void nullExpression() {
        Calc calc = new Calc();
        int actual = calc.sum(null);
        int expected = -1;
        assertEquals(expected, actual);
    }

}
