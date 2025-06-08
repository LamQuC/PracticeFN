package practice_F.hk2_2324_giai.de1.statistics;

public class MyNode {
    public double data;
    public MyNode next;
    public MyNode previous;

    public MyNode(double data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }

    public MyNode(double data, MyNode next, MyNode previous) {
        this.data = data;
        this.next = next;
        this.previous = previous;
    }
}