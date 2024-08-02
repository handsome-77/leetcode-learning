package hard.to1000;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution239 {

	/**
	 * v3.0
	 * 双端队列，队头为当前窗口的最大值
	 * 当进入下一个窗口时，把小于当前值的移出队列
	 * @param nums
	 * @param k
	 * @return
	 */
	public int[] maxSlidingWindow(int[] nums, int k) {
		int len = nums.length;
		int[] res = new int[len-k+1];
//		双端队列
		Deque<Integer> queue = new LinkedList<Integer>();
//		非窗口-》窗口
		for(int i=0; i<k; i++) {
//			队列中小于当前num的值，从队尾移除，队头为当前非窗口的最大值
			while(!queue.isEmpty() && queue.peekLast()<nums[i]) {
				queue.pollLast();
			}
//			队列加当前num到队尾
			queue.offer(nums[i]);
		}
//		第一个窗口的最大值
		res[0] = queue.peek();
//		找每个窗口的最大值
		for(int i=1; i<len-k+1; i++) {
//			队头，即队列最大值，为当前窗口外的值，移出队列
			if(queue.peek() == nums[i-1]) {
				queue.poll();
			}
//			队列中小于当前num的值，从队尾移除，队头为当前窗口的最大值
			while(!queue.isEmpty() && queue.peekLast()<nums[i+k-1]) {
				queue.pollLast();
			}
//			队列加当前num到队尾
			queue.offer(nums[i+k-1]);
//			队头是当前窗口的最大值
			res[i] = queue.peek();
		}
		return res;
	}
	
	
	/**
	 * v2.0
	 * 优先级队列，优化
	 * 剪枝，移除窗口中位于最大数左边的数
	 * @param nums
	 * @param k
	 * @return
	 */
	public int[] maxSlidingWindow2(int[] nums, int k) {
		int len = nums.length;
		int[] res = new int[len-k+1];
		Queue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return nums[o2]-nums[o1];
			}
		});
		int left = 0, right = 0;
		while(right<k) {
			queue.offer(right++);
		}
		while(left<len-k+1) {
			res[left] = nums[queue.peek()];
			if(right == len) {
				break;
			}
			queue.offer(right++);
			while(queue.peek()<right-k) {
				queue.poll();
			}
			left++;
		}
		return res;
	}
	
	/**
	 * v1.0
	 * fail
	 * 优先级队列
	 * @param nums
	 * @param k
	 * @return
	 */
	public int[] maxSlidingWindow1(int[] nums, int k) {
		int len = nums.length;
		int[] res = new int[len-k+1];
		Queue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		int left = 0, right = 0;
		while(right<k) {
			queue.offer(nums[right++]);
		}
		while(left<len-k+1) {
			res[left] = queue.peek();
			if(right == len) {
				break;
			}
			queue.remove(nums[left++]);
			queue.offer(nums[right++]);
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,3,-1,-3,5,3,6,7};
		int k = 3;
		int[] res = new Solution239().maxSlidingWindow(nums, k);
		for(int num:res) {
			System.out.print(num+",");
		}
	}
}
