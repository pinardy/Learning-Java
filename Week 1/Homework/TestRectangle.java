/**
 * Created by Pin on 19-Sep-16.
 */
public class TestRectangle {
    public static void main(String[] args) {
        MyRectangle2D rectangle = new MyRectangle2D(2,3,9,9); // (x,y,width,height)
        MyRectangle2D rectSpecified = new MyRectangle2D(2,3,9,9); // (x,y,width,height)

//        System.out.println(rectangle.getArea());
//        System.out.println(rectangle.getPerimeter());
//        System.out.println(rectangle.getHeight());
//        System.out.println(rectangle.contains(2,2)); // (x,y)
//        System.out.println(rectangle.contains(9,9)); // (x,y)
//        System.out.println(rectangle.contains(rectSpecified)); // (x,y)
        System.out.println(rectangle.overlaps(rectSpecified)); // (x,y)
    }
}
