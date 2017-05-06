import java.io.*;
/**
* An implementation of the String Interleaving Problem
* Given 3 strings, find out if string 1 and 2 can be interleaved with one another to form string 3
* @author Bradley Hunt
* @since 06/02/17
*/
public class Interleave {
    /**
    * Finds out whether two strings str1 and str2 can be interleaved to form str3
    * @param str1, str2, str3 - string values to be used in the problem
    * @return tf - boolean value of whether str1 and str2 can be interleaved to form str3
    */
    public boolean isInterleaved(String str1, String str2, String str3) {
        /* Covers scenarios which would cause errors, returning false instead */
        if (str3 == null || (str1 == null && str2 == null) || 
            str1.length() + str2.length() != str3.length()) {
                return false;
        }
        /* 2D array used to store solutions of subproblems */
        boolean[][] sol = new boolean[str1.length() + 1][str2.length() + 1];
        /* Two empty strings interleave into another empty string */
        sol[0][0] = true;

        /* Checks characters in str3 against characters in str1 */
        for (int i = 1; i <= str1.length(); i++) {
            if (str3.charAt(i - 1) == str1.charAt(i - 1) && sol[i - 1][0]) {
                sol[i][0] = true;
            }
        }
        /* Checks characters in str3 against characters in str2 */
        for (int j = 1; j <= str2.length(); j++) {
            if (str3.charAt(j - 1) == str2.charAt(j - 1) && sol[0][j - 1]) {
                sol[0][j] = true;
            }
        }
        /* Checks characters in str3 against characters in both str1 and str2 */
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if ((str3.charAt(i + j - 1) == str1.charAt(i - 1) && sol[i - 1][j]) 
                    || (str3.charAt(i + j - 1) == str2.charAt(j - 1) && sol[i][j - 1])) {
                    sol[i][j] = true;
                }
            }
        }
        /* Get the final output, true or false */
        boolean tf = sol[str1.length()][str2.length()]; 
        return tf;
    }
    
    public static void main(String args[]) throws IOException {
        //read in three strings
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nEnter the First String:");
        String str1 = br.readLine();
        System.out.println("Enter the Second String:");
        String str2 = br.readLine();
        System.out.println("Enter the Third String:");
        String str3 = br.readLine();
        Interleave il = new Interleave();
        if(il.isInterleaved(str1, str2, str3) == true){
            System.out.println("\""+str3+"\"" + " can be formed by interleaving " + "\""+str1+"\"" 
                                + " and " + "\""+str2+"\"");
        } else {
            System.out.println("\""+str3+"\"" + " cannot be formed by interleaving " + "\""+str1+"\"" + 
                                " and " + "\""+str2+"\"");
        }
    }
    
}
