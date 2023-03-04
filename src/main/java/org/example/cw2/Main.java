package org.example.cw2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 2) Найти пересечение двух множеств
 * Пример:
 * set1= [1,2,3,4]
 * set2= [3,5,6,7]
 * Вывод в консоль:
 * [3]
 */
public class Main {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> set2 = new HashSet(Arrays.asList(4, 5, 6, 7, 8));
        Set<Integer> tmpSet = new HashSet<>(set1);
        tmpSet.retainAll(set2);
        System.out.println(set1);
        System.out.println(set2);
        System.out.println(tmpSet);
    }
}
