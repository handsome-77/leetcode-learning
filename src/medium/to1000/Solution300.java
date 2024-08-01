package medium.to1000;

/**
 * 动态规划
 * 从后往前遍历
 */

public class Solution300 {
	
	public int lengthOfLIS(int[] nums) {
		int len = nums.length;
		int[] dp = new int[len];
		dp[len-1] = 1;
		int max = 1;
		for(int i=len-2; i>=0; i--) {
			dp[i] = 1;
			for(int j=i+1; j<len; j++) {
				if(dp[j] >= dp[i] && nums[i] < nums[j]) {
					dp[i] = dp[j]+1;
				}
			}
			if(dp[i] > max) {
				max = dp[i];
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] nums = {7,7,7,7,7,7,7};
		int res = new Solution300().lengthOfLIS(nums);
		System.out.println(res);
	}
}
