package medium.to100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 排序，固定一个数，双指针
 */

public class Solution35 {

	public List<List<Integer>> threeSum(int[] nums) {
		int len = nums.length;
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		
		Arrays.sort(nums);
		for(int i=0; i<len; i++) {
			int left = i+1;
			int right = len-1;
			
			if(i>0 && nums[i]==nums[i-1]) {
				continue;
			}
			
			while(left<right) {
				if(nums[i]+nums[left]+nums[right] < 0) {
					left++;
				}else if(nums[i]+nums[left]+nums[right] > 0) {
					right--;
				}else {
					List<Integer> temp = Arrays.asList(nums[i], nums[left], nums[right]);
					res.add(temp);
					left++;
					right--;
					while(left<len-1 && nums[left]==nums[left-1]) {
						left++;
					}
					while(right>0 && nums[right]==nums[right+1]) {
						right--;
					}
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] nums = {-1,0,1,0};
		List<List<Integer>> res = new Solution35().threeSum(nums);
		System.out.println(res);
	}
}
