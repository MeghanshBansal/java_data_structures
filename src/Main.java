public class Main {
    public static void main(String[] args) {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);
        list.insert(60);
        list.insert(70);
        list.show();
        System.out.println();
        System.out.println(list.length());
        System.out.println();
        list.insert(80, 3);
        list.show();
        System.out.println();
        System.out.println(list.length());
        list.delete(30);
        list.show();
        System.out.println(list.length());
        list.delete();
        System.out.println();
        list.show();
        System.out.println(list.length());
    }
}
