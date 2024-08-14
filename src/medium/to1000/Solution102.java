package medium.to1000;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import structure.TreeNode;

public class Solution102 {

	/**
	 * v1.0
	 * 层次遍历，队列
	 * @param root
	 * @return
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(root==null) {
			return res;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> temp = new ArrayList<Integer>(size);
			while(size>0) {
				TreeNode pollNode = queue.poll();
				if(pollNode!=null) {
					temp.add(pollNode.val);
					if(pollNode.left!=null) {
						queue.offer(pollNode.left);
					}
					if(pollNode.right!=null) {
						queue.offer(pollNode.right);
					}
				}
				size--;
			}
			res.add(temp);
		}
		return res;
	}
}
