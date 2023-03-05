// Ex_01 Реализовать задание и печать карты для волнового алгоритма

import java.util.Random;

public class Ex_01 {

    public static void main(String[] args) {

        // Границы для рандома размеров лабиринта
        int minBoard = 10;
        int maxBoard = 20;

        // Рандомное количетво строк и столбцов лабиринта
        int row = randomNum(minBoard, maxBoard);
        int column = randomNum(minBoard, maxBoard);

        // Создание лабиринта
        int[][] arr = greateArray(row, column);

        // Вывод лабиринта
        printArray(arr);
    }

    // Создание лабиринта
    public static int[][] greateArray(int row, int column) {

        int[][] array = new int[row][column];

        // Подготовка лабиринта (создание границ и рандомное заполнение
        // начиная со второй строки через строку)
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == 0 || j == 0 || i == array.length - 1 || j == array[i].length - 1) {
                    array[i][j] = -11;
                } else if (i % 2 != 0) { // (i == 1)
                    array[i][j] = randomNum(-1, 0);
                } else {
                    array[i][j] = 5;
                }
            }
        }

        // Заполнение начиная с третьей строки через строку
        for (int i = 2; i < array.length - 1; i += 2) {
            for (int j = 1; j < array[i].length - 1; j++) {
                if (array[i - 1][j] == 0 && array[i + 1][j] == 0 || array[i - 1][j] == 1 && array[i + 1][j] == 1) {
                    array[i][j] = randomNum(-1, 0);
                    // } else if (array[i - 1][j] == 0 && array[i + 1][j] == 0 && array[i][j - 1] ==
                    // 0) {
                    // array[i][j] = 0;
                } else {
                    array[i][j] = 0;
                }
                if (array.length % 2 == 0) {
                    if (array[array.length - 3][j] == 0 && array[array.length - 2][j - 1] == 0) {
                        array[array.length - 2][j] = 0;
                    } else if (array[array.length - 3][j] == -1 && array[array.length - 2][j - 1] != 0) {
                        array[array.length - 2][j] = -1;
                    } else {
                        array[array.length - 2][j] = randomNum(-1, 0);
                    }

                }
            }
        }

        return array;
    }

    // Печать лабиринта
    public static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(String.format("%3d", array[i][j]));
            }
            System.out.println("");
        }
    }

    // Рандом Integer
    public static int randomNum(int min, int max) {
        Random r = new Random();
        int randNum = r.nextInt(max + 1 - min) + min;
        return randNum;
    }
}