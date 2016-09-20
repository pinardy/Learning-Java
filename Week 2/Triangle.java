/**
 * Created by Pin on 20-Sep-16.
 * Problem Wk.2.5.2: The Triangle Class
 */
class Triangle extends GeometricObject{
    //data
    double side1 = 1.0;
    double side2 = 1.0;
    double side3 = 1.0;
    double a,b,c;

    //constructor
    public Triangle(){ //no-arg constructor
        this.a= side1;
        this.b= side2;
        this.c = side3;
    }
    public Triangle(double a, double b, double c){
        this.a=a;
        this.b=b;
        this.c=c;
    }
    public double getArea(){
        double perimeter = getPerimeter();
        double s = (0.5)*perimeter;
        double area = Math.sqrt(s*(s-a)*(s-b)*(s-c));
        return area;
    }
    public double getPerimeter(){
        return a+b+c;
    }
    public String toString(){
        return "Triangle: side1 = " + a + " side2 = " + b + " side3 = " + c;
    }
}
