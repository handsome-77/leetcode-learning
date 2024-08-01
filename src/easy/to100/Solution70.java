package easy.to100;

/**
 * 动态规划，类似斐波那契
 */

public class Solution70 {

	public int climbStairs(int n) {		
		if(n==1) {
			return 1;
		}
		if(n==2) {
			return 2;
		}
		if(n<1) {
			return 0;
		}
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		for(int i=3; i<=n; i++) {
			dp[i] = dp[i-1]+dp[i-2];
		}
		
		return dp[n];
	}
	
	public static void main(String[] args) {
		int n = 45;
		int res = new Solution70().climbStairs(n);
		System.out.println(res);
	}

}
