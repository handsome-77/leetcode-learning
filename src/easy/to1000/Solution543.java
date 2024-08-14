package easy.to1000;

import structure.TreeNode;

public class Solution543 {

	int res = 0;
	/**
	 * v1.0
	 * 递归，深度优先遍历
	 * @param root
	 * @return
	 */
	public int diameterOfBinaryTree(TreeNode root) {
		depth(root);
		return res;
	}
	public int depth(TreeNode node) {
		if(node==null) {
			return 0;
		}
		int left = depth(node.left);
		int right = depth(node.right);
		res = Math.max(res, left+right);
		return Math.max(left, right)+1;
	}
}
