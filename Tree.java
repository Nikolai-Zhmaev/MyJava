package ru.geekbrains.MyPractice;

public interface Tree {

    enum TraversMode {
        PRE_ORDER, // прямой обход
        POST_ORDER, // обратный обход
        IN_ORDER, // симметричный
    }

    void insert (Person person); // метод для добавления элемента.

    boolean remove (int key); // метод для удаления элемента.

    Person find (int key); // метод для нахождения элемента.

    int getSize (); // метод для определения размера дерева.

    boolean isEmpty (); // метод для проверки дерева на пустоту.

    Person getRoot (); // метод для нахождения корня дерева.

    void travers (TraversMode traversMode); // метод обхода
}
