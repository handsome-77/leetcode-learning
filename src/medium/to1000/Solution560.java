package medium.to1000;

import java.util.HashMap;

public class Solution560 {

	/**
	 * v2.0
	 * 前缀和+哈希表优化
	 * @param nums
	 * @param k
	 * @return
	 */
	public int subarraySum(int[] nums, int k) {
		int len = nums.length;
		int count = 0;
		int pre = 0;
//		key：数值和（包括前缀和）， value：出现次数
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//		默认和为0出现一次
		map.put(0,1);
		for(int i=0; i<len; i++) {
//			计算前缀和
			pre += nums[i];
//			当map中存在（前缀和-目标值），表示存在区间的和为目标值
//			举个例子：[1,2,3,4,5], k=7, 
//			当遍历到元素4时，前缀和为10，此时map中存在（10-7）的键，即区间[1,2]，那么区间[3,4]的和为7
			if(map.containsKey(pre-k)) {
				count += map.get(pre-k);
			}
			map.put(pre, map.getOrDefault(pre, 0)+1);
		}
		return count;
	}
	
	/**
	 * v1.0
	 * 前缀和
	 * @param nums
	 * @param k
	 * @return
	 */
	public int subarraySum1(int[] nums, int k) {
		int len = nums.length;
		int count = 0;
		int[] pre = new int[len+1];
		for(int i=0; i<len; i++) {
			pre[i+1] = pre[i]+nums[i];
		}
		for(int i=0; i<len; i++) {
			for(int j=i; j<len; j++) {
				if(pre[j+1]-pre[i] == k) {
					count++;
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,1,1};
		int k = 2;
		int res = new Solution560().subarraySum(nums, k);
		System.out.println(res);
	}
}
