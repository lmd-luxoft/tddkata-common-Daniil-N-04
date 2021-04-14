import java.util.Arrays;
import java.util.List;

import static java.util.Objects.isNull;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Calc {
    private static final int ERROR = -1;
    private String[] numbers;
    private String exp;

    public int sum(String expression) {
        exp = expression;
        if (isNull(exp))
            return ERROR;
        if (exp.isEmpty())
            return 0;

        String separator = getSeparator();
        numbers = exp.split(separator);

        return getSum();
    }

    private int getSum() {
        if (numbers.length == 1)
            return ERROR;

        try {
            List<Integer> list = Arrays.stream(numbers).mapToInt(Integer::parseInt).boxed().collect(toList());
            checkNegativeNumbers(list);
            return list.stream().mapToInt(n -> n).sum();
        } catch (NumberFormatException e) {
            return ERROR;
        }
    }

    private String getSeparator() {
        String separator = "";
        if (exp.startsWith("//")) {
            String[] customSeparator = exp.split("\n");
            if (customSeparator.length > 1 && customSeparator[0].matches("//.+")) {
                exp = exp.substring(customSeparator[0].length() + 1);
                separator = customSeparator[0].substring(2);
            }
        }
        return separator.isEmpty() ? ",|\n" : separator;
    }

    private void checkNegativeNumbers(List<Integer> list) {
        List<Integer> negativeNumbers = list.stream().filter(number -> number < 0).collect(toList());
        if (!negativeNumbers.isEmpty())
            throw new CustomNumberFormatError("Negatives are not allowed! Negative: " +
                    negativeNumbers.stream().map(String::valueOf).collect(joining(",")));
    }

    public static class CustomNumberFormatError extends Error {

        CustomNumberFormatError(String message) {
            super(message);
        }
    }
}
