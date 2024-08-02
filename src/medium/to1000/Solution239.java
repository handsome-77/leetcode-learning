package medium.to1000;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution239 {

	/**
	 * v2.0
	 * 优先级队列，优化
	 * 剪枝，移除窗口中的较小数
	 * @param nums
	 * @param k
	 * @return
	 */
	public int[] maxSlidingWindow(int[] nums, int k) {
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
