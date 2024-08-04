package medium.to100;

public class Solution53 {

	/**
	 * v2.0
	 * 贪心法
	 * 记录前缀和，当小于0时，重置为0
	 * @param nums
	 * @return
	 */
	public int maxSubArray(int[] nums) {
		int len = nums.length;
		int max = Integer.MIN_VALUE;
		int pre = 0;
		for(int i=0; i<len; i++) {
			pre += nums[i];
			max = Math.max(pre, max);
			if(pre<0) {
				pre = 0;
			}
		}
		return max;
	}
	
	/**
	 * v1.0
	 * 动态规划
	 * dp记录以i元素为尾的最大前缀和
	 * dp[i+1] = max(dp[i]+nums[i], nums[i])
	 * @param nums
	 * @return
	 */
	public int maxSubArray1(int[] nums) {
		int len = nums.length;
		int[] dp = new int[len+1];
		dp[0] = 0;
		int max = Integer.MIN_VALUE;
		for(int i=0; i<len; i++) {
			dp[i+1] = Math.max(dp[i]+nums[i], nums[i]);
			max = Math.max(dp[i+1], max);
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		int res = new Solution53().maxSubArray(nums);
		System.out.println(res);
	}
}
