package hard.to100;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution76 {

	/**
	 * v1.0
	 * 滑动窗口，哈希表
	 * 哈希表记录字符在t中出现的次数，key为字符，value为出现的次数
	 * @param s
	 * @param t
	 * @return
	 */
	public String minWindow(String s, String t) {
		int slen = s.length();
		int tlen = t.length();
		if(tlen>slen) {
			return "";
		}
		HashMap<Character, Integer> tNumInWindow = new HashMap<Character, Integer>();
		for(int i=0; i<tlen; i++) {
			char tChar = t.charAt(i);
			tNumInWindow.put(tChar, tNumInWindow.getOrDefault(tChar, 0)+1);
		}
		int left=0, right=0;
		int min = slen;
		String res = "";
		while(right<slen) {
			char sRightChar = s.charAt(right);
			if(!tNumInWindow.containsKey(sRightChar)) {
				right++;
				continue;
			}
			tNumInWindow.put(sRightChar, tNumInWindow.get(sRightChar)-1);
			while(isAllZero(tNumInWindow) && left<=right) {
				int lenTemp = right-left+1;
				if(lenTemp<=min) {
					min = lenTemp;
					res = s.substring(left, right+1);
				}
				char sLeftChar = s.charAt(left);
				if(tNumInWindow.containsKey(sLeftChar)) {
					tNumInWindow.put(sLeftChar, tNumInWindow.get(sLeftChar)+1);
				}
				left++;
			}
			right++;
			int lenTemp = right-left+1;
			if(lenTemp<=min && isAllZero(tNumInWindow)) {
				min = lenTemp;
				res = s.substring(left-1, right);
			}
		}
		return res;
	}
	
	public boolean isAllZero(HashMap<Character, Integer> map) {
		Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();
		while(iterator.hasNext()) {
			if(iterator.next().getValue()>0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		String s = "abc";
		String t = "cba";
		String res = new Solution76().minWindow(s, t);
		System.out.println(res);
	}
}
