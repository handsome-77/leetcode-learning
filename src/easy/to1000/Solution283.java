package easy.to1000;



public class Solution283 {

	/**
	 * v2.0
	 * 双指针，左右指针
	 * 右指针指向待处理元素，左指针指向上一次处理元素的下一个元素
	 * 当右指针指向非零元素，与left指向元素交换
	 * 最后对左指针后续元素赋0
	 */
	public void moveZeroes(int[] nums) {
		int n = nums.length;
		int left=0, right=0;
		while(right<n) {
			if(nums[right] != 0) {
				nums[left] = nums[right];
				left++;
			}
			right++;
		}
		while(left<n) {
			nums[left] = 0;
			left++;
		}
	}
	
	/**
	 * v1.0
	 * 双指针，左右指针
	 * right指向待处理元素，left指向上次处理交换后的元素的下一个元素
	 */
	public void moveZeroes1(int[] nums) {
		int n = nums.length;
		int left=0,right=0;
		while(right<n) {
			if(nums[right]!=0) {
				int temp = nums[left];
				nums[left] = nums[right];
				nums[right] = temp;
				left++;
			}
			right++;
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {1,0};
		new Solution283().moveZeroes(nums);
		for(int num:nums) {
			System.out.print(num+",");
		}
	}
}
