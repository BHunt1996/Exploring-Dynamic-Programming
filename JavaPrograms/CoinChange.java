import java.io.*;
/**
* An implementation of the Minimum Coin Change Problem
* Given a total amount and a set of n coins, find out minimum number of coins required to 
* make the change for the total amount
* @author Bradley Hunt
* @since 08/11/16
*/
public class CoinChange {
	/**
	* This method takes in a total amount and a set of coins and finds the minimum number of coins
	* from the set that can be used to form the total amount
    * @param amount - the amount we wish to make change for
    * @param coins - an array containing n coin values
    * @return numCoins - the number of coins required to make change for the total amount
    */
    public int minCoins(int amount, int coins[]){
    	/* Stores the minimum number of coins needed to form each possible amount value */
        int minCoin[] = new int[amount + 1];
        /* Stores the position (in coins[]) of the coin used to produce the minimum value
        that's stored in minCoin[] */
        int coinPos[] = new int[amount + 1];
        /* 0 coins are required to make change for an amount of 0 */
        minCoin[0] = 0;
        /* Initially the arrays are filled with temporary values */
        for(int i=1; i <= amount; i++){
        	minCoin[i] = Integer.MAX_VALUE-1;
            coinPos[i] = -1;
        }
        /* Iterate through all possible amounts for each coin value */
        for(int j=0; j < coins.length; j++){
            for(int i=1; i <= amount; i++){
            	/* Check if the current amount is >= the current coin value */
                if(i >= coins[j]){
                	/* Check if the current coin can be used to produce a smaller minimum value
                	than the existing value in minCoin[] */
                    if (minCoin[i - coins[j]] + 1 < minCoin[i]) {
                    	/* stores the number of the current coin needed to form the current amount */
                        minCoin[i] = minCoin[i - coins[j]] + 1;
                        /* Stores the coin's array position */
                        coinPos[i] = j;
                    }
                }
            }
        }
        /* Calls a separate method (coinCombo) in order to obtain and print the coin values use to make up
        the minimum change */
        coinCombo(coinPos, coins);
        /* Return the minimum number of coins required to form the total amount */
        int numCoins = minCoin[amount];
        return numCoins;
    }

	/**
	* Obtains the coin values that make up the change for the total amounts, as well as ending the program
	* if no possible solution was obtained
    * @param coinPos - an array containing the positions within coins[] of the coin values used to
    *				   form the minimum change for each possible amount
    * @param coins - an array containing n coin values
    */
	public void coinCombo(int coinPos[], int coins[]) {
		/* Ends the program if a solution couldn't be obtained */
    	if (coinPos[coinPos.length - 1] == -1) {
            System.out.print("Change cannot be made using the given coins");
            System.exit(0);
        }
        /* Iterate backwards through coinPos[] and print corresponding values from coins[] */
        int start = coinPos.length - 1;
        System.out.print("Coins used to make change for the amount: ");
        /* Once the printed coin values add up to the total, the loop is ended */
        while ( start != 0 ) {
            int j = coinPos[start];
            System.out.print(coins[j] + " ");
            start = start - coins[j];
        }
        System.out.print("\n");
    }


	public static void main(String[] args) throws IOException {		
		/* Read in the total amount */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("\nEnter the Total Amount:");
        int amount = Integer.parseInt(br.readLine());
        /* Read in the coin values */
		System.out.println("Enter the Coin Values:");
		System.out.println("(e.g. '1 5 10')");
		String[] integersInString = br.readLine().split(" ");
		int coins[] = new int[integersInString.length];
		for (int i = 0; i < integersInString.length; i++) {
		    coins[i] = Integer.parseInt(integersInString[i]);
		}
		/* Obtain the output */
		CoinChange m = new CoinChange();
		System.out.println("Minimum Coins required to make change for "
				 + "an amount of " + amount  + " is: " + m.minCoins(amount, coins));
	}
}