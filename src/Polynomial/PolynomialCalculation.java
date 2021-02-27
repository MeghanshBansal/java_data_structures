package Polynomial;

class Node<T> {
    T coef;
    int power;
    Node<T> next;
}

public class PolynomialCalculation<T extends Number> {
    Node<T> head;

    public PolynomialCalculation() {

    }

    public PolynomialCalculation(T coef, int power) {
        this.head = new Node<>();
        this.head.coef = coef;
        this.head.power = power;
        this.head.next = null;
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

    public void insert(T coef, int power) {
        if (this.head == null) {
            this.head = new Node<T>();
            this.head.coef = coef;
            this.head.power = power;
            this.head.next = null;
        } else {
            Node<T> current = head;
            Node<T> temp = new Node<>();
            temp.coef = coef;
            temp.power = power;
            temp.next = null;
            while (current.next != null) {
                current = current.next;
            }
            current.next = temp;
        }
    }
    public static<T extends Number> T add(T x, T y){

        if (x == null || y == null) {
            return null;
        }
        return (T) new Double(x.doubleValue() + y.doubleValue());

    }

    public static<T extends Number> T sub(T x, T y){

        if (x == null || y == null) {
            return null;
        }
        return (T) new Double(x.doubleValue() - y.doubleValue());

    }

    public boolean equals(Node<T>obj1, Node<T> obj2) {
        return obj1.power==obj2.power;
    }

    public PolynomialCalculation<T> polyAdd(PolynomialCalculation<T> obj) {
        PolynomialCalculation<T> res = new PolynomialCalculation<>();
        Node<T> p1 = this.head;
        Node<T> p2 = obj.head;
        while (p1 != null && p2 != null) {
            if (p1.power > p2.power) {
                res.insert(p1.coef, p1.power);
                p1=p1.next;
            } else if (p1.power < p2.power) {
                res.insert(p2.coef, p2.power);
                p2=p2.next;
            } else {
                res.insert(add(p1.coef, p2.coef), p1.power);
                p1=p1.next;
                p2=p2.next;
            }
        }
        return res;
    }

    public PolynomialCalculation<T> polySub(PolynomialCalculation<T> obj) {
        PolynomialCalculation<T> res = new PolynomialCalculation<>();
        Node<T> p1 = this.head;
        Node<T> p2 = obj.head;
        while (p1 != null && p2 != null) {
            if (p1.power > p2.power) {
                res.insert(p1.coef, p1.power);
                p1=p1.next;
            } else if (p1.power < p2.power) {
                res.insert(sub((T) new Double(0), p2.coef), p2.power);
                p2=p2.next;
            } else {
                res.insert(sub(p1.coef, p2.coef), p1.power);
                p1=p1.next;
                p2=p2.next;
            }
        }
        return res;
    }

    public void show() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.coef + "|" + current.power + " ");
            current = current.next;
        }
    }

}
