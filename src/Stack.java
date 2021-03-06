import java.util.EmptyStackException;

public class Stack<T> {
    private Node<T> top;

    public Stack() {
    }

    public Stack(T value) {
        this.top = new Node<>();
        this.top.value = value;
    }

    public boolean isEmpty() {
        return this.top == null;
    }

    public int length() {
        Node<T> current = this.top;
        int length = 0;
        while (current != null) {
            ++length;
            current = current.next;
        }
        return length;
    }

    public void push(T n) {
        if (top == null) {
            this.top = new Node<>();
            this.top.value = n;
        } else {
            Node<T> current = top;
            Node<T> temp = new Node<>();
            temp.value = n;
            temp.next = current;
            top = temp;
        }
    }

    public T pop() {
        if (top == null) {
            throw new EmptyStackException();
        } else {
            Node<T> current = this.top;
            top = top.next;
            return current.value;
        }
    }

    public T peek() {
        if (top == null) {
            throw new EmptyStackException();
        } else {
            Node<T> current = this.top;
            return current.value;
        }
    }

    public void swap() {
        if (top != null && top.next != null) {
            Node<T> current = this.top;
            Node<T> temp = this.top.next;
            Node<T> p = current;
            current.next = temp.next;
            temp.next = p;
            top = temp;
        } else {
            System.out.println("Not enought elements");
        }
    }

    public void roll() {
        Node<T> current = this.top;
        while (current.next.next != null) {
            current = current.next;
        }
        Node<T> p = top;
        current.next.next = p;
        top = current.next;
        current.next = null;
    }

    public void show() {
        Node<T> current = this.top;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }
}
