package easy.to1000;

import java.util.LinkedList;
import java.util.Queue;

import structure.TreeNode;

public class Solution104 {

	/**
	 * v2.0
	 * 迭代，广度优先遍历
	 * @param root
	 * @return
	 */
	public int maxDepth(TreeNode root) {
		if(root==null) {
			return 0;
		}
		int max = 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size>0) {
				TreeNode node = queue.poll();
				if(node.left!=null) {
					queue.offer(node.left);
				}
				if(node.right!=null) {
					queue.offer(node.right);
				}
				size--;
			}
			max++;
		}
		return max;
	}
	
	/**
	 * v1.0
	 * 递归，深度优先遍历
	 * @param root
	 * @return
	 */
	public int maxDepth1(TreeNode root) {
		if(root==null) {
			return 0;
		}
		return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
	}
}
