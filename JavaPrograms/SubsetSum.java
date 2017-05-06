import java.io.*;
/**
* An implementation of the Subset Sum Problem
* Given a set of integers and a value sum, determine if there is a subset of the given set
* with sum equal to given sum
* @author Bradley Hunt
* @since 04/02/17
*/
public class SubsetSum {
    /**
    * Returns true if there is a subset of set[] with a sum equal to the given sum
    * @param set - the given set of integers
    * @param sum - to be checked against possible subset sums of set
    * @return sol - boolean value sghowing whether a subset sum was found that was equal to the given sum 
    */
	public boolean subsetSum(int[] set, int sum) {
		/* The value of solution[i][j] will be true if there is a subset
		of set[0..j-1] with a sum equal to i */
		boolean[][] solution = new boolean[set.length + 1][sum + 1];		
		/* If set is empty; no way to find the subset with non zero sum; hence false */
		for(int i=1; i<=sum; i++){
			solution[0][i]=false;
		}
		/* If sum is 0, then the answer is always true */
		for(int i=0; i<=set.length; i++){
			solution[i][0]=true;
		}
		
		for(int i=1; i<=set.length; i++){
			for(int j=1; j<=sum; j++){				
				solution[i][j] = solution[i-1][j];
				/* Check if the sum can be made by either: including the last element,
				or excluding the last element */
				if(solution[i][j]==false && j>=set[i-1]){
					solution[i][j] = solution[i][j] || solution[i-1][j-set[i-1]];				
				}
			}
		}
		boolean sol = solution[set.length][sum];	
		return sol;
	}

	public static void main(String[] args) throws IOException {
		/* Read in a set of numbers */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("\nEnter a set of numbers:");
		System.out.println("(e.g. '1 2 3 4 5')");
		String[] integersInString = br.readLine().split(" ");
		int subset[] = new int[integersInString.length];
		for (int i = 0; i < integersInString.length; i++) {
		    subset[i] = Integer.parseInt(integersInString[i]);
		}
		/* Read in the sum */
		System.out.println("Enter the Chosen Sum:");
        int sum = Integer.parseInt(br.readLine());

        SubsetSum m = new SubsetSum();
		System.out.println(m.subsetSum(subset, sum));
	}

}
