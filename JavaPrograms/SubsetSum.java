import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class SubsetSum {
	//given a set of integers, return whether or not there's
	//a non-empty subset whose sum is 0
	public static boolean subsetSum(int[] A, int sum) {
		boolean[][] solution = new boolean[A.length + 1][sum + 1];		
		// if sum is not zero and subset is 0, we can't make it 
		for(int i=1; i<=sum; i++){
			solution[0][i]=false;
		}
		// if sum is 0 the we can make the empty subset to make sum 0
				for(int i=0;i<=A.length;i++){
					solution[i][0]=true;
				}
		//
		for(int i=1; i<=A.length; i++){
			for(int j=1; j<=sum; j++){				
				//first copy the data from the top
				solution[i][j] = solution[i-1][j];
				
				//If solution[i][j]==false check if can be made
				if(solution[i][j] == false && j >= A[i-1]){
					solution[i][j] = solution[i][j] || solution[i-1][j-A[i-1]];				
				}
			}
		}		
		return solution[A.length][sum];
	}
	/** Main Method **/
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Subset Sum Problem\n");

		System.out.println("Enter the Subset:");
		System.out.println("(e.g. '1 2 3 4 5')");
		String[] integersInString = br.readLine().split(" ");
		int subset[] = new int[integersInString.length];
		for (int i = 0; i < integersInString.length; i++) {
		    subset[i] = Integer.parseInt(integersInString[i]);
		}

		System.out.println("Enter the Chosen Sum:\n");
        int sum = Integer.parseInt(br.readLine());

        SubsetSum m = new SubsetSum();
		System.out.println(m.subsetSum(subset, sum));
	}

}
