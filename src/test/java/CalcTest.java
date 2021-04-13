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
}
