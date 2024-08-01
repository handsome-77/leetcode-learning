package medium.to1000;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 动态规划
 * dp[i] 表示 s[0,i-1]是否为true
 * 判断dp[i]是否为true，可以对s[0,i-1]分割成s[0,j-1]和s[j,i-1]，并判断对应的dp是否为true
 * dp[i] = dp[j] && check(s[j,i-1])
 */

public class Solution139 {
	
	public boolean wordBreak(String s, List<String> wordDict) {
		HashSet<String> wordDictSet = new HashSet<String>(wordDict);
		int len = s.length();
		boolean[] dp = new boolean[len+1];
		dp[0] = true;
		for(int i=1; i<=len; i++) {
			for(int j=0; j<i; j++) {
				if(dp[j] && wordDictSet.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[len];
	}
	
	public static void main(String[] args) {
		String s = "leetcode";
		String[] wordStrings = {"leet","code"}; 
		List<String> wordDict = Arrays.asList(wordStrings);
		boolean res = new Solution139().wordBreak(s, wordDict);
		System.out.println(res);
	}
}
