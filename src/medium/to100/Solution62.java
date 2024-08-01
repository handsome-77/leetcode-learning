package medium.to100;

/**
 * 动态规划，二维
 * dp[i][j] = dp[i-1][j] + dp[i][j-1]
 */

public class Solution62 {

	public int uniquePaths(int m, int n) {
		if(m==1 && n==1) {
			return 1;
		}
		int[][] dp = new int[m][n];
		for(int i=1; i<m; i++) {
			dp[i][0] = 1;
		}
		for(int j=1; j<n; j++) {
			dp[0][j] = 1;
		}
		
		for(int i=1; i<m; i++) {
			for(int j=1; j<n; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}
		return dp[m-1][n-1];
	}
	
	public static void main(String[] args) {
		int m=3;
		int n=2;
		int res = new Solution62().uniquePaths(m, n);
		System.out.println(res);
	}
}
