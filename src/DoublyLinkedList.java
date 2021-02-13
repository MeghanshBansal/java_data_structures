public class DoublyLinkedList<T> {
    private Node<T> head;

    public DoublyLinkedList() {
    }

    public DoublyLinkedList(T value) {
        this.head = new Node<T>();
        this.head.value = value;
    }

    public void insert(T value) {
        if (this.head == null) {
            this.head = new Node<T>();
            this.head.value = value;
        } else {
            Node<T> current = head;
            Node<T> temp = new Node<T>();
            temp.value = value;
            while (current.next != null) {
                current = current.next;
            }
            current.next = temp;
            temp.prev = current;
        }
    }

    public void insert(int index, T value) {
        if (index >= this.length()) {
            System.out.println("Invalid index");
        } else {
            Node<T> current = head;
            Node<T> temp = new Node<T>();
            temp.value = value;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            Node<T> p = current;
            temp.next = current.next;
            p.next = temp;
            temp.prev = current;
        }
    }

    public void delete() {
        if (head == null) {
            System.out.println("List is empty");
        } else if (head.next == null) {
            head = null;
        } else {
            Node<T> current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
        }
    }

    public void delete(int index) {
        if (index >= length()) {
            System.out.println("Index error");
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            Node<T> p = current.next;
            current.next = current.next.next;
            current.next.prev = p.prev;
        }
    }

    public int length() {
        int length = 0;
        Node<T> current = head;
        while (current != null) {
            current = current.next;
            ++length;
        }
        return length;
    }

    public T get() throws Exception {
        if (head == null) {
            throw new Exception("Queue is empty");
        } else if (head.next == null) {
            T value = head.value;
            head = null;
            return value;
        } else {
            Node<T> current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            T value = current.next.value;
            current.next.prev = null;
            current.next = null;
            return value;
        }
    }

    public T get(int index) {
        if (index >= length()) {
            throw new IndexOutOfBoundsException();
        } else {
            Node<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.value;
        }
    }

    public T getMiddle() {
        Node<T> current = head;
        Node<T> doublecurrent = head;
        while (doublecurrent.next != null && doublecurrent.next.next != null) {
            current = current.next;
            doublecurrent = doublecurrent.next.next;
        }
        return current.value;
    }

    public void show() {
        Node<T> current = head;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }
}