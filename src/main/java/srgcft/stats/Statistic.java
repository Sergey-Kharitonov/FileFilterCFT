package srgcft.stats;


/*
Статистика должна поддерживаться двух видов: краткая и полная. Выбор статистики
производится опциями -s и -f соответственно.
 Краткая статистика содержит только
количество элементов записанных в исходящие файлы.

Полная статистика для чисел
дополнительно содержит минимальное и максимальное значения, сумма и среднее.
Полная статистика для строк, помимо их количества, содержит также размер самой
короткой строки и самой длинной
 */


public class Statistic {

    public static void showStatistic(boolean shortStatsArg, boolean fullStatsArg) {
        if (shortStatsArg) {
            System.out.println("Краткая статистика:\n" +
                    IntegerStats.countInteger + " - Количество записанных целочисленных элементов\n" +
                    "~~~~~~~~~~~~~~~~~~\n" +
                    FloatStats.countFloat + " - Количество записанных элементов вещественных чисел\n" +
                    "~~~~~~~~~~~~~~~~~~\n" +
                    StringStats.countString + " - Количество записанных строковых элементов");

        }
        if (fullStatsArg) {
            System.out.println("Полная статистика:\n" +
                    IntegerStats.countInteger + " - Количество записанных целочисленных элементов\n" +
                    IntegerStats.minInteger + " - Минимальное целое число\n" +
                    IntegerStats.maxInteger + " - Максимальное целое число\n" +
                    IntegerStats.sumInteger + " - Сумма всех целых чисел\n" +
                    IntegerStats.avgInteger + " - Среднее значение для целых чисел\n" +
                    "~~~~~~~~~~~~~~~~~~\n" +
                    FloatStats.countFloat + " - Количество записанных элементов вещественных чисел\n" +
                    FloatStats.minFloat + " - Минимальное вещественное число\n" +
                    FloatStats.maxFloat + " - Максимальное вещественное число\n" +
                    FloatStats.sumFloat + " - Сумма всех вещественных чисел\n" +
                    FloatStats.avgFloat + " - Среднее значение для вещественных чисел\n" +
                    "~~~~~~~~~~~~~~~~~~\n" +
                    StringStats.countString + " - Количество записанных строковых элементов\n" +
                    StringStats.minString + " - Строка с минимальным количеством символов (включая пробел)\n" +
                    StringStats.maxString + " - Строка с максимальным количеством символов (включая пробел)\n"
            );

        }
    }
}
