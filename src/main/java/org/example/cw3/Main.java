package org.example.cw3;

import java.util.*;

/**
 * 3) Найти пересечения слов в массивах и указать их общее количество.
 * Пример:
 * Mas1= [“qwe”,”asd”,”qwe”,”x”]
 * Mas2=[“qwe”,”v”]
 * Результат:
 * qwe=3
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>(Arrays.asList("qwe", "asd", "qwe", "x"));
        ArrayList<String> list2 = new ArrayList<>(Arrays.asList("v", "qwe"));
        Map<String, Integer> mapList = new HashMap<>();
        for (int i = 0; i < list1.size(); i++) {
            mapList.putIfAbsent(list1.get(i), 0);
            mapList.put(list1.get(i), mapList.get(list1.get(i)) + 1);
        }
        for (int i = 0; i < list2.size(); i++) {
            mapList.putIfAbsent(list2.get(i), 0);
            mapList.put(list2.get(i), mapList.get(list2.get(i)) + 1);
        }
        Set<String> setList = new HashSet<>(list1);
        setList.retainAll(new HashSet<>(list2));
        if (setList.size() > 0) {
            for (String el : setList) {
                System.out.printf("%s = %d%n", el, mapList.get(el));
            }
        } else System.out.println("Пересечений нет!");
    }
}
