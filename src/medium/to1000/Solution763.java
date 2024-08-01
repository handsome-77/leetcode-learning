package medium.to1000;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution763 {
	
	/**
	 * v3.0
	 * 用一个Map记录字母最后出现的位置
	 */
	public List<Integer> partitionLabels(String s) {
		List<Integer> res = new ArrayList<Integer>();
		int len = s.length();
		
		Map<Character, Integer> last = new HashMap<Character, Integer>();
		
		for(int i=len-1; i>=0; i--) {
			char temp = s.charAt(i);
			if(!last.containsKey(temp)) {
				last.put(temp, i);
			}
		}
		int start = 0, end = 0;
		for(int i=0; i<len; i++) {
			end = Math.max(end, last.get(s.charAt(i)));
			if(i==end) {
				res.add(end-start+1);
				start = end+1;
			}
		}
		
		return res;
	}
	
	/**
	 * v2.0
	 * 用一个Map记录字母最后出现的位置，用start和end优化一个循环，实际与不优化代码的时间复杂度一样。
	 */
	public List<Integer> partitionLabels2(String s) {
		List<Integer> res = new ArrayList<Integer>();
		int len = s.length();
		
		Map<Character, Integer> last = new HashMap<Character, Integer>();
		
		for(int i=len-1; i>=0; i--) {
			char temp = s.charAt(i);
			if(!last.containsKey(temp)) {
				last.put(temp, i);
			}
		}
		for(int i=0; i<len; i++) {
			char temp = s.charAt(i);
			int lastLoc = last.get(temp);
			for(int j=i; j<lastLoc; j++) {
				if(lastLoc<last.get(s.charAt(j))) {
					lastLoc = last.get(s.charAt(j));
				}
			}
			res.add(lastLoc-i+1);
			i=lastLoc;
		}
		
		return res;
	}
	
	/**
	 * v1.0
	 * 用两个Map记录字母最后出现的位置和最先出现的位置
	 */
	public List<Integer> partitionLabels1(String s) {
		List<Integer> res = new ArrayList<Integer>();
		int len = s.length();
		
		Map<Character, Integer> last = new HashMap<>();
		Map<Character, Integer> first = new HashMap<>();
		
		for(int i=0; i<len; i++) {
			last.put(s.charAt(i), i);
		}
		
		for(int i=len-1; i>=0; i--) {
			first.put(s.charAt(i), i);
		}
		
		
		for(int i=0; i<len; i++) {
			int lastLoc = last.get(s.charAt(i));
			for(int j=i+1; j<len; j++) {
				if(lastLoc>first.get(s.charAt(j)) && lastLoc<last.get(s.charAt(j))) {
					lastLoc = last.get(s.charAt(j));
				}
			}
			res.add(lastLoc-i+1);
			i = lastLoc;
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		String s = "eccbbbbdec";
		List<Integer> res = new Solution763().partitionLabels(s);
		System.out.println(res);
	}

}
