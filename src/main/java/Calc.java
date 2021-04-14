import java.util.Arrays;

import static java.util.Objects.isNull;

public class Calc {
    private String[] numbers;
    private String exp;

    public int sum(String expression) {
        this.exp = expression;
        if (isNull(exp))
            return -1;
        else if (exp.isEmpty())
            return 0;

        String separator = getSeparator();

        numbers = separator.isEmpty() ? exp.split("\\,|\n") : exp.split(separator);

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

    private String getSeparator() {
        String separator = "";
        if (exp.startsWith("//")) {
            String[] customSeparator = exp.substring(0,4).split("\n");
            if (customSeparator.length == 1 && customSeparator[0].matches("//.")) {
                exp = exp.substring(4);
                separator = customSeparator[0].substring(2,3);
            }
        }
        return separator;
    }
}
