package com.company.lesson1.homeTask;

public class Calculation {

    public static int getMaxElement(int[] array) {
        int temp = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > temp) {
                temp = array[i];
            }
        }
        return temp;
    }

    public static int getMinElement(int[] array) {
        int temp = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < temp) {
                temp = array[i];
            }
        }
        return temp;
    }

    public static int getAverage(int[] array) {
        int temp = 0;
        for (int anArray : array) {
            temp += anArray;
        }
        temp /= array.length;
        return temp;
    }

    public static int getCount(int[] array) {
        return array.length;
    }

    public static int getSum(int[] array) {
        int temp = 0;
        for (int anArray : array) {
            temp += anArray;
        }
        return temp;
    }

}

