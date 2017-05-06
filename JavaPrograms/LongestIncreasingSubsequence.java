import java.util.Scanner;
/**
* Computes the longest increasing subsequence in a given sequence of integers
* @author Bradley Hunt
* @since 07/11/16
*/
public class LongestIncreasingSubsequence {
	/**
	* This method takes in a sequence of numbers and finds the length and values of
	* the longest increasing subsequence within the given sequence.
	* @param seq - an sequence of integers stored in an array
	* @param output - a string containing the LIS and its length
	*/
    public String getSubsequence(int[] seq) {
        /* Array used to store the longest increasing subsequence starting with each value from seq[] */
        int[] LIS = new int[seq.length];
        /* Loop through LIS for each array element and find all possible increasing subsequences */
        for (int i = 0; i < seq.length; i++) {
            int max = -1;
            for (int j = 0; j < i; j++) {
                /* Checks if the previous element > current element */
                if (seq[i] > seq[j]) {
                    /* Update the max from the previous entries */
                    if (max == -1 || max < LIS[j] + 1) {
                        max = 1 + LIS[j];
                    }
                }
            }
            /* Sets the max to 1, if there's not multiple increasing values */
            if (max == -1) {
                max = 1;
            }
            LIS[i] = max;
        }
        /* Find the maximum of all the stored subsequence lengths in LIS[] */
        int result = -1;
        int val = -1;
        for (int i = 0; i < LIS.length; i++) {
            if (result < LIS[i]) {
                result = LIS[i];
                val = i;
            }
        }
        /* Work backwards in order to restore the values that make up the determined LIS */
        String path =  seq[val] + " ";
        int res = result-1;
        for (int i = val-1; i > 0; i--) {
            if(LIS[i]==res){
                path =  seq[i] + " " + path;
                res--;
            }           
        }
        /* Derive the length from the obtained LIS for full accuracy */
        int len = path.replace(" ", "").length();
        /* Return length and an actual subsequence of this length
        (if there are multiple longest sequences, just one is picked) */
        String output = "Longest Increasing Subsequence: " + path + "\nWhich has a length of: " + len;
        return output;    
    }



    public static void main(String[] args) {
        /* Read in a sequence of integers */
        Scanner scan = new Scanner(System.in); 
        System.out.println("Enter number of elements");
        int n = scan.nextInt();
        int[] arr = new int[n + 1];
        System.out.println("\nEnter "+ n +" elements");
        for (int i = 1; i <= n; i++){
            arr[i] = scan.nextInt();
        }
 
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence(); 
        System.out.println(lis.getSubsequence(arr));
        scan.close();
    }

}