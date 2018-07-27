package ru.geekbrains.MyPractice;

import java.util.ArrayList;
import java.util.Scanner;

public class RecursionMain {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

     //1. Задача по возведению в степень.

        // Вынесем реализацию в оддельный класс. Дадим возможность консольного ввода.

        int value, degree;
        System.out.println("Введите число: ");
        value = sc.nextInt();
        System.out.println("Укажите степень: ");
        degree = sc.nextInt();
        Exponent exponent = new Exponent();
        System.out.println( value + "^" + degree + " = "+ exponent.Exponent(value, degree));


        // 2. Задача с рюкзаком.

        Item book = new Item(1,600, "Книга");
        Item binoculars = new Item(2,5000, "Бинокль");
        Item kit = new Item(4,1500, "Аптечка");
        Item laptop = new Item(2,40000, "Ноутбук");
        Item pot = new Item(1,500, "Котелок");

        Items items = new Items(); //создаем набор предметов

        items.Items(book);
        items.Items(binoculars);
        items.Items(kit);
        items.Items(laptop);
        items.Items(pot);

        Backpack backpack = new Backpack(8); // создаем рюкзак и указываем максимальную массу
        backpack.TestingKits(items.items);
        backpack.displayBestBackpack();

    }

}
