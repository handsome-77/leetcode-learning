package medium.to100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。

candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 

对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 */

public class Solution39 {

	/**
	 * try-v1.0
	 * 排序+回溯，剪枝
	 * @param candidates
	 * @param target
	 * @return
	 */
	public List<List<Integer>> combinationSum(int[] candidates, int target){
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(candidates);
		backtrack(candidates, target, new ArrayList<>(), res, 0);
		return res;
	}
	public void backtrack(int[] candidates, int target, 
			List<Integer> combination, List<List<Integer>> res, int start) {
		if(start==candidates.length) {
			return;
		}
		if(target==0) {
			res.add(new ArrayList<>(combination));
			return;
		}
		for(int i=start; i<candidates.length; i++) {
			if(target-candidates[i]<0) {
				return;
			}
			combination.add(candidates[i]);
			backtrack(candidates, target-candidates[i], combination, res, i);
			combination.remove(combination.size()-1);
		}
	}
	
	/**
	 * v1.0
	 * 排序+回溯，剪枝
	 * @param candidates
	 * @param target
	 * @return
	 */
	public List<List<Integer>> combinationSum1(int[] candidates, int target){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		dfs(candidates, target, new ArrayList<Integer>(), res, 0);
		return res;
	}
	
	public void dfs(int[] candidates, int target, List<Integer> combine, List<List<Integer>> res, int start) {
		if(target == 0) {
			res.add(new ArrayList<Integer>(combine));
			return;
		}
		
		for(int i=start; i<candidates.length; i++) {
//			剪枝，因为已排序，如果加上后面的数，一定大于target
			if(target-candidates[i] < 0) {
				return;
			}
			combine.add(candidates[i]);
			dfs(candidates, target-candidates[i], combine, res, i);
			combine.remove(combine.size()-1);
		}
	}
	
	
	public static void main(String[] args) {
		Solution39 solution = new Solution39();
		int[] candidates = {8,7,4,3};
		int target = 11;
		List<List<Integer>> res = solution.combinationSum(candidates, target);
		System.out.println(res);
	}

}
