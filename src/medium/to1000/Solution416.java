package medium.to1000;

/**
 * 动态规划，背包问题，二维
 */

public class Solution416 {

    public boolean canPartition(int[] nums) {
    	int len = nums.length;
//    	数组长度小于2，返回false
    	if(len<2) {
    		return false;
    	}
    	int sum = 0;
    	int max = nums[0];
    	for(int num: nums) {
    		sum += num;
    		max = Math.max(max, num);
    	}
//    	总和为奇数，返回false
    	if((sum & 1) == 1) {
    		return false;
    	}
    	int half = sum>>>1;
//    	最大数大于总和一半，返回false
    	if(max>half) {
    		return false;
    	}
    	
    	boolean[][] dp = new boolean[len][half+1];
    	for(int i=0; i<len; i++) {
    		dp[i][0] = true;
    	}
    	dp[0][nums[0]] = true;
    	for(int i=1; i<len; i++) {
    		for(int j=1; j<=half; j++) {
    			if(j>=nums[i]) {
    				dp[i][j] = dp[i-1][j] | dp[i-1][j-nums[i]];
    			}else {
    				dp[i][j] = dp[i-1][j];
    			}
    		}
    	}
    	return dp[len-1][half];
    }
	
	public static void main(String[] args) {
		int[] nums = {1,5,11,5};
		boolean res = new Solution416().canPartition(nums);
		System.out.println(res);
	}
}
