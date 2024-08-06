package medium.to100;

public class Solution48 {

	/**
	 * v1.0
	 * 水平翻转+主对角线翻转（转置）
	 * 位运算，交换
	 * @param matrix
	 */
	public void rotate(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		int midRow = m/2;
//		水平翻转
		for(int i=0; i<midRow; i++) {
			for(int j=0; j<n; j++) {
				matrix[i][j] ^= matrix[n-i-1][j];
				matrix[n-i-1][j] ^= matrix[i][j];
				matrix[i][j] ^= matrix[n-i-1][j];
			}
		}
//		主对角线翻转，即转置
		for(int i=0; i<m; i++) {
			for(int j=i+1; j<n; j++) {
				matrix[i][j] ^= matrix[j][i];
				matrix[j][i] ^= matrix[i][j];
				matrix[i][j] ^= matrix[j][i];
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		new Solution48().rotate(matrix);
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				System.out.print(matrix[i][j] + ",");
			}
			System.out.println();
		}
	}
}
