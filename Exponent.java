package ru.geekbrains.MyPractice;

public class Exponent {

    double rez; // создадаим переменную для хранения результата.

    public double Exponent(int value, int degree) {

        /* обработаем варианты когда степень равна 0, либо отрицательная. Для удобства реализацию вычисления
         вынесем в отдельный метод culculation () */

        if (degree == 0) {
           return  rez = value;
        }

        if (degree < 0) {
           return rez = 1 / culculation(value, -degree);
        }
           return rez = culculation(value, degree);
     }

    double culculation (int value, int degree) {
        if (degree == 1) {
            return rez = value;
        }
        else {
            rez = value*Exponent(value, --degree);
        }
        return rez;
    }

 }




