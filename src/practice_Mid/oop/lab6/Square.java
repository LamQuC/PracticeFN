package practice_Mid.oop.lab6;

public class Square extends Rectangle{
    public Square(){}
    public Square(double side){
        super(side,side);
    }
    public Square (double side , String color, boolean filled){
        super(side,side,color,filled);
    }
    public double getSide(){
        return getLength();
    }
    public void setSide(){
        super.setLength(getSide());
        super.setWidth(getSide());

    }

}
