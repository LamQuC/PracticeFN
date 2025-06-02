package practice_Mid.khdl.vector.vector;

public class TestVectors {
    public static void main(String[] args) {
        /* TODO */
        testArrayVector();
        System.out.println();
        testListVector();
    }

    public static void testArrayVector() {
        ArrayVector vector = new ArrayVector();
        vector.append(1.1);
        vector.append(2.2);
        vector.append(3.3);
        ArrayVector vector2 = new ArrayVector();
        vector2.append(1.1);
        vector2.append(3.2);
        vector2.append(4.3);
        System.out.println(vector.magnitude());
        System.out.println(vector.distanceTo(vector2));
        System.out.println(vector.minus(vector2));
        System.out.println(vector.plus(vector2));
        System.out.println(vector.scale(2));
        System.out.println(vector.dot(vector2));
    }

    public static void testListVector() {
        ListVector vector = new ListVector();
        vector.append(1.1);
        vector.append(2.2);
        vector.append(3.3);
        ListVector vector2 = new ListVector();
        vector2.append(1.1);
        vector2.append(3.2);
        vector2.append(4.3);
        System.out.println(vector.magnitude());
        System.out.println(vector.distanceTo(vector2));
        System.out.println(vector.minus(vector2));
        System.out.println(vector.plus(vector2));
        System.out.println(vector.scale(2));
        System.out.println(vector.dot(vector2));
    }
}
