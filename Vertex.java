package ru.geekbrains.MyPractice;

public class Vertex {
    private final String label;
    private boolean wasVisited = false;
    private Vertex preVertex; // поле для хранения предыдущей вершины



    public Vertex(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return label;
    }

    public boolean isWasVisited() {
        return wasVisited;
    }

    public void setWasVisited(boolean wasVisited) {
        this.wasVisited = wasVisited;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vertex vertex = (Vertex) o;

        return label != null ? label.equals(vertex.label) : vertex.label == null;
    }

    public Vertex getPreVertex() {
        return preVertex;
    }

    public void setPreVertex(Vertex preVertex) {
        this.preVertex = preVertex;
    }
}
