package ru.geekbrains.MyPractice;

public class MainGraph {

    public static void main(String[] args) {

            testBfs();
        }

        private static void testBfs() {

        // Создадаим наш граф с городами и определим связи.

            Graph graph = new GraphImpl(10);
            graph.addVertex("Москва");
            graph.addVertex("Тула");
            graph.addVertex("Рязань");
            graph.addVertex("Калуга");
            graph.addVertex("Липецк");
            graph.addVertex("Тамбов");
            graph.addVertex("Орел");
            graph.addVertex("Саратов");
            graph.addVertex("Курск");
            graph.addVertex("Воронеж");


            graph.addEdge("Москва", "Тула");
            graph.addEdge("Москва", "Рязань");
            graph.addEdge("Москва", "Калуга");
            graph.addEdge("Тула", "Липецк");
            graph.addEdge("Рязань", "Тамбов");
            graph.addEdge("Калуга", "Орел");
            graph.addEdge("Липецк", "Воронеж");
            graph.addEdge("Тамбов", "Саратов");
            graph.addEdge("Орел", "Курск");
            graph.addEdge("Саратов", "Воронеж");
            graph.addEdge("Курск", "Воронеж");


            //A B C D E F G H
//            graph.bfs("Москва");
            graph.minDistance("Москва", "Воронеж");
        }
    }


