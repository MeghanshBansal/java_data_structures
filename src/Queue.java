import java.util.EmptyStackException;

public class Queue<T> {
    private Node<T> front;
    private Node<T> back;

    public Queue() {
    }

    public Queue(T value) {
        this.front = new Node<T>();
        front.value = value;
        this.back = front;
    }

    public boolean isEmpty() {
        return front == back;
    }

    public void push(T value) {
        if (this.front == null) {
            Node<T> temp = new Node<>();
            temp.value = value;
            front = temp;
            back = front;
        } else {
            Node<T> current = new Node<>();
            current.value = value;
            Node<T> p = back;
            p.next = current;
            back = current;
        }
    }

    public int length() {
        Node<T> current = front;
        int length = 0;
        while (current != null) {
            ++length;
            current = current.next;
        }
        return length;
    }

    public T pop() throws Exception {
        if (front == null) {
            throw new Exception("Queue is empty");
        } else if (front == back) {
            T value = front.value;
            front = null;
            back = null;
            return value;
        } else {
            T value = front.value;
            front = front.next;
            return value;
        }
    }

    public T peek() {
        if (front == null) {
            throw new EmptyStackException();
        } else {
            return front.value;
        }
    }

    public void show() {
        Node<T> current = this.front;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }
}
