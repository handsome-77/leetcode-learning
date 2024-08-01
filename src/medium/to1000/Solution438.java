package medium.to1000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution438 {

	/**
	 * v2.0
	 * 滑动窗口，维护字母数
	 * @param s
	 * @param p
	 * @return
	 */
	public List<Integer> findAnagrams(String s, String p) {
		int slen = s.length();
		int plen = p.length();		
		List<Integer> res = new ArrayList<Integer>();
		if(slen < plen) {
			return res;
		}
		int[] pcount = new int[26];
		int[] scount = new int[26];
		for(int i=0; i<plen; i++) {
			pcount[p.charAt(i)-'a'] += 1;
		}

		int left=0, right=0;
		while(right < slen) {
			scount[s.charAt(right)-'a'] += 1;
			right++;
			if(right-left < plen) {
				continue;
			}
			if(Arrays.equals(scount, pcount)) {
				res.add(left);
			}
			scount[s.charAt(left)-'a'] -= 1;
			left++;
		}
		return res;
	}
	
	/**
	 * v1.0
	 * 暴力解法，排序
	 * @param s
	 * @param p
	 * @return
	 */
	public List<Integer> findAnagrams1(String s, String p) {
		int slen = s.length();
		int plen = p.length();
		List<Integer> res = new ArrayList<Integer>();
		
		String pSorted = sort(p);
		for(int i=0; i<slen-plen+1; i++) {
			String sTempSorted = sort(s.substring(i, i+plen));
			if(sTempSorted.equals(pSorted)) {
				res.add(i);
			}
		}
		return res;
	}
	
	public String sort(String s) {
		char[] charArrays = s.toCharArray();
		Arrays.sort(charArrays);
		return new String(charArrays); 
	}
	
	public static void main(String[] args) {
		String s = "abab";
		String p = "ab";
		List<Integer> res = new Solution438().findAnagrams(s, p);
		System.out.println(res);
	}
}
