// Problem Wk.1.2.1: Iterating with Iterator 

public class IteratingExamples1 {
	// -------- Default stuff -------------- //
	public static void main(String[] args) {

		System.out.println(IteratingExamples());
    }
    // -------------------------------------- //
// List<Integer> integers   ----> () inside the brackets for the tutor qn
   	public static int IteratingExamples() {

		int[] integers = {1,2,3,4,5,6,7,8,9,10};  // test case. remove for tutor submission
		List<Integer> listOfIntegers = Arrays.asList(integers);
		int sum = 0;
   		Iterator<Integer> iter = listOfIntegers.iterator();

   		while (iter.hasNext()) {
   			sum += iter.next();
   		}


   		return sum;

  }
}