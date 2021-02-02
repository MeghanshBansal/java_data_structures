public class CircularLinkedList<T> {
    Node<T> head;

    public CircularLinkedList() {
    }

    public CircularLinkedList(T n) {
        this.head = new Node<>();
        this.head.value = n;
        this.head.next = this.head;
    }

    public void insert(T n) {
        if (this.head == null) {
            this.head = new Node<>();
            this.head.value = n;
            this.head.next = this.head;
        } else {
            Node<T> current = this.head;
            Node<T> temp = new Node<>();
            temp.value = n;
            while (current.next != head) {
                current = current.next;
            }
            current.next = temp;
            temp.next = this.head;
        }
    }

    public void insert(T n, int index) {
        Node<T> current = head;
        Node<T> temp = new Node<>();
        temp.value = n;
        for (int i = 1; i < index; i++) {
            current = current.next;
        }
        Node<T> p = current.next;
        current.next = temp;
        temp.next = p;
    }

    public int length() {
        Node<T> current = this.head;
        int length = 1;
        while (current.next != this.head) {
            ++length;
            current = current.next;
        }
        return length;
    }

    public void delete() {
        Node<T> current = this.head;
        while (current.next.next != this.head) {
            current = current.next;
        }
        current.next = this.head;
    }

    public void delete(T value) {
        if (this.head.value == value) {
            this.head = this.head.next;
        } else {
            Node<T> current = head;
            while (current.next != head && current.next.value != value) {
                current = current.next;
            }
            current.next = current.next.next;
        }
    }

    public void show() {
        Node<T> current = head;
        do {
            System.out.println(current.value);
            current = current.next;
        } while (current != head);
    }
}
