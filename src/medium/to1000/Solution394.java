package medium.to1000;

import java.util.LinkedList;

public class Solution394 {

	/**
	 * v2.0
	 * 栈，用LinkedList<String>
	 */
	public String decodeString(String s) {
		int len = s.length();
		LinkedList<String> stack = new LinkedList<String>();
		for (int i = 0; i < len; i++) {
			String c = s.substring(i, i+1);
			if(!c.equals("]")) {
				stack.push(c);
				continue;

			}
			
			StringBuilder sb = new StringBuilder();
			while(!stack.isEmpty() && !stack.peek().equals("[") && !Character.isDigit(stack.peek().charAt(0))) {
				sb.insert(0, stack.pop());
			}
			stack.pop();
			
			StringBuilder numStr = new StringBuilder();
			while(!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
				numStr.insert(0, stack.pop());
			}
			int num = Integer.valueOf(numStr.toString());
			while(num-->0) {
				for(int j=0; j<sb.length(); j++) {
					stack.push(sb.substring(j,j+1));
				}
			}
		}
		
		StringBuilder res = new StringBuilder();
		while(!stack.isEmpty()) {
			res.insert(0, stack.pop());
		}
		return res.toString();
	}
	
	/**
	 * v1.0
	 * 栈，用LinkedList<Character>替换Stack<Character>（Stack在官方不推荐使用）
	 */
	public String decodeString1(String s) {
		int len = s.length();
//		Stack<Character> stack = new Stack<Character>();
		LinkedList<Character> stack = new LinkedList<Character>();
		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			if(c != ']') {
				stack.push(c);
				continue;

			}
			
			StringBuilder sb = new StringBuilder();
			while(!stack.isEmpty() && !stack.peek().equals('[') && !Character.isDigit(stack.peek())) {
				sb.insert(0, stack.pop());
			}
			stack.pop();
			
			StringBuilder numStr = new StringBuilder();
			while(!stack.isEmpty() && Character.isDigit(stack.peek())) {
				numStr.insert(0, stack.pop());
			}
			int num = Integer.valueOf(numStr.toString());
			while(num-->0) {
				for(int j=0; j<sb.length(); j++) {
					stack.push(sb.charAt(j));
				}
			}
		}
		
		StringBuilder res = new StringBuilder();
		while(!stack.isEmpty()) {
			res.insert(0, stack.pop());
		}
		return res.toString();
	}
	
	public static void main(String[] args) {
		String s = "abc3[cd]xyz";
		String res = new Solution394().decodeString(s);
		System.out.println(res);
	}

}
