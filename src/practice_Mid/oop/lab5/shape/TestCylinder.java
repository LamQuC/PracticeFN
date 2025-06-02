package practice_Mid.oop.lab5.shape;

public class TestCylinder { // Save this file as "TestCylinder.java"
    public static void main(String[] args) {
        // Declare and allocate a new instance of Cylinder with default values
        Cylinder cylinder1 = new Cylinder();
        System.out.println("Cylinder: "
                + "radius=" + cylinder1.getRadius()  // Get the radius
                + " height=" + cylinder1.getHeight() // Get the height
                + " base area=" + cylinder1.getArea() // Calculate base area
                + " volume=" + cylinder1.getVolume()); // Calculate volume

        // Declare and allocate a new instance of Cylinder with a specific height
        Cylinder cylinder2 = new Cylinder(10.0);
        System.out.println("Cylinder: "
                + "radius=" + cylinder2.getRadius()
                + " height=" + cylinder2.getHeight()
                + " base area=" + cylinder2.getArea()
                + " volume=" + cylinder2.getVolume());

        // Declare and allocate a new instance of Cylinder with a specific radius and height
        Cylinder cylinder3 = new Cylinder(2.0, 10.0);
        System.out.println("Cylinder: "
                + "radius=" + cylinder3.getRadius()
                + " height=" + cylinder3.getHeight()
                + " base area=" + cylinder3.getArea()
                + " volume=" + cylinder3.getVolume());
    }
}

