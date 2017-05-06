import java.io.*;
/**
* An implementation of the Text Justification Problem
* Given a sequence of words, and a character limit for the width of one line,
* put line breaks in the given sequence such that the lines are printed neatly
* @author Bradley Hunt
* @since 05/02/17
*/
public class TextJustification {
    /**
    * Takes a sequence of words and a maximum line width, and prints the word sequence according to
    * the line width with appropiate line breaks
    * @param words - an array containing a sequence of strings
    * @param width - the maximum line width in integer form
    * @return justified - word sequence that has been correctly justified according to the line width value
    */
    public String justify(String words[], int width) {
        int cost[][] = new int[words.length][words.length];
        /* Calculate the cost of putting words from i to j in one line. 
        If the words don't all fit in one line then Integer.MAX_VALUE is placed there */
        for(int i=0 ; i < words.length; i++){
            cost[i][i] = width - words[i].length();
            for(int j=i+1; j < words.length; j++){
                cost[i][j] = cost[i][j-1] - words[j].length() - 1; 
            }
        }
        
        for(int i=0; i < words.length; i++){
            for(int j=i; j < words.length; j++){
                if(cost[i][j] < 0){
                    cost[i][j] = Integer.MAX_VALUE;
                }else{
                    cost[i][j] = (int)Math.pow(cost[i][j], 2);
                }
            }
        }
        
        /* Find the minimum cost from i to len is found by trying j between i to len
        and checking which one has the minimum cost to split words from i to len */
        int minCost[] = new int[words.length];
        int result[] = new int[words.length];
        for(int i = words.length-1; i >= 0 ; i--){
            minCost[i] = cost[i][words.length-1];
            result[i] = words.length;
            for(int j=words.length-1; j > i; j--){
                if(cost[i][j-1] == Integer.MAX_VALUE){
                    continue;
                }
                if(minCost[i] > minCost[j] + cost[i][j-1]){
                    minCost[i] = minCost[j] + cost[i][j-1];
                    result[i] = j;
                }
            }
        }

        int i = 0;
        int j;
        /* Print the minimum cost */
        System.out.println("Minimum cost is " + minCost[0]);
        System.out.println("\n");

        /* Put all words with a new line added in string buffer and print it */
        StringBuilder builder = new StringBuilder();
        do{
            j = result[i];
            for(int k=i; k < j; k++){
                builder.append(words[k] + " ");
            }
            builder.append("\n");
            i = j;
        } while(j < words.length);
        String justified = builder.toString();
        return justified;
    }
    
    public static void main(String args[]) throws IOException {
        /* Read in the sequence of words to be justified */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nEnter a sequence of words: ");
        String[] seq = br.readLine().split(" ");
        /* Read in the line width */
        System.out.println("Enter the Line Width : ");

        System.out.println("(number of characters allowed on one line)");
        int ln = Integer.parseInt(br.readLine());

        TextJustification tj = new TextJustification();
        System.out.println(tj.justify(seq, ln));
    }
}