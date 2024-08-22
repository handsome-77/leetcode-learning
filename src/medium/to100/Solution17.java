package medium.to100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution17 {

	public static final Map<Character, Character[]> MAP;
	static {
		MAP=new HashMap<>();
		MAP.put('2', new Character[]{'a','b','c'});
        MAP.put('3', new Character[]{'d','e','f'});
        MAP.put('4', new Character[]{'g','h','i'});
        MAP.put('5', new Character[]{'j','k','l'});
        MAP.put('6', new Character[]{'m','n','o'});
        MAP.put('7', new Character[]{'p','q','r', 's'});
        MAP.put('8', new Character[]{'t','u','v'});
        MAP.put('9', new Character[]{'w','x','y','z'});
	}
	/**
	 * v1.0
	 * 哈希表，回溯
	 * @param digits
	 * @return
	 */
	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<>();
		int len = digits.length();
		if(len==0) {
			return res;
		}
		backtrack(digits, len, 0, res, new StringBuilder());
		return res;
	}
	public void backtrack(String digits, int len, int depth,
			List<String> res, StringBuilder builder) {
		if(depth==len) {
			res.add(builder.toString());
			return;
		}
		char digit = digits.charAt(depth);
		Character[] letters = MAP.get(digit);
		for(int i=0; i<letters.length; i++) {
			builder.append(letters[i]);
			backtrack(digits, len, depth+1, res, builder);
			builder.deleteCharAt(builder.length()-1);
		}
	}
}
