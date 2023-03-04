package org.example.hw;

import java.util.*;

/**
 * Класс хранящий множество объектов и обрабатывающий поисковые запросы
 */
public class DataBase {
    Laptop lap1 = new Laptop("Nitro 5", "Acer", 15.4, 2020,
            "Windows", "Intel", "Core i5 12500H", 16,
            "Discrete/BuiltIn", "AMD Radeon Graphics",
            " NVIDIA GeForce RTX 3060", 8, "SSD", 512, 0,
            "Game", "Space Gray", 1000.5);
    Laptop lap2 = new Laptop("IdeaPad 315ITL6", "Lenovo", 15.6, 2021,
            "NoOS", "Intel", "Core i5 1135G7", 8,
            "BuiltIn", "NVIDIA GeForce MX350", "-",
            2, "SSD", 256, 0,
            "Hybrid", "Gray", 700.0);
    Laptop lap3 = new Laptop("OMEN 16-b1017ci", "HP", 16.1, 2022,
            "Windows", "Intel", "Core i7-12700H", 16,
            "BuiltIn", "NVIDIA GeForce RTX 3070", "-",
            8, "SSD", 512, 0,
            "Hybrid", "Black", 1700.5);
    Laptop lap4 = new Laptop("MacBook Air 13 2022", "Apple", 13.6, 2022,
            "macOS", "Apple", "Apple M2", 8,
            "BuiltIn", "Apple graphics 8-core", "-",
            0, "HDD", 256, 0,
            "Office", "Silver", 1300.7);
    public List<Laptop> allLaptops = new ArrayList<>(Arrays.asList(lap1, lap2, lap3, lap4));

    /**
     * Предлагает пользователю список для поиска с выбором числового значения (меню поисковика)
     *
     * @param mapList лист для выбора
     * @return выбор пользователя с типом int
     */
    public static int findChoice(Map<Integer, String> mapList) {
        int choice = -1;

        printMap(mapList);

        Scanner sc = new Scanner(System.in);
        System.out.print("Введите цифру: ");
        while (choice < 1 || choice > mapList.size()) {
            if (sc.hasNextInt()) choice = sc.nextInt();
            if (!(choice > 0 && choice < mapList.size() + 1)) {
                System.out.println("Не корректный ввод!");
                System.out.print("Введите цифру: ");
                sc.nextLine();
            }
        }
        return choice;
    }

    /**
     * Работа с множеством объектов
     *
     * @param num выбор поользователя в меню
     */
    public void filterList(Integer num) {
        int count = 1;
        int choice;
        Map<Integer, String> findList = new HashMap<>();
        switch (num) {
            case (1):
                for (Laptop el : allLaptops) {
                    if (!findList.values().contains(el.getManufacturer())) {
                        findList.put(count, el.getManufacturer());
                        count++;
                    }
                }
                choice = findChoice(findList);
                for (Laptop el : allLaptops) {
                    if (el.getManufacturer().equals(findList.get(choice))) {
                        System.out.println(el);
                    }
                }
                break;
            case (2):
                for (Laptop el : allLaptops) {
                    if (!findList.values().contains(el.getScreenDiagonal().toString())) {
                        findList.put(count, el.getScreenDiagonal().toString());
                        count++;
                    }
                }
                choice = findChoice(findList);
                for (Laptop el : allLaptops) {
                    if (el.getScreenDiagonal().toString().equals(findList.get(choice))) {
                        System.out.println(el);
                    }
                }
                break;
            case (3):
                for (Laptop el : allLaptops) {
                    if (!findList.values().contains(el.getProcessorManufacturer())) {
                        findList.put(count, el.getProcessorManufacturer());
                        count++;
                    }
                }
                choice = findChoice(findList);
                for (Laptop el : allLaptops) {
                    if (el.getProcessorManufacturer().equals(findList.get(choice))) {
                        System.out.println(el);
                    }
                }
                break;
            case (4):
                for (Laptop el : allLaptops) {
                    if (!findList.values().contains(el.getTypeOfGraphicsAccelerator())) {
                        findList.put(count, el.getTypeOfGraphicsAccelerator());
                        count++;
                    }
                }
                choice = findChoice(findList);
                for (Laptop el : allLaptops) {
                    if (el.getTypeOfGraphicsAccelerator().equals(findList.get(choice))) {
                        System.out.println(el);
                    }
                }
                break;
            case (5):
                for (Laptop el : allLaptops) {
                    if (!findList.values().contains(el.getStorageType())) {
                        findList.put(count, el.getStorageType());
                        count++;
                    }
                }
                choice = findChoice(findList);
                for (Laptop el : allLaptops) {
                    if (el.getStorageType().equals(findList.get(choice))) {
                        System.out.println(el);
                    }
                }
                break;
            case (6):
                System.out.println("Будет показан ноутбук с минимально близкой ценой!");
                double sum = 0;
                Scanner sc = new Scanner(System.in);
                System.out.print("Введите стоимость: ");
                while (sum <= 0) {
                    if (sc.hasNextInt()) sum = sc.nextInt();
                    if (sum <= 0) {
                        System.out.println("Не корректный ввод!");
                        System.out.print("Введите стоимость: ");
                        sc.nextLine();
                    }
                }
                NavigableSet<Double> priceSet = new TreeSet<>();
                for (Laptop el : allLaptops) {
                    priceSet.add(el.getPrice());
                }
                Double find = priceSet.floor(Double.valueOf(sum));
                if (find == null) find = priceSet.ceiling(Double.valueOf(sum));

                for (Laptop el : allLaptops) {
                    if (el.getPrice().compareTo(find) == 0) {
                        System.out.println(el);
                    }
                }
                break;
        }
    }

    /**
     * Печать Map в консоль
     *
     * @param map
     */
    public static void printMap(Map<Integer, String> map) {
        for (Map.Entry<Integer, String> item : map.entrySet()) {
            System.out.printf("%d - %s;%n", item.getKey(), item.getValue());
        }
    }
}
