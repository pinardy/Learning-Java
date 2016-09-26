import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Pin on 24-Sep-16.
 */
public class TestOctagon{
        public static void main(String[] args) {
            ArrayList<Octagon> l = new ArrayList<Octagon>();
            l.add(new Octagon(2));
            l.add(new Octagon(3));
            l.add(new Octagon(1));
            Collections.sort(l);
            for (Octagon o:l)
                System.out.println(o.getSide());
        }
    }
