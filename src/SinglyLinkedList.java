import java.util.HashMap;

public class SinglyLinkedList<T> {
    Node<T> head;

    public SinglyLinkedList() {
        head = null;
    }

    public SinglyLinkedList(T value) {
        this.head = new Node<>();
        this.head.value = value;
    }

    public boolean isEmpty() {
        return this.head == null;
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
        if (head == null) {
            System.out.println("Empty list");
        } else if (head.next == null) {
            head = null;
        } else {
            Node<T> current = this.head;
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
        }
    }

    public void delete(T value) {
        boolean found = false;
        if (this.head.value == value) {
            this.head = this.head.next;
            found = true;
        } else {
            Node<T> current = head;
            while (current.next != null && current.next.value != value) {
                current = current.next;
            }
            assert current.next != null;
            current.next = current.next.next;
            found = true;
        }
        if (!found) {
            System.out.println("Element not exit");
        }
    }

    public void deleteList(){
        this.head = null;
    }

    public int checkloop(){
        int index = 0;
        Node<T> current = this.head;
        HashMap<Node<T>, Boolean> map = new HashMap<>();
        for (int i = 0; i < length(); i++) {
            if (map.get(current)!=true) {
                map.put(current, true);
                current = current.next;
                index++;
            }else{
               return index;
            }
        }
        return -1;
    }

//    public int looplength(){
//        if (checkloop()==-1){
//            return 0;
//        }else{
//            NOde<T> current = head;
//        }
//    }

    public void show() {
        Node<T> current = head;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    public T get() throws Exception {
        if (head == null) {
            throw new Exception("List is empty");
        } else {
            Node<T> current = head;
            while (current != null) {
                current = current.next;
            }
            return current.value;
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

    public int getIndex(T value) {
        Node<T> current = head;
        for (int i = 0; i < length(); i++) {
            if (current.value == value) {
                return i;
            } else {
                current = current.next;
            }
        }
        return -1;
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
}
