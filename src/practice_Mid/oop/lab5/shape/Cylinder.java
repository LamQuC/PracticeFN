package practice_Mid.oop.lab5.shape;

public class Cylinder extends Circle{
    private double height = 1.0;
    public Cylinder(double radius) {
        super(radius);
    }
    public Cylinder(){
    }
    public Cylinder(double radius, String color) {
        super(radius, color);
    }
    public Cylinder(double radius,double height){
        super(radius);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public double getVolume(){
        return Math.PI * getArea() * height;
    }
}
