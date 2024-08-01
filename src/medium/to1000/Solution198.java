package medium.to1000;

/**
 * 动态规划
 */
public class Solution198 {

	public int rob(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		dp[0] = nums[0];
		if(n==1) {
			return dp[0];
		}
		dp[1] = Math.max(dp[0], nums[1]);
		if(n==2) {
			return dp[1];
		}
		for(int i=2; i<n; i++) {
			dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
		}
		return dp[n-1];
	}
	
	public static void main(String[] args) {
		int[] nums = {2,7,9,3,1};
		int res = new Solution198().rob(nums);
		System.out.println(res);
	}

}
