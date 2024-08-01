package medium.to100;

import java.util.ArrayList;
import java.util.List;

public class Solution22 {

	public List<String> generateParenthesis(int n){
		List<String> res = new ArrayList<String>();
		backtrack(res, new StringBuilder(), 0, 0, n);
		return res;
	}
	
	public void backtrack(List<String> res, StringBuilder sb, int left, int right, int n) {
		if(sb.length() == n*2) {
			res.add(sb.toString());
			return;
		}
		
		if(left<n) {
			sb.append("(");
			backtrack(res, sb, left+1, right, n);
			sb.deleteCharAt(sb.length()-1);
		}
		
		if(right<left) {
			sb.append(")");
			backtrack(res, sb, left, right+1, n);
			sb.deleteCharAt(sb.length()-1);
		}
	}
	
	public static void main(String[] args) {
		Solution22 solution = new Solution22();
		int n = 3;
		List<String> res = solution.generateParenthesis(n);
		System.out.println(res);
	}
}
