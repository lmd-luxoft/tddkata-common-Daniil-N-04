import java.util.Arrays;

import static java.util.Objects.isNull;

public class Calc {
    private String[] numbers;

    public int sum(String expression) {
        if (isNull(expression))
            return -1;
        else if (expression.isEmpty())
            return 0;

        numbers = expression.split("\\,");

        return numbers.length == 1
                ? -1
                : getSum();
    }

    private int getSum() {
        try {
            return Arrays.stream(numbers).map(Integer::parseInt).mapToInt(n -> n).sum();
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
