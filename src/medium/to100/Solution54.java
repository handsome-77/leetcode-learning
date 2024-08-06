package medium.to100;

import java.util.ArrayList;
import java.util.List;

public class Solution54 {

	/**
	 * v1.0
	 * 模拟，设置边界
	 * 注意回走判断， 避免重复
	 * @author hs
	 * @param matrix
	 * @return
	 */
	public List<Integer> spiralOrder(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		int left=0, right=n-1;
		int top=0, bottom=m-1;
		List<Integer> res = new ArrayList<Integer>();
		while(left<=right && top<=bottom) {
			for(int j=left; j<=right; j++) {
				res.add(matrix[top][j]);
			}
			for(int i=top+1; i<=bottom; i++) {
				res.add(matrix[i][right]);
			}
//			回走前判断
			if(left<right && top<bottom) {
				for(int j=right-1; j>=left; j--) {
					res.add(matrix[bottom][j]);
				}
				for(int i=bottom-1; i>top; i--) {
					res.add(matrix[i][left]);
				}
			}
			left++;
			right--;
			top++;
			bottom--;
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[][] matrix = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12}
		};
		List<Integer> res = new Solution54().spiralOrder(matrix);
		System.out.println(res);
	}
}
