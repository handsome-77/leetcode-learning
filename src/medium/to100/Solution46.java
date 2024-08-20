package medium.to100;

import java.util.ArrayList;
import java.util.List;

public class Solution46 {

	/**
	 * v1.0
	 * 回溯
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> permute(int[] nums) {
		int len = nums.length;
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		boolean[] used = new boolean[len];
		List<Integer> path = new ArrayList<>();
		dfs(nums, used, len, 0, path, res);
		return res;
	}
	public void dfs(int[] nums, boolean[] used, int len, int depth, 
			List<Integer> path, List<List<Integer>> res) {
		if(depth==len) {
			res.add(new ArrayList<>(path));
			return;
		}
		for(int i=0; i<len; i++) {
			if(!used[i]) {
				path.add(nums[i]);
				used[i]=true;
				dfs(nums, used, len, depth+1, path, res);
				used[i]=false;
				path.remove(path.size()-1);
			}
		}
	}
}
