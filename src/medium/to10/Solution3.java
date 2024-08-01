package medium.to10;

import java.util.HashMap;

public class Solution3 {

	public int lengthOfLongestSubstring(String s) {
		int len = s.length();
		int left=0, right=0;
		int max=0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		while(right<len) {
			char c = s.charAt(right);
			if(map.containsKey(c)) {
				left = Math.max(map.get(c)+1, left);
			}
			map.put(c, right);
			max = Math.max(max, right-left+1);
			right++;
		}
		return max;
	}
	
	public static void main(String[] args) {
		String s = "abba";
		int res = new Solution3().lengthOfLongestSubstring(s);
		System.out.println(res);
	}
}
