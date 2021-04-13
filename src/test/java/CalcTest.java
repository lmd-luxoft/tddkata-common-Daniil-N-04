import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalcTest {

    @Test
    public void test_sum() {
        Calc calc = new Calc();
        int actual = calc.sum("");
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void test_sum1_2() {
        Calc calc = new Calc();
        int actual = calc.sum("1,2");
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    public void test_sum1_1() {
        Calc calc = new Calc();
        int actual = calc.sum("1,1");
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    public void test_sum1_3() {
        Calc calc = new Calc();
        int actual = calc.sum("1,1,5");
        int expected = 7;
        assertEquals(expected, actual);
    }

    @Test
    public void test_sum_negative_1() {
        Calc calc = new Calc();
        int actual = calc.sum("1 3");
        int expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    public void test_sum_negative_2() {
        Calc calc = new Calc();
        int actual = calc.sum("один");
        int expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    public void test_sum_negative_3() {
        Calc calc = new Calc();
        int actual = calc.sum("1");
        int expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    public void test_sum_negative_4() {
        Calc calc = new Calc();
        int actual = calc.sum(null);
        int expected = -1;
        assertEquals(expected, actual);
    }

}
