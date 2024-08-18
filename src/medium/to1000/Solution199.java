package medium.to1000;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import structure.TreeNode;

public class Solution199 {

	/**
	 * v1.0
	 * 层次遍历，广度优先遍历，每层最尾，队列
	 * @param root
	 * @return
	 */
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if(root==null) {
			return res;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size>0) {
				TreeNode pollNode = queue.poll();
				if(size==1) {
					res.add(pollNode.val);
				}
				if(pollNode.left!=null) {
					queue.offer(pollNode.left);
				}
				if(pollNode.right!=null) {
					queue.offer(pollNode.right);
				}
				size--;
			}
		}
		return res;
	}
}
