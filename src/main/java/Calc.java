import java.util.Arrays;

import static java.util.Objects.isNull;

public class Calc {

    public int sum(String expression) {
        if (isNull(expression))
            return -1;
        else if (expression.isEmpty())
            return 0;

        String[] numbers = expression.split("\\,");
        if (numbers.length == 1)
            return -1;

        return Arrays.stream(numbers).map(Integer::parseInt).mapToInt(n -> n).sum();
    }
}
