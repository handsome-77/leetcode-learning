package hard.to100;

import java.util.LinkedList;

public class Solution32 {

	/**
	 * v3.0
	 * 贪心，正向遍历+逆向遍历
	 */
	public int longestValidParentheses(String s) {
		int len = s.length();
		if(len<2) {
			return 0;
		}
		
		int max = 0;
		int left = 0;
		int right = 0;
		for(int i=0; i<len; i++) {
			if(s.charAt(i) == '(') {
				left++;
			}
			if(s.charAt(i) == ')') {
				right++;
			}
			if(left == right) {
				max = Math.max(max, left+right);
			}
			if(right > left) {
				left = 0;
				right = 0;
			}
		}
		
		left=0;
		right=0;
		
		for(int i=len-1; i>=0; i--) {
			if(s.charAt(i) == '(') {
				left++;
			}
			if(s.charAt(i) == ')') {
				right++;
			}
			if(left == right) {
				max = Math.max(max, left+right);
			}
			if(left > right) {
				left = 0;
				right = 0;
			}
		}
		return max;
	}
	
	/**
	 * v2.0
	 * 动态规划
	 * 初始化dp=0，且dp[i]=0 (s[i]='(')，接着分情况讨论：
	 * 若s[i]=')'，且s[i-1]='('，即“()”，则dp[i]=dp[i-2]+2
	 * 若s[i]=')'，且s[i-1]=')'，即“))”，且s[i-dp[i-1]-1]='('，则dp[i]=dp[i-1]+dp[i-dp[i-1]-2]+2
	 */
	public int longestValidParentheses2(String s) {
		int len = s.length();
		if(len<2) {
			return 0;
		}
		
		int max = 0;
		int[] dp = new int[len];
		for(int i=1; i<len; i++) {
			if(s.charAt(i) == ')') {
				if(s.charAt(i-1) == '(') {
					if(i<2) {
						dp[i] = 0 + 2;
					}else {
						dp[i] = dp[i-2] + 2;
					}
				}else {
					if(i-dp[i-1]>0 && s.charAt(i-dp[i-1]-1) == '(') {
						if(i-dp[i-1]<2) {
							dp[i] = dp[i-1] + 0 + 2;
						}else {
							dp[i] = dp[i-1] + dp[i-dp[i-1]-2] + 2;
						}
					}
				}
			}
			max = Math.max(max, dp[i]);
		}
		return max;
	}
	
	/**
	 * v1.0
	 * 栈
	 * 栈存下标
	 * 栈底存最后一个没有匹配的有括号下标
	 */
	public int longestValidParentheses1(String s) {
		int len = s.length();
		if(len<2) {
			return 0;
		}
		
		LinkedList<Integer> stack = new LinkedList<Integer>();
		stack.push(-1);
		int max = 0;
		
		for(int i=0; i<len; i++) {
			char c = s.charAt(i);
			if(c == '(') {
				stack.push(i);
			}else {
				stack.pop();
				if(!stack.isEmpty()) {
					max = Math.max(max, i-stack.peek());
				}else {
					stack.push(i);
				}
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		String s = ")))";
		int res = new Solution32().longestValidParentheses(s);
		System.out.println(res);
	}
}
