package medium.to1000;

import structure.TreeNode;

public class Solution236 {

	/**
	 * v2.0
	 * 深度优先遍历，递归，代码优化
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root==null || root==p || root==q) {
			return root;
		}
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if(left==null) {
			return right;
		}
		if(right==null) {
			return left;
		}
		return root;
	}
	
	public TreeNode res;
	/**
	 * v1.0
	 * 深度优先遍历，递归
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
		dfs(root, p, q);
		return res;
	}
	public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
		if(root==null) {
			return false;
		}
		boolean left = dfs(root.left, p, q);
		boolean right = dfs(root.right, p, q);
		if((left&&right) || root.val==p.val || root.val==q.val) {
			res=root;
		}
		return left || right || root.val==p.val || root.val==q.val;
	}
}
