import java.util.Arrays;
import java.util.List;

/**
 * Created by Pin on 27-Sep-16.
 */
public class UsingLists {
    public static void main(String[] args) {

        String a[] = new String[]{"abc","klm","xyz","pqr"};
        List list1 = Arrays.asList(a);

        System.out.println("The list is:" + list1);
    }
}