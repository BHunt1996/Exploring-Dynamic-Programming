/**
 ** Java Implementation of the Edit Distance Algorithm
 **/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
/** Class:  EditDistance **/
public class EditDistance {
    /** Method: editDistance **/
    public int editDistance(String s1, String s2) {
        int [][] sol = new int[s1.length()+1][s2.length()+1];
        
        //elements will be inserted
        for (int i = 0; i <=s2.length(); i++) {
            sol[0][i] =i;
        }

        //elements will be removed
        for (int i = 0; i <=s1.length(); i++) {
            sol[i][0] =i;
        }

        int m = s1.length();
        int n = s2.length();
        for (int i = 1; i <=m ; i++) {
            for (int j = 1; j <=n ; j++) {
                //If last characters match, ignore the last character
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    sol[i][j] = sol[i-1][j-1];
                else
                    sol[i][j] = 1 + Math.min(sol[i][j-1],  //Insert
                                    Math.min(sol[i-1][j], //Delete
                                    sol[i-1][j-1]));     //Subsitute
            }
        }
        return sol[s1.length()][s2.length()];
    }

    /** Main Method **/
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Edit Distance Problem\n");

        System.out.println("\nEnter the First String:");
        String str1 = br.readLine();
 
        System.out.println("\nEnter the Second String:");
        String str2 = br.readLine();

        EditDistance ed = new EditDistance();
        System.out.println("Minimum Edit Distance: " + ed.editDistance(str1, str2));
    }
}