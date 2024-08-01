package medium.to1000;



public class Solution152 {

	/**
	 * v2.0
	 * 正向遍历找最大乘积 + 逆向遍历找最大乘积
	 */
	public int maxProduct(int[] nums) {
		int len = nums.length;
		double product = 1;
		double max = nums[0];
		
		for(int i=0; i<len; i++) {
			product *= nums[i];
			max = Math.max(product, max);
			if(nums[i] == 0) {
				product = 1;
			}
		}
		
		product = 1;
		
		for(int i=len-1; i>=0; i--) {
			product *= nums[i];
			max = Math.max(product, max);
			if(nums[i] == 0) {
				product = 1;
			}
		}
		return (int)max;
	}
	
	/**
	 * v1.0
	 * 动态规划，因为有正负，用两个dp
	 * dpMax[i] = max(dpMax[i-1]*nums[i], dpMin[i-1]*nums[i], nums[i])
	 * dpMin[i] = min(dpMax[i-1]*nums[i], dpMin[i-1]*nums[i], nums[i])
	 */
	public int maxProduct1(int[] nums) {
		int len = nums.length;
		double[] dpMax = new double[len];
		double[] dpMin = new double[len];
		
		dpMax[0] = nums[0];
		dpMin[0] = nums[0];
		
		double max = nums[0];
		
		for(int i=1; i<len; i++) {
			dpMax[i] = Math.max(dpMax[i-1]*nums[i], Math.max(dpMin[i-1]*nums[i], nums[i]));
			dpMin[i] = Math.min(dpMax[i-1]*nums[i], Math.min(dpMin[i-1]*nums[i], nums[i]));
			if(dpMax[i] > max) {
				max = dpMax[i];
			}
		}
		return (int)max;
	}
	
	public static void main(String[] args) {
		int[] nums = {-2};
		int res = new Solution152().maxProduct(nums);
		System.out.println(res);
	}
}
