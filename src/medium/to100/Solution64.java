package medium.to100;

/**
 * 动态规划
 * dp[i][j] = grid[i][j] + min(dp[i][j-1], dp[i-1][j])
 */

public class Solution64 {

	public int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] dp = new int[m][n];
		
		dp[0][0] = grid[0][0];
		for(int i=1; i<m; i++) {
			dp[i][0] = dp[i-1][0] + grid[i][0];
		}
		
		for(int j=1; j<n; j++) {
			dp[0][j] = dp[0][j-1] + grid[0][j];
		}
		
		for(int i=1; i<m; i++) {
			for(int j=1; j<n; j++) {
				dp[i][j] = grid[i][j] + Math.min(dp[i][j-1], dp[i-1][j]);
			}
		}
		return dp[m-1][n-1];
	}
	
	public static void main(String[] args) {
		int[][] grid = {
				{1,3,1},
				{1,5,1},
				{4,2,1}
		};
		int res = new Solution64().minPathSum(grid);
		System.out.println(res);
	}
}
