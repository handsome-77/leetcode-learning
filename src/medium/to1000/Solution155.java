package medium.to1000;

import java.util.LinkedList;

/**
 * 用链表实现栈，辅助栈存储最小元素
 */

public class Solution155 {

	public class MinStack{
		
		LinkedList<Integer> stack;
		LinkedList<Integer> stackMin;
		
		public MinStack() {
			stack = new LinkedList<Integer>();
			stackMin = new LinkedList<Integer>();
		}
		
		public void push(int val) {
			stack.add(val);
			if(stackMin.isEmpty()) {
				stackMin.add(val);
				return;
			}
			int min = stackMin.getLast();
			if(min>val) {
				stackMin.add(val);
			}else {
				stackMin.add(min);
			}
	    }
		
	    public void pop() {
	    	stack.removeLast();
	    	stackMin.removeLast();
	    }
	    
	    public int top() {
	    	return stack.getLast();
	    }
	    
	    public int getMin() {
	    	return stackMin.getLast();
	    }
	}
	
	public static void main(String[] args) {
		MinStack stack = new Solution155().new MinStack();
		stack.push(-2);
		stack.push(0);
		stack.push(-3);
		stack.getMin();
		stack.pop();
		stack.top();
		stack.getMin();

	}

}
