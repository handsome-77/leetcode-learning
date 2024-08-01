package medium.to10;

/**
 * 动态规划，二维
 * dp[i][j] = dp[i+1][j-1] && s[i]==s[j]
 */
public class Solution5 {

	public String longestPalindrome(String s) {
		int len = s.length();
		int left=0, right=0, max=0;
		boolean[][] dp = new boolean[len][len];
		
		for(int i=len-1; i>=0; i--) {
			for(int j=i; j<len; j++) {
				if(s.charAt(i)==s.charAt(j) && (j-i<=1 || dp[i+1][j-1])) {
					dp[i][j]=true;
					if(j-i>max) {
						max=j-i;
						left=i;
						right=j;
					}
				}
			}
		}
		return s.substring(left, right+1);
	}
	
	public static void main(String[] args) {
		String s = "babad";
		String res = new Solution5().longestPalindrome(s);
		System.out.println(res);
	}
}
