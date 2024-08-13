package easy.to1000;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import structure.TreeNode;

public class Solution101 {

	/**
	 * v3.0
	 * 迭代，广度优先遍历
	 * @param root
	 * @return
	 */
	public boolean isSymmetric(TreeNode root) {
		if(root==null) {
			return true;
		}
		return checkByBFS(root.left, root.right);
	}
	public boolean checkByBFS(TreeNode left, TreeNode right) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(left);
		queue.offer(right);
		while(!queue.isEmpty()) {
			TreeNode node1 = queue.poll();
			TreeNode node2 = queue.poll();
			if(node1==null && node2==null) {
				continue;
			}
			if(node1==null || node2==null || node1.val!=node2.val) {
				return false;
			}
			queue.offer(node1.left);
			queue.offer(node2.right);
			queue.offer(node1.right);
			queue.offer(node2.left);
		}
		return true;
	}
	
	/**
	 * v2.0
	 * 迭代，广度优先遍历，用ArrayList辅助判断
	 * @param root
	 * @return
	 */
	public boolean isSymmetric2(TreeNode root) {
		if(root==null) {
			return true;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		TreeNode node = root;
		queue.offer(node);
		while(!queue.isEmpty()) {
			int size = queue.size();
			List<TreeNode> list = new ArrayList<>(size);
			while(size>0) {
				TreeNode pollNode = queue.poll();
				list.add(pollNode);
				if(pollNode!=null) {
					queue.offer(pollNode.left);
					queue.offer(pollNode.right);
				}
				size--;
			}
			int left = 0;
			int right = list.size()-1;
			while(left<right) {
				if(list.get(left)==null && list.get(right)==null) {
					left++;
					right--;
					continue;
				}
				if(list.get(left)==null || list.get(right)==null || list.get(left).val!=list.get(right).val) {
					return false;
				}
				left++;
				right--;
			}
		}
		return true;
	}
	
	/**
	 * v1.0
	 * 递归
	 * @param root
	 * @return
	 */
	public boolean isSymmetric1(TreeNode root) {
		if(root==null) {
			return true;
		}
		return check(root.left, root.right);
	}
	public boolean check(TreeNode left, TreeNode right) {
		if(left==null && right==null) {
			return true;
		}
		if(left==null || right==null) {
			return false;
		}
		return left.val==right.val && check(left.left, right.right) && check(left.right, right.left);
	}
}
