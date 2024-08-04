package hard.to100;

import java.util.HashSet;

public class Solution41 {

	/**
	 * v3.0
	 * 原地置换
	 * 将num[i]元素换到i+1位置，直到i位置的元素为i+1
	 * 注意：需要加nums[nums[i]-1]!=nums[i]，防止只有重复数的数组
	 * @param nums
	 * @return
	 */
	public int firstMissingPositive(int[] nums) {
		int n = nums.length;
		for(int i=0; i<n; i++) {
			while(nums[i]!=i+1 && nums[i]>0 && nums[i]<n && nums[nums[i]-1]!=nums[i]) {
				int temp = nums[nums[i]-1];
				nums[nums[i]-1] = nums[i];
				nums[i] = temp;
			}
		}
		for(int i=0; i<n; i++) {
			if(nums[i]!=i+1) {
				return i+1;
			}
		}
		return n+1;
	}
	
	/**
	 * v2.0
	 * 集合，从小到大遍历
	 * 未达到要求：常数级别空间
	 * @param nums
	 * @return
	 */
	public int firstMissingPositive2(int[] nums) {
		int n = nums.length;
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=0; i<n; i++) {
			set.add(nums[i]);
		}
		for(int i=1; i<=n; i++) {
			if(!set.contains(i)) {
				return i;
			}
		}
		return n+1;
	}
	
	/**
	 * v1.0
	 * fail，超出时间限制
	 * 反复扫描
	 * @param nums
	 * @return
	 */
	public int firstMissingPositive1(int[] nums) {
		int n = nums.length;
		int min = 1;
		int left = 0, right = n-1;
		for(int i=0; i<n; i++){
			while(left<n) {
				if(nums[left] == min) {
					min += 1;
					right = left-1;
				}
				left++;
			}
			if(left==n && right==-1) {
				return min;
			}
			while(right>=0) {
				if(nums[right] == min) {
					min += 1;
					left = right+1;
				}
				right--;
			}
			if(left==n && right==-1) {
				return min;
			}
		}
		return n+1;
	}
	public static void main(String[] args) {
		
	}
}
