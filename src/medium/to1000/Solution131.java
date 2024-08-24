package medium.to1000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution131 {

	/**
	 * v1.0
	 * 动态规划预处理，回溯
	 * @param s
	 * @return
	 */
	public List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<>();
		List<String> part = new ArrayList<>();
		int len = s.length();
//		动态规划dp，dp[i][j]记录字符串s[i,j]是否为回文串
		boolean[][] dp = new boolean[len][len];
//		初始化dp为true
		for(int i=0; i<len; i++) {
			Arrays.fill(dp[i], true);
		}
//		逆序设置，dp[i][j]为true当且仅当字符i==字符j且内部的字符串也是回文串
		for(int i=len-1; i>=0; i--) {
			for(int j=i+1; j<len; j++) {
				dp[i][j] = (s.charAt(i)==s.charAt(j))
						&& dp[i+1][j-1];
			}
		}
//		深搜dfs
		dfs(s, 0, dp, res, part);
		return res;
	}
	public void dfs(String s, int start, boolean[][] dp, List<List<String>> res, List<String> part) {
		int len = s.length();
//		当开始坐标==字符串长度，说明前面都是回文串，且已扫描全部字符，则加入res，跳出深搜
		if(start==len) {
			res.add(new ArrayList<>(part));
			return;
		}
//		从start开始深搜，若dp[start][i]为true，说明字符串s[start,i]为回文串
		for(int i=start; i<len; i++) {
			if(dp[start][i]) {
				part.add(s.substring(start, i+1));
				dfs(s, i+1, dp, res, part);
				part.remove(part.size()-1);
			}
		}
	}
}
