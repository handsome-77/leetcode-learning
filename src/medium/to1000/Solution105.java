package medium.to1000;

import java.util.HashMap;

import structure.TreeNode;

public class Solution105 {
	
	/**
	 * v1.0
	 * 递归
	 * @param preorder 先序遍历序列
	 * @param inorder 后序遍历序列
	 * @return
	 */
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		int len = preorder.length;
		HashMap<Integer, Integer> inorderMap = new HashMap<Integer, Integer>();
		for(int i=0; i<len; i++) {
			inorderMap.put(inorder[i], i);
		}
		return buildRecur(preorder, 0, len-1, inorderMap, 0, len-1);
		
	}
	
	public TreeNode buildRecur(int[] preorder, int pleft, int pright, HashMap<Integer, Integer> inorderMap, int ileft, int iright) {
		if(pleft > pright) {
			return null;
		}
//		根结点在中序遍历中的坐标
		int rootInIdx = inorderMap.get(preorder[pleft]);
//		存储根结点
		TreeNode root = new TreeNode(preorder[pleft]);
//		左子树节点数，中序遍历左坐标到根节点坐标差
		int lenOfLeft = rootInIdx-ileft;
		root.left = buildRecur(preorder, pleft+1, pleft+lenOfLeft, inorderMap, ileft, rootInIdx-1);
		root.right = buildRecur(preorder, pleft+lenOfLeft+1, pright, inorderMap, rootInIdx+1, iright);
		return root;
	}
}
