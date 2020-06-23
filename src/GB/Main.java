package GB;

import java.util.Arrays;
import java.util.Random;

public class Main {                         //условимся сразу, что работаем только с двумерными массивами
    static Random random = new Random();

    public static void main(String[] args) {
        //Дополнительное ДЗ к первому уроку
        displayWorkingHours(DayOfWeek.MONDAY);
        displayWorkingHours(DayOfWeek.FRIDAY);

        //ДЗ второго урока
        String[][] array = createArray();
        String[][] array2 = new String[][]{{"1","2","3","4"},{"4","2","1","hello"}};
        try {   //блок рассчитан на работу с одним массивом, но так как я знаю, что первый пройдет, то раскомментировал второй
            displayArray(array);
            sumArrayElements(array);
            displayArray(array2);
            sumArrayElements(array2);
        } catch (MyArraySizeException e){
            e.displayInfo();
        }
    }

    static void displayWorkingHours(DayOfWeek day){     //выжимаем из перечислений по максимуму
        System.out.println("Ваш день недели: " + day.getRusDayOfWeek() + "\tРабочих часов до конца недели: " + day.getRemainingWorkingHours(day));
    }

    static void sumArrayElements(String[][] array) throws MyArraySizeException{
        int sum = 0;
        if (array.length != 4 || array[0].length != 4){
            throw new MyArraySizeException("Допустимый массив 4х4", array.length, array[0].length);
        }

        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                try {
                    if (!array[i][j].matches("\\d+")) { //примитивная проверка на числа, тут проканает
                        throw new MyArrayDataException("Вызываем свое исключение", i, j);
                    } else {
                        sum += Integer.parseInt(array[i][j]);
                    }
                } catch (MyArrayDataException e) {
                    e.displayInfo();
                }
            }
        }
        System.out.println("Сумма числовых элементов массива = " + sum);
    }

    static String[][] createArray(){
        String[][] array = new String[4][4];
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                array[i][j] = String.valueOf(random.nextInt(101));
            }
        }
        array[random.nextInt(array.length)][random.nextInt(array[0].length)] = "Duke";
        array[random.nextInt(array.length)][random.nextInt(array[0].length)] = "Hello";
        return array;
    }

    static void displayArray(String[][] array) {
        System.out.println("Ваш массив: ");
        for (String[] elm : array) {
            System.out.println(Arrays.toString(elm));
        }
    }

}
