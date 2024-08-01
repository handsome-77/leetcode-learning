package medium.to10000;

/**

 */

public class Solution1143 {

	/**
	 * 动态规划，二维
	 * dp[i][j]表示s1中0~i和s2中0~j字符串最长序列的长度
	 * dp[i][j] = dp[i-1][j-1] + 1, if s1[i]==s2[j]
	 * dp[i][j] = max(dp[i][j-1], dp[i-1][j]), otherwise
	 * @param text1
	 * @param text2
	 * @return
	 */
	public int longestCommonSubsequence(String text1, String text2) {
		int len1 = text1.length();
		int len2 = text2.length();
		
		int[][] dp = new int[len1+1][len2+1];
		
		for(int i=1; i<len1+1; i++) {
			for(int j=1; j<len2+1; j++) {
				if(text1.charAt(i-1) == text2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1]+1;
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		return dp[len1][len2];
	}
	
	public static void main(String[] args) {
		String text1 = "abcde";
		String text2 = "ace";
		int res = new Solution1143().longestCommonSubsequence(text1, text2);
		System.out.println(res);
	}
}
