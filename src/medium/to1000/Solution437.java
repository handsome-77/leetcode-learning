package medium.to1000;

import structure.TreeNode;

public class Solution437 {

	/**
	 * v2.0
	 * 深度优先遍历DFS
	 * 多个变量currentNum
	 * 注意：currentNum必须为long，如果是int，会被截断
	 */
	int count = 0;
	public int pathSum(TreeNode root, int targetSum) {
		if (root == null) {
			return 0;
		}
		dfs(root, targetSum, 0);
		pathSum(root.left, targetSum);
		pathSum(root.right, targetSum);
		return count;
	}
	public void dfs(TreeNode node, int targetNum, long currentNum) {
		if (node == null) {
			return;
		}
		currentNum += node.val;
		if (currentNum == targetNum) {
			count++;
		}
		dfs(node.left, targetNum, currentNum);
		dfs(node.right, targetNum, currentNum);
	}
	
	/**
	 * v1.0
	 * 深度优先遍历DFS
	 * @param root
	 * @param targetSum
	 * @return
	 */
	public int pathSum1(TreeNode root, long targetSum) {
		if (root == null) {
			return 0;
		}
		int count = 0;
		count += dfs1(root, targetSum);
		count += pathSum1(root.left, targetSum);
		count += pathSum1(root.right, targetSum);
		return count;
	}
	public int dfs1(TreeNode node, long targetNum) {
		int count = 0;
		if (node == null) {
			return 0;
		}
		if (node.val == targetNum) {
			count++;
		}
		count += dfs1(node.left, targetNum-node.val);
		count += dfs1(node.right, targetNum-node.val);
		return count;
	}
	
}
