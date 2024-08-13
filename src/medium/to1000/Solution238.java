package medium.to1000;

public class Solution238 {

	/**
	 * v1.0
	 * 正向遍历，左乘积
	 * 逆向遍历，右乘积
	 * @param nums
	 * @return
	 */
	public int[] productExceptSelf(int[] nums) {
		int n = nums.length;
		int[] res = new int[n];
		int factor = 1;
		for(int i=0; i<n; i++) {
			factor = (i==0 ? factor:factor*nums[i-1]);
			res[i] = factor;
		}
		factor = 1;
		for(int i=n-1; i>=0; i--) {
			factor = (i==n-1 ? factor:factor*nums[i+1]);
			res[i] *= factor;
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		int[] res = new Solution238().productExceptSelf(nums);
		for(int num: res) {
			System.out.print(num+",");
		}
	}
}
