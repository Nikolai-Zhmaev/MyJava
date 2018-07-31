package ru.geekbrains.MyPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

     // создадим список названий наших двадцити деревьев (не будем сильно мудрить с названиями)
        List <String> trees = new ArrayList<String>();
        trees.add("FirstTree");
        trees.add("SecondTree");
        trees.add("ThirdTree");
        trees.add("FourthTree");
        trees.add("FifthTree");
        trees.add("SixthTree");
        trees.add("SeventhTree");
        trees.add("EighthTree");
        trees.add("NinthTree");
        trees.add("TenthTree");
        trees.add("EleventhTree");
        trees.add("TwelfthTree");
        trees.add("ThirteenthTree");
        trees.add("FourteenthTree");
        trees.add("FifteenthTree");
        trees.add("SixteenthTree");
        trees.add("SeventeenthTree");
        trees.add("EighteenthTree");
        trees.add("NineteenthTree");
        trees.add("TwentiethTree");

        // в цикле создадим 20 деревьев c нашими именами

        for (String name: trees) {
            creationTree(name);
            System.out.println("--------------------------------------------------------------");
        }
    }

    private static void creationTree(String nameTree) { // метод для создания дерева и заполнения его случайным образом
        Tree tree = new TreeImpl();
        int counter = 1; // создадим счетчик для заполнения дерева 15 элементами
        while ( counter!=15 ) {
            addNode(tree, generateID(), nameTree);
            tree.travers(Tree.TraversMode.PRE_ORDER);
            counter++;
        }
    }

    private static int generateID() {  // создадим метод для генерации случайных чисел в диапазоне от -100 до 100
        Random random = new Random();
        int min = -100;
        int max = 100;
        int id = min + random.nextInt(max - min - 1);
        return id;
     }

    private static void addNode(Tree tree, int id, String name) {

        Person person = new Person(name, id, id );
        tree.insert(person);
    }
}