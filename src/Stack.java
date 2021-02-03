public class Stack<T> {
    Node<T> top;

    public Stack() {
    }

    public Stack(T value) {
        this.top = new Node<>();
        this.top.value = value;
    }

    public int length(){
        Node<T> current = this.top;
        int length = 0;
        while(current!=null){
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
        Node<T> current = this.top;
        top = top.next;
        return current.value;
    }

    public void show(){
        Node<T> current = this.top;
        while(current!=null){
            System.out.println(current.value);
            current = current.next;
        }
    }
}
