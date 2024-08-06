package medium.to1000;

public class Solution240 {
	
	/**
	 * v1.0
	 * 逆向搜索，向左减小，向下增大
	 * @param matrix
	 * @param target
	 * @return
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length;
		int n = matrix[0].length;
		int i=0,j=n-1;
		while(i<m && j>=0) {
			if(matrix[i][j] == target) {
				return true;
			}
			if(matrix[i][j] > target) {
				j--;
			}else {
				i++;
			}
		}
		return false;
	}
}
