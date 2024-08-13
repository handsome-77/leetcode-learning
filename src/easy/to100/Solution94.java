package easy.to100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import structure.TreeNode;

public class Solution94 {

	/**
	 * v2.0
	 * 迭代，栈
	 * @param root
	 * @return
	 */
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> resIter = new ArrayList<Integer>();
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		while(root!=null || !stack.isEmpty()) {
			while(root!=null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			resIter.add(root.val);
			root = root.right;
		}
		return resIter;
	}
	
	
	public List<Integer> resRecur = new ArrayList<Integer>();
	/**
	 * v1.0
	 * 中序遍历，递归
	 * @param root
	 * @return
	 */
	public List<Integer> inorderTraversal1(TreeNode root) {
		if(root==null) {
			return resRecur;
		}
		inorderTraversal(root.left);
		resRecur.add(root.val);
		inorderTraversal(root.right);
		return resRecur;
	}
}
