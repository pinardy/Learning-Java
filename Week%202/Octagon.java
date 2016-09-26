import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Pin on 24-Sep-16.
 * Problem Wk.2.5.5: Comparable interface
 */
class Octagon implements Comparable<Octagon> {
    private double side;

    public Octagon(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public int compareTo(Octagon compareSide) {
        // compareTo should return < 0 if this is supposed to be
        // less than other, > 0 if this is supposed to be greater than
        // other and 0 if they are supposed to be equal
        if (this.side < compareSide.side){
            return -1;
    } else if (this.side > compareSide.side) {
        return 1;
    }
        return 0;
    }
}
