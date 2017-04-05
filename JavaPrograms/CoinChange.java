import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class CoinChange {
	public int minCoins(int amount, int[] coins) {
		//stores an optimal solution for all the values from 0 to given amount
		int[] opSol = new int[amount+1];
		//stores solutions for a single sub-problem, resetting once the optimal
		//solution for that problem is found, moving onto the next sub-problem							
		int[] subSol = new int[coins.length];
		//0 coins are required to make change for 0
		opSol[0] = 0;
		//now solve for the values that make up the total amount
		for (int amt = 1; amt <= amount; amt++) {
			for (int j = 0; j < subSol.length; j++) {
				subSol[j] = -1;
			}
			//each coin is taken one at a time and used to fill the solution
			//in subSol[]
			for (int j = 0; j < coins.length; j++) {
				//check if the coin value is less than the amount
				if (coins[j] <= amt) { 
					//if available, select the coin & add 1 to the solution
					//of (amount-coin value)
					subSol[j] = opSol[amt - coins[j]] + 1;
				}
			}
			//From the solutions stored in subSol[], take out the optimal
			//and stores it in opSol[amt]
			opSol[amt]=-1;
			for(int j=1;j<subSol.length;j++){
				if(subSol[j]>0 && (opSol[amt]==-1 || opSol[amt]>subSol[j])){
					opSol[amt]=subSol[j];
				}
			}
		}
		//return the optimal solution for amount
		return opSol[amount];
		
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