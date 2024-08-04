package medium.to100;

public class Solution189 {

	/**
	 * v2.0
	 * 翻转数组
	 * 翻转整个数组，翻转前部分数组，翻转后部分数组
	 * 注意：需要对k作取模
	 * 利用位运算优化两数交换
	 * @param nums
	 * @param k
	 */
	public void rotate(int[] nums, int k) {
		int len = nums.length;
		k %= len;
		rev(nums, 0, len-1);
		rev(nums, 0, k-1);
		rev(nums, k, len-1);
	}
	public void rev(int[] nums, int start, int end) {
		while(start<end) {
			nums[start] ^= nums[end];
			nums[end] ^= nums[start];
			nums[start] ^= nums[end];
			start++;
			end--;
		}
	}
	
	/**
	 * v1.0
	 * 找规律
	 * res[0] = nums[(len-k%len+i)%len]
	 * 注意：直接nums=res无法传值，因此clone nums数组
	 * @param nums
	 * @param k
	 */
	public void rotate1(int[] nums, int k) {
		int len = nums.length;
		int[] res = nums.clone();
		for(int i=0; i<len; i++) {
			nums[i] = res[(len-k%len+i)%len];
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {-1,1};
		int k = 5;
		new Solution189().rotate(nums, k);
		for(int num: nums) {
			System.out.print(num + ",");
		}
	}
}
