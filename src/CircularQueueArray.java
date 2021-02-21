public class CircularQueueArray<T> {
    private final Array<T> arr;
    public int size;
    public int front;
    public int rear;

    public CircularQueueArray(int size) {
        this.arr = new Array<>(size);
        this.size = size;
        this.front = this.rear = -1;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return (front == 0 && rear == size - 1) || (front == rear + 1);
    }

    public void insert(T value) {
        if (isEmpty()) {
            rear++;
            front++;
        } else if (isFull()) {
            throw new ArrayStoreException();
        } else if (rear == size - 1 && front != 0) {
            rear = (rear + 1) % size;
        } else {
            rear++;
        }
        arr.set(rear, value);
    }

    public T pop() {
        T temp = arr.get(front);
        if (rear == front) {
            rear = front = 0;
        } else if (front == size - 1) {
            front = 0;
        } else {
            front++;
        }
        return temp;
    }

    public T peek() {
        return arr.get(front);
    }

    public void roll() {
        T temp = arr.get(front);
        for (int i = front; i < rear ; i++) {
            arr.set(i, arr.get(i+1));
        }
        arr.set(rear, temp);
    }

    public void show() {
        for (int i = front; i < rear + 1; i++) {
            System.out.println(arr.get(i));
        }
    }
}