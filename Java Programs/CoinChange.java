import java.util.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;


public class CoinChange {
	public int minCoinDynamic(int amount, int[] coins) {
		int[] coinReq = new int[amount+1]; // this will store the optimal solution
										  // for all the values -- from 0 to given amount.
											
		int[] CC = new int[coins.length]; // resets for every smaller problems
											// and minimum in it is the optimal
											// solution for the smaller problem.
		coinReq[0] = 0; // 0 coins are required to make the change for 0
		// now solve for all the amounts
		for (int amt = 1; amt <= amount; amt++) {
			for (int j = 0; j < CC.length; j++) {
				CC[j] = -1;
			}
			// Now try taking every coin one at a time and fill the solution in
			// the CC[]
			for (int j = 0; j < coins.length; j++) {
				if (coins[j] <= amt) { // check if coin value is less than
										// amount
					CC[j] = coinReq[amt - coins[j]] + 1; // if available,
																// select the
																// coin and add
																// 1 to solution
																// of
																// (amount-coin
																// value)
				}
			}
			//Now solutions for amt using all the coins is stored in CC[]
			//take out the minimum (optimal) and store in coinReq[amt]
			coinReq[amt]=-1;
			for(int j=1;j<CC.length;j++){
				if(CC[j]>0 && (coinReq[amt]==-1 || coinReq[amt]>CC[j])){
					coinReq[amt]=CC[j];
				}
			}
		}
		//return the optimal solution for amount
		return coinReq[amount];
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Minimum Coin Change Problem\n");

		System.out.println("Enter the Total Amount:\n");
        int amount = Integer.parseInt(br.readLine());

		System.out.println("Enter the Coin Values:");
		System.out.println("(e.g. '1 5 10')");
		String[] integersInString = br.readLine().split(" ");
		int coins[] = new int[integersInString.length];
		for (int i = 0; i < integersInString.length; i++) {
		    coins[i] = Integer.parseInt(integersInString[i]);
		}


		CoinChange m = new CoinChange();
		System.out.println("Minimum Coins required to make change for "
				 + "an amount of " + amount  + " are: " + m.minCoinDynamic(amount, coins));
	}

}