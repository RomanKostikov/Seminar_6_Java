package org.example.cw1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 1) Дан массив чисел, посчитать процент уникальных чисел.
 * *процент уникальных чисел = количество уникальных чисел * 100 / общее количество чисел в массиве.
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 3, 2, 1, 5));
        Set<Integer> setList = new HashSet<>(list);
        System.out.printf("Процент уникальных чисел = %d", setList.size() * 100 / list.size());
    }
}
