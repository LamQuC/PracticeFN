package practice_Mid.oop.lab5.pointlineextend;


public class Point {
    // Private variables
    private int x; // x coordinate
    private int y; // y coordinate

    // Constructor
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }


    // Public methods
    public String toString() {
        return "Point: (" + x + ", " + y + ")";
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


