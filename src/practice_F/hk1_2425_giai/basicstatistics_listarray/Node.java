package practice_F.hk1_2425_giai.basicstatistics_listarray;

public class Node {
    public Number payload;
    public Node next;

    public Node(Number payload) {
        this.payload = payload;
        this.next = null;
    }

    public Node(Number payload, Node next) {
        this.payload = payload;
        this.next = next;
    }
}
