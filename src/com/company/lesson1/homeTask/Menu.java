package com.company.lesson1.homeTask;

public class Menu {

    public static void showMenu(int [] array){
        boolean exit = false;
        int response;
        System.out.println("Введите числа, не больше 10 штук");
        System.out.println("Для окончания ввода введите -1'");
        array = InputUtils.insertIntoArray(array);
        while (!exit) {
            System.out.print("1 - Операции \n"
                    + "2 - Печать \n"
                    + "3 - Поиск\n"
                    + "0 - Выход\n");
            response = InputUtils.getInt();
            switch (response) {
                case 1:
                    menuOperation(array);
                    break;
                case 2:
                    menuPrint(array);
                    break;
                case 3:
                    menuSearch(array);
                    break;
                case 0:
                    System.out.println("Выбран выход, досвидания");
                    exit = true;
                    break;
                default:
                    System.out.println("Некорректный ввод, на что-то не то нажал? повтори еще раз \n");
            }
        }
    }

    public static void menuOperation(int [] array) {
        boolean exit = false;
        int response;
        while (!exit) {
            System.out.println("1 - Операции \n"
                    + "1.1 - Max число\n"
                    + "1.2 - Min число\n"
                    + "1.3 - Количество элементов в массиве\n"
                    + "1.4 - Сумма элементов\n"
                    + "1.5 - Среднее арифметическое\n"
                    + "0 - Назад\n\n");
            response = InputUtils.getInt();
            switch (response) {
                case 0:
                    exit = true;
                    break;
                case 1:
                    System.out.println("Максимальный элемент массива = " + Calculation.getMaxElement(array));
                    break;
                case 2:
                    System.out.println("Минимальный элемент массива = " + Calculation.getMinElement(array));
                    break;
                case 3:
                    System.out.println("Число элементов массива  = " + Calculation.getCount(array));
                    break;
                case 4:
                    System.out.println("Сумма элементо массива = " + Calculation.getSum(array));
                    break;
                case 5:
                    System.out.println("Среднее значение массива = " + Calculation.getAverage(array));
                    break;
                default:
                    System.out.println("Некорректный ввод, на что-то не то нажал? повтори еще раз \n");
            }
        }
    }

    public static void menuPrint(int[] array) {
        boolean exit = false;
        int response;
        while (!exit) {
            System.out.print("1 - Печать массива в прямом порядке \n"
                    + "2 - Печать массива в обратном порядке \n"
                    + "3 - Печать массива в отсортированном порядке\n"
                    + "0 - Выход\n");
            response = InputUtils.getInt();
            switch (response) {
                case 0:
                    exit = true;
                    break;
                case 1:
                    for (int item : array) {
                        System.out.println(item);
                    }
                    break;
                case 2:
                    for (int item : ArrayUtils.inverse(array)) {
                        System.out.println(item);
                    }
                    break;
                case 3:
                    for (int item : ArrayUtils.sort(array)) {
                        System.out.println(item);
                    }
                    break;
                default:
                    System.out.println("Некорректный ввод, на что-то не то нажал? повтори еще раз \n");
            }
        }
    }

    public static void menuSearch(int[] array) {
        boolean exit = false;
        int response;
        while (!exit) {
            System.out.print("1 - Проверить, входит ли число в массив \n"
                    + "2 - Заменить элемент массива на другой \n"
                    + "0 - Выход\n");
            response = InputUtils.getInt();
            switch (response) {
                case 0:
                    exit = true;
                    break;
                case 1:
                    System.out.println("Введите элемент для поиска");
                    int searchItem = InputUtils.getInt();
                    System.out.println(ArrayUtils.searchElement(array, searchItem));
                    break;
                case 2:
                    System.out.println("Введите элемент для замены");
                    int replaceItem = InputUtils.getInt();
                    System.out.println("Введите новый элемент");
                    int newItem = InputUtils.getInt();
                    System.out.println(ArrayUtils.replace(array, replaceItem, newItem));
                    break;
                default:
                    System.out.println("Некорректный ввод, на что-то не то нажал? повтори еще раз \n");
            }
        }
    }

}