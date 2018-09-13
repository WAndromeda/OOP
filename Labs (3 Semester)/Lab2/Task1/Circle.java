import java.lang.Math;

public class Circle {
    private double radius;
    private Point center;
    Circle(){
        radius = 0;
        center = new Point();
    }
    Circle(double radius, Point center){
        this.radius = radius;
        this.center = center;
    }
    Circle(double radius, double x, double y){
        this.radius = radius;
        center = new Point(x, y);;
    }
    public double getRadius() {
        return radius;
    }

    public Point getCenter(){
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public void setCenter(double x, double y) {
        center.setX(x);
        center.setY(y);
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getDiameter(){
        return 2*radius;
    }

    public double getLength(){ return 2*radius*Math.PI; }

    public double getSquare(){ return Math.PI*radius*radius; }

    public double getCenterX(){
        return center.getX();
    }

    public double getCenterY(){
        return center.getY();
    }

    public void setCenterX(double x){
        center.setX(x);
    }

    public void setCenterY(double y){
         center.setY(y);
    }

    @Override
    public String toString() {
        return "Окружность\n" + "Радиус: " + radius + "\nДиаметр: " + getDiameter() + "\nКоординаты центра: " + getCenter() + "\nДлина Окружности: " + getLength() + "\nПлощадь Окружности: " + getSquare();
    }
}

class Point{
    double x, y;

    Point(){
        x = 0.0;
        y = 0.0;
    }

    Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    Point(Point point){
        x = point.getX();
        y = point.getY();
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Координата X: " + x + " | Координата Y: " + y ;
    }
}
