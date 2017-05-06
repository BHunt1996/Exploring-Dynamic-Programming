import java.io.*;
/**
* An implementation of the "maximum size square sub-matrix with all 1's" dynamaic programming problem
* Given a matrix of 0's and 1's, find the maximum sized square sub-matrix consisting only of 1's
* @author Bradley Hunt
* @since 12/01/16
*/
public class Matrix {
	/**
	* Using an array containg the values of the matrix and the number of columns and rows, this method
	* searches for the maaximum sized square sub-matrix within that consists of only 1's
    * @param matrix - a 2D array which represents the matrix of 1's and 0's
    * @param row, col - the number of rows and the number of colums the matrix has
    * @return max - The size of the maximum sized square sub-matrix as an integer 
    *				(i.e. 3x3 sized sub-matrix = 3)
    */
    public int subMatrix(int[][] matrix, int row, int col) {
    	/* Stores sub-problem results */
        int[][] result = new int[row][col];
        /* Fill the first coolumn */
        for (int i = 0; i < col; i++) {
            result[0][i] = matrix[0][i];
        }
        /* Fill the first row */
        for (int i = 0; i < row; i++) {
            result[i][0] = matrix[i][0];
        }
        /* For rest of the matrix check for any 1 values which are surrounded by 1's on
        to its left, top and diagonal-left top */
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 1) {
                    result[i][j] = Math.min(result[i - 1][j - 1],
                            Math.min(result[i][j - 1], result[i - 1][j])) + 1;
                } else {
                    result[i][j] = 0;
                }
            }
        }
        /* Find the maximum size sub-matrix from the stored sub-problem results */
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (result[i][j] > max) {
                    max = result[i][j];
                }
            }
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        /* Read in the number of rows & columns the matrix will have */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number of rows: ");
        int row = Integer.parseInt(br.readLine());
        System.out.println("Enter the number of columns: ");
        int col = Integer.parseInt(br.readLine());
        int[][] matrix = new int [row][col];
        /* Read in the values of each row one by one */
        System.out.println("Enter the matrix row by row:");
        System.out.println("Example for 4 columns: '1 0 1 0'");
        for(int i = 0; i < row; i++){
            String[] integersInString = br.readLine().split(" ");
            for (int j = 0; j < col; j++) {
                matrix[i][j] = Integer.parseInt(integersInString[j]);
            }
        }
        Matrix i = new Matrix();
        System.out.println("Maximum size square sub-matrix with all 1s: " + 
        						i.subMatrix(matrix, row, col));
    }
}
