import java.util.EmptyStackException;

public class StackArray<T> {
    public final Array<T> arr;
    public int size;
    public int top;

    public StackArray(int size) {
        this.arr = new Array<>(size);
        this.size = size;
        this.top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public void insert(T value) {
        if (top == size - 1) {
            throw new ArrayStoreException();
        } else {
            arr.set(++top, value);
        }
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            T value = arr.get(top);
            top--;
            return value;
        }
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            return (arr.get(top));
        }
    }

    public void roll() {
        T temp = arr.get(0);
        for (int i = 0; i < top; i++) {
            arr.set(i, arr.get(i + 1));
        }
        arr.set(top, temp);
    }

    public void show() {
        for (int i = top; i >= 0; i--) {
            System.out.println(arr.get(i));
        }
    }
}

