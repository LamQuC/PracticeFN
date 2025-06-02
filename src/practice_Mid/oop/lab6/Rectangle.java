package practice_Mid.oop.lab6;

public class Rectangle extends Shape{
    protected double width = 1.0;
    protected double length = 1.0;
    public Rectangle (){}
    public Rectangle(double width,double length){this.length = length;
    this.width = width;}
    public Rectangle(double width,double lenght,String color,boolean filled){
        super(color,filled);
        this.length = lenght;
        this.width = width;
    }
    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + length);
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }
    public String toString(){
        return "Rectangle[" + super.toString() +",width = " + width +",length=" + length +"]";
    }

    public void setLength(double length) {
        this.length = length;
    }
}
