import java.util.Arrays;

class Array<E> {
    public Object[] arr;

    public Array() {
    }

    public Array(int capacity) {
        arr = new Object[capacity];

    }

    E get(int i) {
        return (E) arr[i];
    }

    public void set(int i, E e) {
        arr[i] = e;
    }

    public String toString() {
        return Arrays.toString(arr);
    }
}

public class DynamicArray<T> {
    public int length = 0;
    public Array<T> arr;
    public int capacity;

    public DynamicArray(int size) {
        arr = new Array<>(size);
        this.capacity = size;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void insert(T value) {
        if (length == capacity) {
            Array<T> newarr = new Array<>(this.capacity * 2);
            for (int i = 0; i < length; i++) {
                newarr.set(i, arr.get(i));
            }
            newarr.set(length++, value);
            arr = newarr;
            this.capacity = this.capacity * 2;
        } else {
            arr.set(length++, value);
        }
    }

    public void insert(int i, T value) {
        if (i < capacity) {
            arr.set(i, value);
            ++length;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public void delete(int i) {
        if (i >= capacity) {
            throw new IndexOutOfBoundsException();
        } else {
            for (int j = i; j < length - 1; j++) {
                arr.set(j, arr.get(j + 1));
            }
            --length;
        }
    }

    public void show() {
        for (int i = 0; i < length; i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
    }

}