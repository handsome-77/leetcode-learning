package medium.to100;

import java.util.ArrayList;
import java.util.List;

public class Solution78 {

	/**
	 * v3.0
	 * 回溯，选或者不选后再回溯
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> subsets(int[] nums) {
		int len = nums.length;
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> single = new ArrayList<>();
		backtrack(nums, len, 0, single, res);
		return res;
	}
	public void backtrack(int[] nums, int len, int depth, 
			List<Integer> single, List<List<Integer>> res) {
		if(depth==len) {
			res.add(new ArrayList<>(single));
			return;
		}
//		选第depth个元素
		single.add(nums[depth]);
//		回溯
		backtrack(nums, len, depth+1, single, res);
//		不选第depth个元素
		single.remove(single.size()-1);
//		回溯
		backtrack(nums, len, depth+1, single, res);
	}
	
	/**
	 * v2.0
	 * 每次遍历向数组追加元素，动态规划
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> subsets2(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		res.add(new ArrayList<>());
		for(int i=0; i<nums.length; i++) {
			int size = res.size();
			for(int j=0; j<size; j++) {
				List<Integer> single = new ArrayList<>(res.get(j));
				single.add(nums[i]);
				res.add(single);
			}
		}
		return res;
	}
	
	/**
	 * v1.0
	 * 位运算，1为已选，0为未选，遍历2^n-1
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> subsets1(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
//		bound为数组长度下，需要遍历的次数，即2^n-1
		int bound = 1<<nums.length;
		for(int i=0; i<bound; i++) {
			List<Integer> single = new ArrayList<>();
			for(int j=0; j<nums.length; j++) {
//				1<<j表示1左移j位，即i需要与哪一位作与运算，若与运算后不为0，表示该位被选
				if((i&(1<<j))!=0) {
					single.add(nums[j]);
				}
			}
			res.add(single);
		}
		return res;
	}
}
