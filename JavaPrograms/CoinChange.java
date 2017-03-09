import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CoinChange {
	public int minCoins(int amount, int[] coins) {
		//stores an optimal solution for all the values from 0 to given amount
		int[] coinReq = new int[amount+1];
		//stores solutions for a single sub-problem, resetting once the optimal
		//solution for that problem is found, moving onto the next sub-problem							
		int[] CC = new int[coins.length];
		//0 coins are required to make change for 0
		coinReq[0] = 0;
		//now solve for the values that make up the total amount
		for (int amt = 1; amt <= amount; amt++) {
			for (int j = 0; j < CC.length; j++) {
				CC[j] = -1;
			}
			//each coin is taken one at a time and used to fill the solution
			//in CC[]
			for (int j = 0; j < coins.length; j++) {
				//check if the coin value is less than the amount
				if (coins[j] <= amt) { 
					//if available, select the coin & add 1 to the solution
					//of (amount-coin value)
					CC[j] = coinReq[amt - coins[j]] + 1;
				}
			}
			//From the solutions stored in CC[], take out the optimal
			//and store in coinReq[amt]
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
				 + "an amount of " + amount  + " are: " + m.minCoins(amount, coins));
	}

}