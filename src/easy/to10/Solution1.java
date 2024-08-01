package easy.to10;

import java.util.HashMap;
import java.util.Map;



public class Solution1 {

	/**
	 * v2.0
	 * 哈希表
	 */
	public int[] twoSum(int[] nums, int target) {
		int len = nums.length;
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<len; i++) {
			map.put(target-nums[i], i);
		}
		for(int j=0; j<len; j++) {
			if(map.containsKey(nums[j]) && map.get(nums[j]) != j) {
				return new int[] {j,map.get(nums[j])};
			}
		}
		return null;
	}
	
	
	/**
	 * v1.0
	 * 两个循环
	 */
	public int[] twoSum1(int[] nums, int target) {
		int len = nums.length;
		for(int i=0; i<len; i++) {
			for(int j=i+1; j<len; j++) {
				if(nums[i] + nums[j] == target) {
					return new int[]{i, j};
				}
			}
		}
		return null;
	}
	
}
