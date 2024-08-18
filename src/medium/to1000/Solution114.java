package medium.to1000;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import structure.TreeNode;

public class Solution114 {

	/**
	 * v3.0
	 * 左子树的最右结点的右结点接当前结点的右子树
	 * @param root
	 */
	public void flatten(TreeNode root) {
//		遍历每个结点
		while(root!=null) {
			if(root.left==null) {
//				若左子树为空，则遍历右子树，即下个结点
				root = root.right;
			}else {
//				pre存当前结点的左子树
				TreeNode pre = root.left;
//				找到左子树的最右结点
				while(pre.right!=null) {
					pre = pre.right;
				}
//				最右结点的下一个右结点为当前root结点的右子树
				pre.right=root.right;
//				当前root结点的右结点接root的左子树
				root.right=root.left;
//				当前root结点置空
				root.left=null;
//				遍历下个结点
				root=root.right;
			}
		}
	}
	
	/**
	 * v2.0
	 * 先序遍历，递归，将结点存放在List中，再遍历List改左右结点
	 * @param root
	 */
	public void flatten2(TreeNode root) {
		List<TreeNode> preOrder = new ArrayList<>();
		preOrder(root,preOrder);
		for(int i=0; i<preOrder.size(); i++) {
			preOrder.get(i).left=null;
			preOrder.get(i).right= (i<preOrder.size()-1 ? preOrder.get(i+1):null);
		}
	}
	public void preOrder(TreeNode node, List<TreeNode> preOrder){
		if(node==null) {
			return;
		}
		preOrder.add(node);
		preOrder(node.left, preOrder);
		preOrder(node.right, preOrder);
	}
	
	/**
	 * v1.0
	 * 栈，预排序
	 * @param root
	 */
	public void flatten1(TreeNode root) {
		if(root==null) {
			return;
		}
		LinkedList<TreeNode> stack = new LinkedList<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode popNode = stack.pop();
			if(popNode.right!=null) {
				stack.push(popNode.right);
			}
			if(popNode.left!=null) {
				stack.push(popNode.left);
			}
			popNode.left=null;
			if(!stack.isEmpty()) {
				popNode.right = stack.peek();
			}
		}
	}
}
