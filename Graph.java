package ru.geekbrains.MyPractice;

public interface Graph {

    public void addVertex(String  label);

    public boolean addEdge(String fromLabel, String toLabel);

    public boolean remove(String label);

    public Vertex find(String  label);

    int indexOf(String label);

    boolean isEmpty();

    int getSize();

    void display();

    //обход в глубину
    void dfs(String startVertexLabel);

    // обход в ширину
    void bfs(String startVertexLabel);

    // метод для нахождения кротчайшего пути
    void minDistance (String startVertexLabel, String finishVertexLabel);
}
