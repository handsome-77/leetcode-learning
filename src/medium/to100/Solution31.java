package medium.to100;

import java.util.Arrays;

public class Solution31 {

	public void nextPermutation(int[] nums) {
		int len = nums.length;
		int a=0,b=0;
		for(int i=len-1; i>0; i--) {
			if(nums[i]>nums[i-1]) {
				a=i-1;
				b=i;
				break;
			}
		}
		if(a==0 && b==0) {
			Arrays.sort(nums);
			return;
		}
		for (int i = len-1; i >= b; i--) {
			if(nums[i]>nums[a]) {
				int temp=nums[i];
				nums[i]=nums[a];
				nums[a]=temp;
				break;
			}
		}
		Arrays.sort(nums, b, len);
	}
	
	public static void main(String[] args) {
		int[] nums = {1,3,2};
		new Solution31().nextPermutation(nums);
		for(int i:nums) {
			System.out.println(i);
		}
	}

}
