package practice_Mid.HK2223.d2hk2giai.myiterator;

public class TestMyList {
    public static void main(String[] args) {
        testMyArrayList();
        testMyLinkedList();
    }

    static void testMyArrayList() {
        MyList list = new MyArrayList();
        list.append("A"); list.append("B"); list.append("C");
        System.out.println("ArrayList: " + list);
        list.insert("X", 1);
        System.out.println("After insert: " + list);
        list.remove(2);
        System.out.println("After remove: " + list);
        System.out.println("Iterate:");
        MyIterator it = list.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println("\n");
    }

    static void testMyLinkedList() {
        MyList list = new MyLinkedList();
        list.append(1); list.append(2); list.append(3);
        System.out.println("LinkedList: " + list);
        list.insert(99, 2);
        System.out.println("After insert: " + list);
        list.remove(0);
        System.out.println("After remove: " + list);
        System.out.println("Iterate:");
        MyIterator it = list.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }
}
