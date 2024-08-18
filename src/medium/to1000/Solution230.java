package medium.to1000;

import java.util.LinkedList;

import structure.TreeNode;

public class Solution230 {

	/**
	 * v1.0
	 * 中序遍历，迭代
	 * @param root
	 * @param k
	 * @return
	 */
	public int kthSmallest(TreeNode root, int k) {
		LinkedList<TreeNode> stack = new LinkedList<>();
		while(root!=null || !stack.isEmpty()) {
			if(root!=null) {
				stack.push(root);
				root = root.left;
			}else {
				TreeNode popNode = stack.pop();
				k--;
				if(k==0) {
					return popNode.val;
				}
				root = popNode.right;
			}
		}
		return -1;
	}
}
