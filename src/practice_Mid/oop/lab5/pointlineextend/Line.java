package practice_Mid.oop.lab5.pointlineextend;

public class Line extends Point {
    // A line composes of two points (instance variables)
     // Beginning point
    Point end;   // Ending point

    // Constructors
    public Line(Point begin,Point end) {
        super(begin.getX(), begin.getY());
        this.end = end;

    }

    public Line(int beginX, int beginY, int endX, int endY) {
        super(beginX,beginY);
        end = new Point(endX, endY);
    }

    // Public methods
    public Point getBegin() { return new Point(getX(),getY()); }
    public Point getEnd() { return this.end; }
    public void setBegin(Point begin) { super.setX(begin.getX());
        super.setY(begin.getY());}

    public void setEnd(Point end) { this.end = end; }

    public int getBeginX() { return super.getX(); }
    public int getBeginY() { return super.getY(); }
    public int getEndX() { return end.getX(); }
    public int getEndY() { return end.getY(); }

    public void setBeginX(int x) {super.setX(x); }
    public void setBeginY(int y) { super.setY(y); }
    public void setBeginXY(int x, int y) { super.setXY(x,y); }

    public void setEndX(int x) { end.setX(x); }
    public void setEndY(int y) { end.setY(y); }
    public void setEndXY(int x, int y) { end.setXY(x,y); }

    public int getLength() {
        int xDiff = this.getBeginX() - this.getEndX();
        int yDiff = this.getBeginY() - this.getEndY();
        return (int) Math.sqrt(xDiff * xDiff + yDiff * yDiff); } // Length of the line
    // Math.sqrt(xDiff * xDiff + yDiff * yDiff)

    public double getGradient() {
        int xDiff = this.getBeginX() - this.getEndX();
        int yDiff = this.getBeginY() - this.getEndY();
        return Math.atan2(yDiff,xDiff);} // Gradient in radians
    // Math.atan2(yDiff, xDiff)
}

