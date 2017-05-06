import java.io.*;
/**
* An implementation of the Edit Distance Problem
* Finds the minimum number of edit operations required to convert one string to another 
* @author Bradley Hunt
* @since 04/02/17
*/
public class EditDistance {
	/**
	* Taking two strings str1 and str2, finds the minimum number of edit operations
	* required to convert str1 into str2
    * @param str1 - a string that we want to find the edit distance to convert it to str2
    * @param str2 - the string that we want str1 to convert to
    * @return distance - The number of edits required to concert str1 to str2
    */
    public int editDistance(String str1, String str2) {
    	/* 2D array initialised for subproblem result storage */
    	int len1 = str1.length();
    	int len2 = str2.length();
        int [][] sol = new int[len1+1][len2+1];
        /* If either of the strings are empty, then the number of operations needed will
        be equal to the length of the other string */
        /* So either: all elements are inserted */
        for (int i = 0; i <=len2; i++) {
            sol[0][i] = i;
        }
        /* Or all elements are removed */
        for (int i = 0; i <=len1; i++) {
            sol[i][0] = i;
        }

        for (int i = 1; i <= len1 ; i++) {
            for (int j = 1; j <= len2 ; j++) {
                /* If last characters match, ignore the last character and recurse remaining string */
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    sol[i][j] = sol[i-1][j-1];
                }
                /* If last characters are different, try all edit operation 
                possibilities and find the minimum */
                else {
                    sol[i][j] = 1 + Math.min(sol[i][j-1],  //Insert
                                    Math.min(sol[i-1][j], //Delete
                                    sol[i-1][j-1]));     //Substitute
                }
            }
        }
        getEdits(sol, str1, str2);
        /* Output the edit distance */
        int distance = sol[len1][len2];
        return distance;
    }

	/**
	* Once the edit distance is known, finds the actual edit operations used
    * @param sol - an array containg the edit distance
    * @param str1, str2 - the originallly inputted strings
    */
    public void getEdits(int sol[][], String str1, String str2){
    	/* Convert both strings to seperate character arrays */
    	char[] char1 = str1.toCharArray();
    	char[] char2 = str2.toCharArray();
    	int i = sol.length -1;
    	int j = sol[0].length -1;

    	while (true) {
    		/* Finish if the number of operations printed matches the edit distance value */
    		if (i == 0 || j == 0) {
            	break;
            }
            /* If characters were already the same, they're skipped over */
            if (char1[i-1] == char2[j-1]) {
                i = i-1;
                j = j-1;
            /* Checks for a subsitute operation */
            } else if (sol[i][j] == sol[i-1][j-1] + 1){
                System.out.println("Substitute " + char1[i-1] + " for " + char2[j-1]);
                i = i-1;
                j = j-1;
            /* Checks for a delete opertation */
            } else if (sol[i][j] == sol[i-1][j] + 1) {
                System.out.println("Delete " + char1[i-1]);
                i = i-1;
            /* Checks for an insert operation */
            } else if (sol[i][j] == sol[i][j-1] + 1){
                System.out.println("Insert " + char2[j-1]);
                j = j -1;
            /* In case of an error */
            } else {
                throw new IllegalArgumentException("Invalid Data");
            }
        }
        System.out.print("\n");
    }
 


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /* Read in two strings for comparison */
        System.out.println("\nEnter the First String:");
        String str1 = br.readLine();
        System.out.println("Enter the Second String:");
        String str2 = br.readLine();
        System.out.print("\n");
        EditDistance ed = new EditDistance();
        System.out.println("Minimum Edit Distance: " + ed.editDistance(str1, str2));
    }
}