/**
 ** Java Implementation of the Longest Palindromic Substring Algorithm
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/** Class:  LongestPalindromicSubstring **/
public class LongestPalindromicSubstring {
    /** Method: lps **/
    public String lps(String s) {
        if(s==null || s.length()<=1){
            return s;
        }
     
        int len = s.length();
        int maxLen = 1;
        boolean [][] dp = new boolean[len][len];
     
        String longest = null;
        for(int l=0; l<s.length(); l++){
            for(int i=0; i<len-l; i++){
                int j = i+l;
                if(s.charAt(i)==s.charAt(j) && (j-i<=2||dp[i+1][j-1])){
                    dp[i][j]=true;
     
                    if(j-i+1>maxLen){
                       maxLen = j-i+1; 
                       longest = s.substring(i, j+1);
                    }
                }
            }
        }
     
        return longest;
    }

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Longest Common Subsequence Problem\n");
 
        System.out.println("\nEnter a String:");
        String str = br.readLine();
        LongestPalindromicSubstring obj = new LongestPalindromicSubstring();
        String result = obj.lps(str);

         System.out.println("\n The Longest Palindromic Subsequence is: "+ result); 

    }
}