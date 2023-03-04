package org.example.cw4;

/**
 * 4) Напишите интерфейс Converter для конвертации из градусов по Цельсию в
 * Кельвины, Фаренгейты. У классов наследников необходимо переопределить метод интерфейса,
 * для валидного перевода величин. Метод для конвертации назовите "convertValue".
 */
public class Main {
    public static void main(String[] args) {
        double temp = 37.0;
        System.out.println("Фаренгейты = " + new Fahrenheit().convertValue(temp));
        System.out.println("Кельвины = " + new Kelvin().convertValue(temp));
        System.out.println("Рейнюра = " + new Reunyura().convertValue(temp));
        System.out.println("Цельсии = " + new Celsius().convertValue(temp));
    }
}
