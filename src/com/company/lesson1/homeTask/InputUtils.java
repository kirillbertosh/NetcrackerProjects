package com.company.lesson1.homeTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputUtils {

    public static int getInt() {
        int i = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            i = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return i;
    }

    public static int[] insertIntoArray(int[] array) {
        int[] temp = new int[10];
        int i = 0;
        for (; i < 10; i++) {
            int value = getInt();
            if (value == -1) break;
            temp[i] = value;
        }
        array = new int[i];
        System.arraycopy(temp, 0, array, 0, i);
        return array;
    }
}
