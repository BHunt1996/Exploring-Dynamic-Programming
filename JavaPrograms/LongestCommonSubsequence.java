import java.io.*;
/**
* An implementation of the Longest Common Subsequence Problem
* Given two strings, this program finds the longest subsequence present in both of them
* @author Bradley Hunt
* @since 02/11/16
*/
public class  LongestCommonSubsequence {
	/**
	* This method takes in two strings and find the longest common subsequence between the two.
    * @param str1, str2 - two strings
    * @return lcsLen - The length of the longest common subsequence between str1 and str2
    */
    public int getSubsequence(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        /* 2D array initialized with all 0's - LCS value starts at 0 */
        int[][] LCS = new int[len1 + 1][len2 + 1];
        /* Iterate backwards through both strings, comparing every character in both string 
        against one another */
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                /* If the current characters match, add 1 to the current LCS value  */
                if (str1.charAt(i) == str2.charAt(j)){
                    LCS[i][j] = LCS[i + 1][j + 1] + 1;
                /* Otherwise pick the max LCS value ovbtained thus far */
                } else {
                    LCS[i][j] = Math.max(LCS[i + 1][j], LCS[i][j + 1]);
                }
            }
        }
        int i = 0, j = 0;
        /* StringBuffer sb is used to store the characters that make up the longest common subsequence */
        StringBuffer sb = new StringBuffer();
        /* Using the obtained length of the LCS, search for matching characters within both strings */
        while (i < len1 && j < len2) {
            /* If characters in both strings match: add to the string buffer */
            if (str1.charAt(i) == str2.charAt(j)) {
                sb.append(str1.charAt(i));
                i++;
                j++;
            }
            /* Otherwise find the larger of the two values and go in that direction */
            else if (LCS[i + 1][j] >= LCS[i][j + 1]) {
                i++;
            } else {
                j++;
            }
        }
        /* LCS is restored to string form & printed */
        String sub = sb.toString();
        if (sub.length() == 0){
        	System.out.println("\nNo common subsequences found");
        }else{
            System.out.println("\nThe Longest Common Subsequence is: "+ sub);
        }
        /* Return the length of the LCS */
        int lcsLen = sub.length();
        return lcsLen;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /* Read in the two strings to be compared */
        System.out.println("\nEnter the First String:");
        String str1 = br.readLine();
        System.out.println("Enter the Second String:");
        String str2 = br.readLine();
 
        LongestCommonSubsequence obj = new LongestCommonSubsequence(); 
        int result = obj.getSubsequence(str1, str2);
        /* Print the LCS */
        System.out.println("Length: "+ result);
    }
}