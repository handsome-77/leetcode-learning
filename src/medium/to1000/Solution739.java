package medium.to1000;

import java.util.Arrays;
import java.util.Stack;

public class Solution739 {

	/**
	 * v3.0
	 * 单调栈
	 */
	public int[] dailyTemperatures(int[] temperatures) {
		int len = temperatures.length;
		int[] res = new int[len];
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		for(int i=1; i<len; i++) {
			while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]) {
				int pop = stack.pop();
				res[pop] = i-pop;
			}
			stack.push(i);
		}
		
		return res;
	}
	
	/**
	 * v2.0
	 * 逆向遍历
	 * 利用res数组直接跳转到下一个更大的数进行比较
	 */
	public int[] dailyTemperatures2(int[] temperatures) {
		int len = temperatures.length;
		int[] res = new int[len];
		
		for(int i=len-2; i>=0; i--) {
			int j=i+1;
			while(j<len && temperatures[j]<=temperatures[i] && res[j]!=0) {
				j+=res[j];
			}
			if(j<len && temperatures[j] > temperatures[i]) {
				res[i] = j-i;
			}
		}
		return res;
	}
	
	/**
	 * v1.1
	 * fail
	 * 暴力解法，超时
	 */
	public int[] dailyTemperatures11(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        int[] next = new int[101];
        Arrays.fill(next, Integer.MAX_VALUE);
        for (int i = length - 1; i >= 0; --i) {
            int warmerIndex = Integer.MAX_VALUE;
            for (int t = temperatures[i] + 1; t <= 100; ++t) {
                if (next[t] < warmerIndex) {
                    warmerIndex = next[t];
                }
            }
            if (warmerIndex < Integer.MAX_VALUE) {
                ans[i] = warmerIndex - i;
            }
            next[temperatures[i]] = i;
        }
        return ans;
    }
	
	/**
	 * v1.0
	 * fail
	 * 暴力解法，超时
	 */
	public int[] dailyTemperatures1(int[] temperatures) {
		int len = temperatures.length;
		int[] res = new int[len];
		for(int i=0; i<len; i++) {
			int temp = temperatures[i];
			int j=i+1;
			while(j<len) {
				if(temperatures[j]>temp) {
					break;
				}
				j++;
			}
			if(j!=len) {
				res[i] = j-i;
			}
		}
		return res;
	}

	
	public static void main(String[] args) {
		int[] temperatures = {30,60,90};
		int[] res = new Solution739().dailyTemperatures(temperatures);
		for(int i=0; i<res.length; i++) {
			System.out.print(res[i]);
		}
	}
}
