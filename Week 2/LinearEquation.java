/**
 * Created by Pin on 20-Sep-16.
 * Problem Wk.2.5.1: 2x2 Linear Equations
 */

class LinearEquation {
    //data
    private double a,b,c,d,e,f;

    //constructor
    public LinearEquation(double a,double b,double c,double d,double e,double f){
        this.a=a;
        this.b=b;
        this.c=c;
        this.d=d;
        this.e=e;
        this.f=f;
    }
    // ----------- Getters -------------
    public double getA(){
        return a;
    }
    public double getB(){
        return b;
    }
    public double getC(){
        return c;
    }
    public double getD(){
        return d;
    }
    public double getE(){
        return e;
    }
    public double getF(){
        return f;
    }

    public double getX() {
        double x = (d*e-b*f)/(a*d-b*c);
        return x;
    }
    public double getY() {
        double y = (a*f-c*e)/(a*d-c*b);
        return y;
    }
    // ===============================
    public boolean isSolvable(){
        if (a*d- b*c != 0){
            return true;
        } else {
            return false;
        }
    }

}
