// Problem Wk.1.2.2: Iterating with For-Each 

public class IteratingExamples {
	// -------- Default stuff -------------- //
	public static void main(String[] args) {
        System.out.println(Act2Iterator());
    }
    // -------------------------------------- //

// List<Integer> integers   ----> () inside the brackets for the tutor qn
    public static int Act2ForEach() {
    	int[] integers = {1,2,3,4,5};  // test case. remove for tutor submission
        int sum = 0; 
        
        for (int num : integers) {
        	sum += num;
    	}
    	return sum;
        // System.out.println(sum);
    }
}
