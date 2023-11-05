package seminar1;

import java.util.Random;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        //System.out.printf("Кол-во элементов массива: %d\n", task1(new int[] {5, -5, 1, 2}));
        //task2();
        //task3();
        //task4();
        task5();
    }

    /**
     * Задача 1
     * ========
     * Реализуйте метод, принимающий в качестве аргумента целочисленный массив.
     * Если длина массива меньше некоторого заданного минимума, метод возвращает
     * -1, в качестве кода ошибки, иначе - длину массива.
     */

    static int task1(int[] array) {
        if (array == null)
            return -2;
        if (array.length == 0)
            return -1;
        return array.length;
    }

    /**
     * Задача 2
     * ========
     * Реализуйте метод, принимающий в качестве аргумента целочисленный массив и некоторое значение.
     * Метод ищет в массиве заданное значение и возвращает его индекс. При этом, например:
     * 1. если длина массива меньше некоторого заданного минимума, метод возвращает -1, в качестве кода ошибки.
     * 2. если искомый элемент не найден, метод вернет -2 в качестве кода ошибки.
     * 3. если вместо массива пришел null, метод вернет -3
     * 4. придумайте свои варианты исключительных ситуаций и верните соответствующие коды ошибок.
     * Напишите метод, в котором реализуйте взаимодействие с пользователем.
     * То есть, этот метод запросит искомое число у пользователя, вызовет первый,
     * обработает возвращенное значение и покажет читаемый результат пользователю.
     * Например, если вернулся -2, пользователю выведется сообщение: “Искомый элемент не найден”.
     */

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    static void task2() {

        while (true) {

            System.out.print("Укажите значение для поиска: ");
            int searchNumber = Integer.parseInt(scanner.nextLine());
            int[] array = new int[random.nextInt(1, 6)];
            if (random.nextInt(3) == 0) { // 33%
                array = null;
            }
            if (array != null) {
                for (int i = 0; i < array.length; i++) {
                    array[i] = random.nextInt(10);
                    System.out.printf("%d\t", array[i]);
                }
                System.out.println();
            }

            int codeResult = processArray(array, searchNumber);
            switch (codeResult) {
                case -1 -> System.out.println("Кол-во элементов массива меньше трех символов");
                case -2 -> System.out.println("Элемент не найден");
                case -3 -> System.out.println("Массив некорректно проинициализирован");
                default -> {
                    System.out.println("Массив успешно обработан. Завершение работы приложения.");
                    System.out.printf("Элемент найден по индексу: %d\n", codeResult);
                    return;
                }
            }
        }
    }

    static int processArray(int[] array, int searchValue) {
        if (array == null)
            return -3; // Массив некорректно проинициализирован
        if (array.length < 3)
            return -1; // Кол-во элементов массива меньше трех символов
        for (int i = 0; i < array.length; i++) {
            if (array[i] == searchValue)
                return i;
        }
        return -2; // Элемент не найден
    }

    /**
     * Задача 3
     * ========
     * Реализуйте метод, принимающий в качестве аргумента целочисленный двумерный массив.
     * Необходимо посчитать и вернуть сумму элементов этого массива.
     * При этом накладываем на метод 2 ограничения: метод может работать только с квадратными массивами
     * (кол-во строк = кол-ву столбцов), и в каждой ячейке может лежать только значение 0 или 1.
     * Если нарушается одно из условий, метод должен бросить RuntimeException с сообщением об ошибки.
     */

    static void task3() {
        for (int i = 0; i < 5; i++) {
            processArray(generateArray());
        }
    }

    static void processArray(int[][] array) {
        if (array.length != array[0].length)
            throw new RuntimeException(String.format("Некорректная размерность массива. Ожидали квадратный массив, получили [%d][%d]",
                    array.length, array[0].length));
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] != 0 && array[i][j] != 1) {
                    throw new RuntimeException(String.format("Некорректное значение элемента массива по индексу [%d][%d]",
                            i, j));
                } else {
                    sum += array[i][j];
                }
            }
        }
        System.out.println("Сумма всех элементов массива: " + sum);
    }

    static int[][] generateArray() {

        int[][] array = new int[random.nextInt(4, 6)][5]; // 50%
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = random.nextInt(2);
            }
        }
        if (random.nextInt(3) == 0) // 33%
        {
            array[random.nextInt(array.length)][random.nextInt(array[0].length)] = 2;
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.printf("%d ", array[i][j]);
            }
            System.out.println();
        }
        return array;

    }

    /**
     * Задача 4
     * ========
     * Переработать реализацию задачи 3 с использованием кодов ошибок
     */
    static void task4() {
        for (int i = 0; i < 5; i++) {
            int operationResult = processArrayV2(generateArray());
            switch (operationResult) {
                case -1 -> System.out.println("Некорректная размерность массива");
                case -2 -> System.out.println("Некорректное значение элемента массива");
                default -> {
                    System.out.println("Сумма всех элементов массива: " + operationResult);
                }
            }
        }
    }

    static int processArrayV2(int[][] array) {
        if (array.length != array[0].length)
            return -1;
        //throw new RuntimeException(String.format("Некорректная размерность массива. Ожидали квадратный массив, получили [%d][%d]",
        //        array.length, array[0].length));
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] != 0 && array[i][j] != 1) {
                    return -2;
                    //throw new RuntimeException(String.format("Некорректное значение элемента массива по индексу [%d][%d]",
                    //        i, j));
                } else {
                    sum += array[i][j];
                }
            }
        }
        return sum;
        //System.out.println("Сумма всех элементов массива: " + sum);
    }

    /**
     * Задача 5
     * ========
     * Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
     * и возвращающий новый массив, каждый элемент которого равен сумме элементов двух
     * входящих массивов в той же ячейке.
     * Если длины массивов не равны, необходимо как-то оповестить пользователя.
     */


    static void task5() {

        try {

            int[] res = getSumArray(null, new int[]{-1, 6, 5, -1, -1});
            for (int e : res) {
                System.out.printf("%d\t", e);
            }
            System.out.println();
        }
        catch (CustomArraySizeException e){
            System.out.println(e.getMessage());
            System.out.println("Размерность первого массива: " + e.getLength1());
            System.out.println("Размерность второго массива: " + e.getLength2());
        }
        catch (NullPointerException e){
            e.printStackTrace();
            //System.out.println(e.getMessage());
        }
    }

    static int[] getSumArray(int[] array1, int[] array2) {
        if (array1 == null || array2 == null) {
            throw new NullPointerException("Оба массива должны существовать!");
        }
        if (array1.length != array2.length) {
            throw new CustomArraySizeException("Кол-во элементов массива должно быть одинаковым.",
                    array1.length, array2.length);
        }
        int[] res = new int[array1.length];
        for (int i = 0; i < array1.length; i++) {
            res[i] = array1[i] + array2[i];
        }
        return res;
    }


}