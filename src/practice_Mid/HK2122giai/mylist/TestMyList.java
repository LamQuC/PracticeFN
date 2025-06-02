package practice_Mid.HK2122giai.mylist;

public class TestMyList {
    public static void main(String[] args) {
        MyList arrayList = new MyArrayList();
        MyList linkedList = new MyLinkedList();

        for (int i = 1; i <= 10; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        System.out.println("ArrayList: " + arrayList);
        System.out.println("LinkedList: " + linkedList);

        arrayList.add(11);
        linkedList.add(11);

        System.out.println("After adding 11:");
        System.out.println("ArrayList: " + arrayList);
        System.out.println("LinkedList: " + linkedList);

        arrayList.remove(5);
        linkedList.remove(5);

        System.out.println("After removing index 5:");
        System.out.println("ArrayList: " + arrayList);
        System.out.println("LinkedList: " + linkedList);
    }
}
