package easy.to1000;

import structure.TreeNode;

public class Solution108 {

	/**
	 * v1.0
	 * 二分查找，递归，中序遍历
	 * @param nums
	 * @return
	 */
    public TreeNode sortedArrayToBST(int[] nums) {
    	return createTree(nums, 0, nums.length-1);
    }
    public TreeNode createTree(int[] nums, int left, int right) {
    	if(left>right) {
    		return null;
    	}
    	int mid = (left+right)>>>1;
    	TreeNode res = new TreeNode(nums[mid]);
    	res.left = createTree(nums, left, mid-1);
    	res.right = createTree(nums, mid+1, right);
    	return res;
    }
}
