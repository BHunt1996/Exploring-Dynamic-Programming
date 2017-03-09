import java.io.BufferedReader;
import java.io.InputStreamReader;

public class  LongestCommonSubsequence {
    //given two strings, str1 & str2, return the longest subsequence
    //common to both str1 & str2
    public String lcs(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
 
        int[][] arr = new int[len1 + 1][len2 + 1];
 
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                if (str1.charAt(i) == str2.charAt(j))
                    arr[i][j] = arr[i + 1][j + 1] + 1;
                else 
                    arr[i][j] = Math.max(arr[i + 1][j], arr[i][j + 1]);
            }
        }
 
        int i = 0, j = 0;
        StringBuffer sb = new StringBuffer();
        while (i < len1 && j < len2) {
            if (str1.charAt(i) == str2.charAt(j)) {
                sb.append(str1.charAt(i));
                i++;
                j++;
            }
            else if (arr[i + 1][j] >= arr[i][j + 1]) 
                i++;
            else
                j++;
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Longest Common Subsequence Problem\n");
 
        System.out.println("\nEnter the First String:");
        String str1 = br.readLine();
 
        System.out.println("\nEnter the Second String:");
        String str2 = br.readLine();
 
        LongestCommonSubsequence obj = new LongestCommonSubsequence(); 
        String result = obj.lcs(str1, str2);
 
        System.out.println("\n The Longest Common Subsequence is: "+ result);
    }
}