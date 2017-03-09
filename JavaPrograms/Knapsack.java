public class Knapsack {
    //returns the maximum of two integers
    static int max(int a, int b) { 
        return (a > b) ? a : b; 
    }
      
   //returns the maximum value that can be put in a knapsack of capacity W
    static int knapSackValue(int W, int wt[], int val[], int n) {
        int i, w;
        int K[][] = new int[n+1][W+1];
      
         // Build table K[][] in bottom up manner
         for (i = 0; i <= n; i++) {
            for (w = 0; w <= W; w++) {
                if (i==0 || w==0)
                    K[i][w] = 0;
                else if (wt[i-1] <= w)
                    K[i][w] = max(val[i-1] + K[i-1][w-wt[i-1]],  K[i-1][w]);
                else
                    K[i][w] = K[i-1][w];
            }
        }  
        return K[n][W];
    }
 
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("0/1 Knapsack Problem\n");
        System.out.println("Enter the number of items: ");
        int n = scan.nextInt();

        System.out.println("\nEnter the item's values: ");
        int []val = new int[n];
        for(int i=0; i<n; i++) {
            val[i] = scan.nextInt();
        }

        System.out.println("\nEnter the item's weights: ");
        int []wt = new int[n];
        for(int i=0; i<n; i++) {
            wt[i] = scan.nextInt();
        }

        System.out.println("\nEnter the maximum capacity: ");
        int W = scan.nextInt();

        System.out.println("\nThe maximum value that can be put in a knapsack of capacity " + W 
                                + " is: " + knapSackValue(W, wt, val, n));
    }
}