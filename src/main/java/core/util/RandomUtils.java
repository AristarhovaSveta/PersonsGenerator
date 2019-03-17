package core.util;

import org.joda.time.LocalDate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomUtils {
    private static final Random random = new Random(new Date().getTime());

    public static int randomNumber(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    public static String randomLineFromResourceFile(String resourceName) throws IOException {
        List<String> lines;
        try (InputStream resource = RandomUtils.class.getClassLoader().getResourceAsStream(resourceName)) {
            lines =
                    new BufferedReader(new InputStreamReader(resource,
                            StandardCharsets.UTF_8))
                            .lines()
                            .collect(Collectors.toList());
        }

        return lines.get(randomNumber(0, lines.size() - 1));
    }

    public static String randomInn() {
        StringBuilder inn = new StringBuilder();
        int firstControlNumber = 0;
        int secondControlNumber = 0;
        final int[] controlNumberCoefficients = new int[]{
                3, 7, 2, 4, 10, 3, 5, 9, 4, 6, 8
        };
        inn.append("77");
        firstControlNumber += controlNumberCoefficients[1] * 7;
        secondControlNumber += controlNumberCoefficients[0] * 7;
        firstControlNumber += controlNumberCoefficients[2] * 7;
        secondControlNumber += controlNumberCoefficients[1] * 7;
        for (int i = 2; i < 10; ++i) {
            int number = randomNumber(0, 9);
            firstControlNumber += controlNumberCoefficients[i + 1] * number;
            secondControlNumber += controlNumberCoefficients[i] * number;
            inn.append(number);
        }
        secondControlNumber += controlNumberCoefficients[10] * firstControlNumber;
        inn.append((firstControlNumber % 11) % 10);
        inn.append((secondControlNumber % 11) % 10);
        return inn.toString();
    }

    public static LocalDate randomDate(int yearRange) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        LocalDate now = LocalDate.now();

        int year = randomNumber(now.getYear() - yearRange, now.getYear());
        gregorianCalendar.set(GregorianCalendar.YEAR, year);

        int dayOfYear = randomNumber(1, gregorianCalendar.getActualMaximum(GregorianCalendar.DAY_OF_YEAR));
        gregorianCalendar.set(GregorianCalendar.DAY_OF_YEAR, dayOfYear);
        return new LocalDate(gregorianCalendar.getTime());
    }
}
