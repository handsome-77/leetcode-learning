package easy.to1000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution118 {

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res = new ArrayList<>();
		Integer[][] dp = new Integer[numRows][];
		for(int i=0; i<numRows; i++) {
			dp[i] = new Integer[i+1];
			dp[i][0] = 1;
			dp[i][i] = 1;
			for(int j=1; j<i; j++) {
				dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
			}
			res.add(Arrays.asList(dp[i]));
		}
		return res;
	}
	
	public static void main(String[] args) {
		int numRows = 1;
		List<List<Integer>> res = new Solution118().generate(numRows);
		System.out.println(res);
	}

}
