/**
 * Created by Pin on 19-Sep-16.
 * Problem Wk.1.5.7: Geometry: The MyRectangle2D class
 */
public class MyRectangle2D {
    //data (keep within instance)
    private double x;
    private double y;
    private double height;
    private double width ;

    //getter & setter methods
    // -----------  X and Y  ------------------------ //
    public double getX(){
        return x;
    }
    public void setX(double x){
        this.x = x;
    }
    public double getY(){
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }
    // ------------  Width and Height  ----------------------- //
    public double getWidth(){
        return width;
    }
    public void setWidth(double width){
        this.width = width;
    }
    public double getHeight(){
        return height;
    }
    public void setHeight(double height){
        this.height = height;
    }// ------------  Area & Perimeter  ----------------------- //
    public double getArea(){
        return height*width;
    }
    public double getPerimeter(){
        return (2*height)+(2*width);
    }
    //======================//
    public double[] vertices(){
        double[] arrayOfPoints = {x-width/2, x+width/2, y-height/2, y+height/2};
        return arrayOfPoints; // form of {xmin, xmax, ymin, ymax}
    }


    public boolean contains(double x, double y){
        if (x <= vertices()[1] && x >= vertices()[0] && y <= vertices()[3] && y >= vertices()[2]){
            return true;
        }
        else {
            return false;
        }
    }
    public boolean contains(MyRectangle2D r) {
        if (this.contains(r.vertices()[0], r.vertices()[2]) &&
                this.contains(r.vertices()[0], r.vertices()[3]) &&
                this.contains(r.vertices()[1], r.vertices()[2]) &&
                this.contains(r.vertices()[1], r.vertices()[3])) {

            return true;
        } else {
            return false;
        }
    }
    public boolean overlaps(MyRectangle2D r){
        //rectangle should contain at least one of the points of the specified rectangle
//        if (!(this.contains(r) && // rectangle does not contain specified rectangle
//                this.contains(r.vertices()[0], r.vertices()[2]) ||
//                this.contains(r.vertices()[0], r.vertices()[3]) ||
//                this.contains(r.vertices()[1], r.vertices()[2]) ||
//                this.contains(r.vertices()[1], r.vertices()[3]))) {
//            return true;
//        } else {
//            return false;
//        }

        /* Rectangles do not overlap as long as one of the following conditions are satisfied:
        1) Right side of specified rect is to the right of the other rect
        2) Left side of specified rect is to the left of the other rect
        3) Top side of specified rect is to the top of the other rect
        4) Bottom side of specified rect is to the bottom of the other rect

        Coordinates of the bottom left and top right of the corners of the rectangles are compared.
        */

        double minX1 = this.vertices()[0];
        double maxX1 = this.vertices()[1];
        double minY1 = this.vertices()[2];
        double maxY1 = this.vertices()[3];

        double minX2 = r.vertices()[0];
        double maxX2 = r.vertices()[1];
        double minY2 = r.vertices()[2];
        double maxY2 = r.vertices()[3];

        if (minX2 > maxX1 || minY2 > maxY1 || maxX2 < minX1|| maxY2 < minY1){
            return false;
            } else{
            return true;
                }
            }

    //======================//

    //constructors
    public MyRectangle2D(double x, double y, double width, double height){
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
    }
    public MyRectangle2D(){
        x = 0;
        y = 0;
        width = 1;
        height = 1;
    }
}
