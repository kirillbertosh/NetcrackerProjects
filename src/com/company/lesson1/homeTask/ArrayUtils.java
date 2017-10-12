package com.company.lesson1.homeTask;

public class ArrayUtils {

    static int[] sort(int[] array) {
        int[] resultArray = array;
        for (int i = resultArray.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (resultArray[j] > resultArray[j+1]) {
                    int temp = resultArray[j];
                    resultArray[j] = resultArray[j + 1];
                    resultArray[j + 1] = temp;
                }
            }
        }
        return resultArray;
    }

    static int[] inverse(int[] array) {
        int[] resultArray = new int[array.length];
        int j = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            resultArray[j] = array[i];
            j++;
        }
        return resultArray;
    }

    static boolean inArray(int[] array, int searchItem) {
        return searchElement(array, searchItem) != -1;
    }

    static int searchElement(int[] array, int searchItem) {
        int resultIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == searchItem) return i;
        }
        return  resultIndex;
    }

    static boolean replace(int[] array, int replaceItem, int newItem) {
        if (inArray(array, replaceItem)) {
            array[searchElement(array, replaceItem)] = newItem;
            return true;
        }
        else return false;
    }

}

