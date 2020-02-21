package parserXML;

public class Point {
    private int uidp;
    private double x;
    private double y;

    public Point() {
    }

    public Point(int uidp, double x, double y) {
        this.uidp = uidp;
        this.x = x;
        this.y = y;
    }

    public int getUidp() {
        return uidp;
    }

    public void setUidp(int uidp) {
        this.uidp = uidp;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" + "uidp=" + uidp + ", x=" + x + ", y=" + y + '}';
    }
}
