package filterapp.cli;

public class Statistics {
    private int integerCount = 0;
    private int floatCount = 0;
    private int stringCount = 0;

    private int minInteger = Integer.MAX_VALUE;
    private int maxInteger = Integer.MIN_VALUE;
    private long sumIntegers = 0;

    private double minFloat = Double.MAX_VALUE;
    private double maxFloat = Double.MIN_VALUE;
    private double sumFloats = 0.0;

    private int shortestString = Integer.MAX_VALUE;
    private int longestString = 0;

    public void addInteger(int number) {
        integerCount++;
        sumIntegers += number;
        minInteger = Math.min(minInteger, number);
        maxInteger = Math.max(maxInteger, number);
    }

    public void addDouble(double number) {
        floatCount++;
        sumFloats += number;
        minFloat = Math.min(minFloat, number);
        maxFloat = Math.max(maxFloat, number);
    }

    public void addString(String text) {
        stringCount++;
        int length = text.length();
        shortestString = Math.min(shortestString, length);
        longestString = Math.max(longestString, length);
    }

    public void printShortStats() {
        System.out.println("Краткая статистика:");
        System.out.println("Целые числа: " + integerCount);
        System.out.println("Вещественные числа: " + floatCount);
        System.out.println("Строки: " + stringCount);
    }

    public void printFullStats() {
        System.out.println("Полная статистика:");
        if (integerCount > 0) {
            System.out.printf(
                    "Целые числа: %d (min=%d, max=%d, sum=%d, avg=%.2f)\n",
                    integerCount, minInteger, maxInteger, sumIntegers,
                    (double) sumIntegers / integerCount
            );
        }
        if (floatCount > 0) {
            System.out.printf(
                    "Вещественные числа: %d (min=%.2f, max=%.2f, sum=%.2f, avg=%.2f)\n",
                    floatCount, minFloat, maxFloat, sumFloats,
                    sumFloats / floatCount
            );
        }
        if (stringCount > 0) {
            System.out.printf(
                    "Строки: %d (min_length=%d, max_length=%d)\n",
                    stringCount, shortestString, longestString
            );
        }
    }
}
