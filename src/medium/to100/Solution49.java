package medium.to100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 哈希表
 */

public class Solution49 {

	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();
		for(String str: strs) {
			char[] strChars = str.toCharArray();
			Arrays.sort(strChars);
			String strSorted = new String(strChars);
			List<String> value = map.getOrDefault(strSorted, new ArrayList<String>());
			value.add(str);
			map.put(strSorted, value);
//			if(!map.containsKey(strSorted)) {
//				List<String> strPut = new ArrayList<String>();
//				strPut.add(str);
//				map.put(strSorted, strPut);
//			}else {
//				List<String> strPut = map.get(strSorted);
//				strPut.add(str);
//				map.put(strSorted, strPut);
//			}
		}
//		List<List<String>> res = new ArrayList<List<String>>();
//		map.forEach((key,value) -> {
//			res.add(value);
//		});
//		return res;
		return new ArrayList<List<String>>(map.values());
	}
	
	public static void main(String[] args) {
		
	}
}
