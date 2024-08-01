package medium.to100;

/**
 * 双指针，短板原理
 */

public class Solution11 {

	public int maxArea(int[] height) {
		int len = height.length;
		int left = 0, right = len-1;
		int max = 0;
		while(left<right) {
			int square = 0;
			if(height[left]<height[right]) {
				square = height[left]*(right-left);
				left++;
			}else {
				square = height[right]*(right-left);
				right--;
			}
			max = Math.max(max, square);
		}
		return max;
	}
	
	public static void main(String[] args) {
		
	}
}
