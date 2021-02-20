public class CircularQueueArray {
    private final int[] arr;
    public int size;
    public int front;
    public int rear;

    public CircularQueueArray(int size) {
        this.arr = new int[size];
        this.size = size;
        this.front = this.rear = -1;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return (front == 0 && rear == size - 1) || (front == rear + 1);
    }

    public void insert(int value) {
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
        arr[rear] = value;
    }

    public int pop() {
        int temp = arr[front];
        if (rear == front) {
            rear = front = 0;
        } else if (front == size - 1) {
            front = 0;
        } else {
            front++;
        }
        return temp;
    }

    public int peek() {
        return arr[front];
    }

    public void roll() {
        int temp = arr[front];
        for (int i = front; i < rear; i++) {
            arr[i] = arr[i + 1];
        }
        arr[rear] = temp;
    }

    public void show() {
        for (int i = front; i < rear + 1; i++) {
            System.out.println(arr[i]);
        }
    }
}