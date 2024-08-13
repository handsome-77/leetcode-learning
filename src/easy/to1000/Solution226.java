package easy.to1000;

import java.util.LinkedList;
import java.util.Queue;

import structure.TreeNode;

public class Solution226 {

	/**
	 * v3.0
	 * 迭代，广度优先遍历，层次遍历
	 * @param root
	 * @return
	 */
	public TreeNode invertTree(TreeNode root) {
		if(root==null) {
			return null;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			TreeNode poll = queue.poll();
			if(poll==null) {
				continue;
			}
			queue.offer(poll.left);
			queue.offer(poll.right);
			TreeNode temp = poll.left;
			poll.left = poll.right;
			poll.right = temp;
		}
		return root;
	}
	
	/**
	 * v2.0
	 * 迭代，深度优先遍历，中序遍历
	 * @param root
	 * @return
	 */
	public TreeNode invertTree2(TreeNode root) {
		if(root==null) {
			return null;
		}
		TreeNode rootCopy = root;
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		while(rootCopy!=null || !stack.isEmpty()) {
			while(rootCopy != null) {
				stack.push(rootCopy);
				rootCopy = rootCopy.left;
			}
			rootCopy = stack.pop();
			TreeNode temp = rootCopy.left;
			rootCopy.left = rootCopy.right;
			rootCopy.right = temp;
			rootCopy = rootCopy.left;
		}
		return root;
	}
	
	/**
	 * v1.0
	 * 递归
	 * @param root
	 * @return
	 */
    public TreeNode invertTree1(TreeNode root) {
    	if(root==null) {
    		return null;
    	}
    	TreeNode temp = root.left;
    	root.left = invertTree(root.right);
    	root.right = invertTree(temp);
    	return root;
    }
}
