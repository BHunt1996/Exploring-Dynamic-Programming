import java.util.*;
import java.io.*;
/**
* An implementation of the Word Break Problem
* Given an input string and a dictionary of words, find out if the input string can be segmented 
* into a space-separated sequence of dictionary words.
* @author Bradley Hunt
* @since 06/02/17
*/
public class WordBreak {
	/**
    * Finds out if a given string can be spaced out into separate valid words found in a given dictionary
    * @param word - a string to be split up into separate words
    * @param dict - a hashset containing a dictionary of words
    * @return spaced - the string 'word' segmented into words contained in 'dict'
    */
    public String wordBreak(String word, Set<String> dict){
        int table[][] = new int[word.length()][word.length()];
        //checks for any words within the string that cannot be split (represented by -1)
        for(int i=0; i < table.length; i++){
            for(int j=0; j < table[i].length ; j++){
                table[i][j] = -1;
            }
        }
        //fills table for all substrings, starting at index i of length l
        for(int l = 1; l <= word.length(); l++){
            for(int i=0; i < word.length() -l + 1 ; i++){
                int j = i + l-1;
                String str = word.substring(i,j+1);
                //if the sub-string between i to j is in the dictionary, then T[i][j] is true
                if(dict.contains(str)){
                    table[i][j] = i;
                    continue;
                }
                //tries to find a value (k) between i+1 and j, 
                //such that table[i][k-1] and table[k][j] are both true 
                for(int k=i+1; k <= j; k++){
                    if(table[i][k-1] != -1 && table[k][j] != -1){
                        table[i][j] = k;
                        break;
                    }
                }
            }
        }
        if(table[0][word.length()-1] == -1){
            String failue = "String couldn't be broken into multiple words";
            return null;
        }

        //adds spaces to separate the words wherever possible and required
        StringBuffer buffer = new StringBuffer();
        int i = 0; 
        int j = word.length()-1;
        while(i < j){
            int k = table[i][j];
            if(i == k){
                buffer.append(word.substring(i, j+1));
                break;
            }
            buffer.append(word.substring(i,k) + " ");
            i = k;
        }
        
        String spaced =  buffer.toString();
        return spaced;
    }

	/**
	* Reads in the dictionary text file line by line and transfers it to a hashset
	* @return words - a hashset containg the words from the dictionary text file
	*/
	public HashSet<String> getWords() throws IOException {
		HashSet<String> words = new HashSet<String>();		
		File dict = new File("word-break-dictionary.txt");	
		try{	
			Scanner scn = new Scanner(dict);
			while(scn.hasNextLine()){
				String line = scn.nextLine();
				words.add(line);
			}
			scn.close();
		}catch(FileNotFoundException e){
			System.out.println(e);
		}
		return words;
	}

    public static void main(String args[]) throws IOException {
    	WordBreak wb = new WordBreak();
    	HashSet<String> dictionary = wb.getWords();

    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nEnter a String:");
        String str = br.readLine();
        System.out.println(wb.wordBreak(str, dictionary));
    }

}