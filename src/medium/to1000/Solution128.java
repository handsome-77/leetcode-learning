package medium.to1000;

import java.util.HashSet;
import java.util.Set;

/**
 * set去重，hash加快搜索，找序列开头的数计数
 */

public class Solution128 {

	public int longestConsecutive(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for(int num: nums) {
			set.add(num);
		}
		int max = 0;
		for(int num: set) {
			if(!set.contains(num-1)) {
				int count = 1;
				int currentNum = num;
				while(set.contains(currentNum+1)) {
					count++;
					currentNum++;
				}
				max = Math.max(max, count);
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] nums = {0,3,7,2,5,8,4,6,0,1};
		int res = new Solution128().longestConsecutive(nums);
		System.out.println(res);
	}
}
