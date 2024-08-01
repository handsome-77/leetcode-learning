package medium.to1000;

/**
 * 动态规划
 * dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
 * 类似279题
 */

public class Solution322 {

	public int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount+1];
		for(int i=1; i<=amount; i++) {
			dp[i] = amount+1;
			for(int j=0; j<coins.length; j++) {
				if(i>= coins[j]) {
					dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
				}
			}
		}
		if(dp[amount]==amount+1) {
			return -1;
		}
		return dp[amount];
	}
	
	public static void main(String[] args) {
		int[] coins = {2};
		int amount = 3;
		int res = new Solution322().coinChange(coins, amount);
		System.out.println(res);
	}

}
