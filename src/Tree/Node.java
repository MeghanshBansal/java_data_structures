package Tree;

public class Node<T extends Comparable<T>> {
    public T value;
    Node<T> left = null;
    Node<T> right = null;
    int count = 0;

    public Node() {
    }

    public Node(T value) {
        this.value = value;
    }

    public int testCompare(T anotherValue) {
        return 1 - value.compareTo(anotherValue);
    }

}
