import java.io.*;
/**
* An implementation of the Longest Palindromic Substring Problem
* Finds the maximum-length contiguous substring of a given string that is also a palindrome.
* @author Bradley Hunt
* @since 04/02/17
*/
public class LongestPalindromicSubstring {
    /**
    * Given a string, find the longest palindromic substring found within
    * @param s - the string which will be checked for palidromic substrings
    * @return longest - the longest palindromic substring within s
    */
    public String lps(String s) {
        int len = s.length();
        int maxLen = 1;
        String longest = null;
        boolean [][] res = new boolean[len][len];

        /* Any string of length 1 is a palindrome */
        if(len == 1){
            return s;
        }
    
        /* Loops through the string in both directions, looking for matching substrings in each 
        loop through */
        for(int l = 0; l < len; l++){
            for(int i = 0; i < len-l; i++){
                /* Get the ending index of the substring from start index i and length l */
                int j = i+l;
                /* Checks whether the first & last characters match 
                and if the rest of the current substring is a palindrome */
                if(s.charAt(i) == s.charAt(j) && (j-i <= 2|| res[i+1][j-1])){
                    res[i][j]=true;
                    /* If the palindrome is longer than the maxLen value, it is now the LPS, 
                    the maxLen value is updated and substring is stored as the LPS */
                    if(j - i+1>maxLen){
                       maxLen = j-i+1; 
                       longest = s.substring(i, j+1);
                    }
                }
            }
        }
        return longest;
    }

    public static void main(String[] args) throws IOException { 
        /* Read in a string */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nEnter a String:");
        String str = br.readLine();
        /* Remove any spaces from the string to stop them from counting towards the LPS */
        str = str.replaceAll("\\s+","");
        LongestPalindromicSubstring obj = new LongestPalindromicSubstring();
        String result = obj.lps(str);
        /* Prints the LPS, or a message stating that a LPS couldn't be found */
        if(result != null){
            System.out.println("The Longest Palindromic Substring is: "+ result
            					+ "\nWhich has a length of: " + result.length());
        } else {
            System.out.println("No Palindromic Subsequence Could Be Found");
        }
    }
}