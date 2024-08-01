package medium.to1000;

/**
 * 动态规划
 * 初始化dp[]，n+1数组，每个元素都为0
 * 遍历dp数组，dp[i] = i
 * dp[i] = min(dp[i], dp[i-j*j]+1)
 */

public class Solution279 {

	public int numSquares(int n) {
		int[] dp = new int[n+1];
		for(int i=1; i<=n; i++) {
			dp[i] = i;
			int j = 1;
			while(i>=j*j) {
				dp[i] = Math.min(dp[i], dp[i-j*j]+1);
				j++;
			}
		}
		return dp[n];
	}
	
	public static void main(String[] args) {
		int n = 4;
		int res = new Solution279().numSquares(n);
		System.out.println(res);
	}

}
