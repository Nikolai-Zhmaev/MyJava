package ru.geekbrains.MyPractice;

import java.util.ArrayList;

public class Backpack {

   ArrayList <Item> bestBackpack = new ArrayList <Item> ();
   private int maxMass, maxPrice; // поля для хранения максимальной массы предметов и их стоимости.

    public Backpack(int maxMass) {
        this.maxMass = maxMass;
    }

    // напишем метод для подсчета общей массы предметов

    public int calcSumMass (ArrayList <Item> items) {
        int sumMass = 0;
        for (Item i: items) {
            sumMass += i.weight;
        }
        return sumMass;
    }

    // напишем метод для подсчета общей стоимости предметов
    public int calcSumPrice (ArrayList <Item> items) {
        int sumPrice = 0;
        for (Item i : items) {
            sumPrice += i.price;
        }
        return sumPrice;
    }

    // метод для сравнения наборов между собой, с целью определения лучшего.
    private void comparison (ArrayList <Item> items){

        if (bestBackpack == null) {
            if (calcSumMass(items) <= maxMass){
                bestBackpack = items;
                maxPrice = calcSumPrice(items);
            }
        }
        else {
            if (calcSumMass(items)<=maxMass && calcSumPrice(items)>maxPrice) {
                bestBackpack=items;
                maxPrice = calcSumPrice(items);
            }
        }
    }

    public void TestingKits (ArrayList <Item> items){
        if (!items.isEmpty()) {
            comparison(items);
        }
        for (Item i: items) {
            ArrayList<Item> newSet = new ArrayList<Item>(items);
            newSet.remove(i);
            TestingKits(newSet);
        }
    }

    public void displayBestBackpack (){

        for (Item i: bestBackpack) {
            System.out.println(i.name);
        }
    }

    }






