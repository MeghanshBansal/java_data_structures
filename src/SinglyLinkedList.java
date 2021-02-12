public class SinglyLinkedList<T> {
    Node<T> head;

    public SinglyLinkedList() {
        head = null;
    }

    public SinglyLinkedList(T value) {
        this.head = new Node<>();
        this.head.value = value;
    }

    public void insert(T n) {
        if (this.head == null) {
            this.head = new Node<T>();
            this.head.value = n;
        } else {
            Node<T> current = head;
            Node<T> temp = new Node<>();
            temp.value = n;
            while (current.next != null) {
                current = current.next;
            }
            current.next = temp;
        }
    }

    public void insert(T value, int index) {
        if (index > length()) {
            System.out.println("invalid pos");
        } else {
            Node<T> current = head;
            Node<T> temp = new Node<>();
            temp.value = value;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            Node<T> p = current.next;
            current.next = temp;
            temp.next = p;
        }
    }

    public void insertAtBegining(T n) {
        Node<T> temp = new Node<>();
        temp.value = n;
        temp.next = head;
        head = temp;
    }


    public int length() {
        Node<T> current = head;
        int length = 0;
        while (current != null) {
            ++length;
            current = current.next;
        }
        return length;
    }

    public void delete() {
        Node<T> current = this.head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    public void delete(T value) {
        if (this.head.value == value) {
            this.head = this.head.next;
        } else {
            Node<T> current = head;
            while (current.next != null && current.next.value != value) {
                current = current.next;
            }
            assert current.next != null;
            current.next = current.next.next;
        }
    }

    public void show() {
        Node<T> current = head;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    public T get(int index) {
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    public void set(int index, T value) {
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.value = value;
    }

    public T getMiddle() {
        Node<T> current = head;
        Node<T> doublecurrent = head;
        while (doublecurrent.next!=null && doublecurrent.next.next != null) {
            current = current.next;
            doublecurrent = doublecurrent.next.next;
        }
        return current.value;
    }

}
