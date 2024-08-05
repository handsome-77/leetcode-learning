package medium.to100;

public class Solution73 {

	/**
	 * v3.0
	 * 空间：O(1)，达到要求
	 * 优化v2.0，仅用一个标记
	 * 倒序遍历
	 * @param matrix
	 */
	public void setZeroes(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		boolean column0 = false;
		for(int i=0; i<m; i++) {
			if(matrix[i][0] == 0) {
				column0 = true;
			}
			for(int j=1; j<n; j++) {
				if(matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
//		防止提前更新，倒序遍历
		for(int i=m-1; i>=0; i--) {
			for(int j=1; j<n; j++) {
				if(matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
			if(column0) {
				matrix[i][0] = 0;
			}
		}
		
	}
	
	/**
	 * v2.0
	 * 空间：O(1)，达到要求
	 * 用matrix的每行或者每列的第0个元素作标记
	 * 单独处理第0行和第0列
	 * @param matrix
	 */
	public void setZeroes2(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		boolean row0 = false;
		boolean column0 = false;
//		标记第0列是否本来就包含0
		for(int i=0; i<m; i++) {
			if(matrix[i][0] == 0) {
				column0 = true;
			}	
		}
//		标记第0行是否本来就包含0
		for(int j=0; j<n; j++) {
			if(matrix[0][j] == 0) {
				row0 = true;
			}
		}
//		从第1行、第1列开始遍历，若有0，则标记对应的行或者列的第一个元素为0
		for(int i=1; i<m; i++) {
			for(int j=1; j<n; j++) {
				if(matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
//		从第1行、第1列开始遍历，判断对应的行或者列的第一个元素是否包含0，若包含0，则该元素为0
		for(int i=1; i<m; i++) {
			for(int j=1; j<n; j++) {
				if(matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}
//		单独处理第0行
		if(row0) {
			for(int j=0; j<n; j++) {
				matrix[0][j] = 0;
			}
		}
//		单独处理第0列
		if(column0) {
			for(int i=0; i<m; i++) {
				matrix[i][0] = 0;
			}
		}
	}
	
	/**
	 * v1.0
	 * 空间：O(m+n)，没达到要求
	 * 利用两个boolean数组，row和column
	 * 遍历matrix，遍历到0，标记对应的row和column为true
	 * @param matrix
	 */
	public void setZeroes1(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		boolean[] row = new boolean[m];
		boolean[] column = new boolean[n];
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(matrix[i][j] == 0) {
					row[i] = true;
					column[j] = true;
				}
			}
		}
		for(int i=0; i<m; i++) {
			if(row[i]) {
				for(int j=0; j<n; j++) {
					matrix[i][j] = 0;
				}
			}
		}
		for(int j=0; j<n; j++) {
			if(column[j]) {
				for(int i=0; i<m; i++) {
					matrix[i][j] = 0;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
	}
}
