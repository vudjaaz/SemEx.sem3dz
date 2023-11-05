package seminar3;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Program {

    /**
     Задача 1:
     =========
     1.  Создайте класс исключения, который будет выбрасываться при делении на
     0. Исключение должно отображать понятное для пользователя сообщение
     об ошибке.
     2.  Создайте класс исключений, которое будет возникать при обращении к
     пустому элементу в массиве ссылочного типа. Исключение должно
     отображать понятное для пользователя сообщение об ошибке
     3.  Создайте класс исключения, которое будет возникать при попытке открыть
     несуществующий файл. Исключение должно отображать понятное для
     пользователя сообщение об ошибке.
     4.* Продемонстрировать работу каждого исключения.
     */

    public static void main(String[] args) {

        try {
            task1();
        }
        catch (DivisionByZeroException e){
            System.out.println(e.getMessage());
        }

        try {
            task2(new String[]{"AA", "BB", "CC", "DD", "EE", "FF"}, 3);
            task2(new String[]{"AA", "BB", "CC", null, "EE", "FF"}, 3);
        }
        catch (NullElementArrayException e){
            System.out.println(e.getMessage());
            System.out.println("Индекс элемента: " + e.getIndex());
        }
        catch (ArrayIndexOutOfBoundsException | NullPointerException e){
            System.out.println(e.getMessage());
        }

        try
        {
            task3("D:/AA/BB/CC.txt");
        }
        catch (MyFileNotFountException e){
            System.out.printf("%s\nНаименование файла: %s\n",
                    e.getMessage(), e.getFileName());
        }

    }

    /**
     * Первая подзадача. Деление числа на 0.
     * @throws DivisionByZeroException ошибка деления числа на 0
     */
    static void task1() throws DivisionByZeroException{
        try
        {
            int a = 10 / 0;
        }
        catch (ArithmeticException e){
            throw new DivisionByZeroException("Ошибка деления числа на 0");
        }
    }


    /**
     * Получить значение элемента массива по индексу
     * @param array массив
     * @param index индекс элемента массива
     * @throws NullElementArrayException элемент массива не проинициализирован
     */
    static void task2(String[] array, int index) throws NullElementArrayException{
        if (array[index] == null){
            throw new NullElementArrayException("Элемент массива не проинициализирован", index);
        }
        System.out.printf("Значение элемента массива: %s\n", array[index]);
    }

    static void task3(String fileName) throws MyFileNotFountException {
        try (FileReader fileReader = new FileReader(fileName)){

        }
        catch (FileNotFoundException e){
            throw new MyFileNotFountException("Файл не найден", fileName);
        }
        catch (Exception e){

        }
    }


}
