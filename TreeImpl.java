package ru.geekbrains.MyPractice;

public class TreeImpl implements Tree {

    private Node root; // корневой элемент дерева
    private int currentSize; // счетчик

    private class RemovedElementAndParent {
        Node remvedElement;
        Node parent;
    }

    @Override
    public void insert(Person person) {
        Node newNode = new Node(person); // создадим новый узел
        int key = newNode.getKey();
        Node parent = findParentForInsert(key);
        if (parent == null) {
            root = newNode; // если дерево пустое то в корень ставим наш элемент
        }
        else {
            if (parent.isLeft(key)) {
                parent.setLeftChild(newNode);
            }
            else {
                parent.setRightChild(newNode);
            }
        }
        currentSize++;
    }

    // выделим поиск родителя для вставки в отдельный метод

    private Node findParentForInsert(int key) {
        Node currentNod = root; // переменная для навигации
        Node parent = null; // переменная для сохранения родителя текущего узла.

        while (currentNod != null) {
            parent = currentNod;
            if (currentNod.isRight(key)) {
                currentNod = currentNod.getRightChild();
            }
            else {
                currentNod = currentNod.getLeftChild();
            }
        }
        return parent;
    }

    @Override
    public boolean remove(int key) {
        RemovedElementAndParent elementAndParent = findRemovedElementAndParent(key);
        if (elementAndParent.remvedElement == null) {
            return false; // элемент не найден, удалять нечего
        }

        Node removedNode = elementAndParent.remvedElement;
        Node parent = elementAndParent.parent;
        if (removedNode.isLeaf()) {
            removeLeafNode(removedNode, parent);
        }
        else if ( removedNode.hasOnlyOneChild() ) { // если имеет одного одного потомка
            removeNodeWithOnlyOneChild(removedNode, parent);
        }
        else {
            removeNodeWithBothChild(removedNode, parent);
        }
        currentSize--;
        return true;
    }

    private void removeNodeWithBothChild(Node removedNode, Node parent) {
        Node successor = getSuccessor(removedNode);
        if (removedNode == root){
            root = successor;
        }
        else if (parent.getLeftChild() == removedNode){
            parent.setLeftChild(successor);
        }
        else {
            parent.setRightChild(successor);
        }
        successor.setLeftChild(removedNode.getLeftChild());
        if (successor != removedNode.getRightChild()) {
            successor.setRightChild(removedNode.getRightChild());
        }
    }

    private void removeNodeWithOnlyOneChild(Node removedNode, Node parent) {
        Node removeChildNode = getSingleChildNode(removedNode);

        if (removedNode == root) {
            root = removeChildNode;
        }
        else if (parent.getLeftChild() == removedNode) {
            parent.setLeftChild(removeChildNode);
        }
        else {
            parent.setRightChild(removeChildNode);
        }
    }

    private Node getSingleChildNode(Node removedNode) {
        return removedNode.getLeftChild()!= null ? removedNode.getLeftChild(): removedNode.getRightChild();
    }

    private void removeLeafNode(Node removedNode, Node parent) {
        if (removedNode == root) {
            root = null;
        }
        else {
            parent.deleteChild(removedNode);
        }
    }

    private RemovedElementAndParent findRemovedElementAndParent(int key) {
        RemovedElementAndParent elementAndParent = new RemovedElementAndParent();
        elementAndParent.remvedElement = root;
        elementAndParent.parent = null;

        while (elementAndParent.remvedElement != null) {
            if (elementAndParent.remvedElement.getKey () == key) {
                break;
            }
            elementAndParent.parent = elementAndParent.remvedElement;
            if (elementAndParent.remvedElement.isRight(key)) {
                elementAndParent.remvedElement = elementAndParent.remvedElement.getRightChild();
            }
            else {
                elementAndParent.remvedElement = elementAndParent.remvedElement.getLeftChild();
            }
        }
        return elementAndParent;
    }

    private Node getSuccessor (Node node) {
        Node successorParent = null; // Родитель элемента под замену
        Node successor = node; // Под замену
        Node current = node.getRightChild(); // Для навигации

        while (current != null)  {
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }
        if (successor != node.getRightChild()) { // дочерние элементы successor не теряем, а отдаем родителю
            successorParent.setLeftChild(successor.getRightChild());
        }
          return successor;
    }

    @Override
    public Person find(int key) {
        Node currentNode = root;
        while (currentNode != null) {
            if (currentNode.getKey()==key) {
                return currentNode.getPerson(); // если ключ совпал то выводим.
            }
            if (currentNode.isRight(key)) { // если ключ не совпал смотрим значение ключа и идем в правую или левую ветвь.
                currentNode = currentNode.getRightChild();
            }
            else {
                currentNode = currentNode.getLeftChild();
            }
        }
        return null;
    }

    @Override
    public int getSize() {
        return currentSize;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public Person getRoot() {
        return root.getPerson();
    }

    @Override
    public void travers(TraversMode traversMode) {
        switch (traversMode) {
            case PRE_ORDER: preOrder(root); break;
            case POST_ORDER: preOrder(root); break;
            case IN_ORDER: inOrder(root); break;
            default: throw new  IllegalArgumentException("Unknown travers mode: " + traversMode);
        }
    }

    private void preOrder (Node node) {
        if (node != null) {
            node.display();
            preOrder(node.getLeftChild());
            preOrder(node.getRightChild());
        }
    }

    private void postOrder (Node node) {
        if (node != null) {
            preOrder(node.getLeftChild());
            preOrder(node.getRightChild());
            node.display();
        }
    }

    private void inOrder (Node node) {
        if (node != null) {
            preOrder(node.getLeftChild());
            node.display();
            preOrder(node.getRightChild());
        }
    }
}
