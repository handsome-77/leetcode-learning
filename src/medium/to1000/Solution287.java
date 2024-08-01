package medium.to1000;

public class Solution287 {

	/**
	 * v3.0
	 * 快慢指针，环
	 */
	public int findDuplicate(int[] nums) {
		int slow = 0;
		int fast = 0;
		slow = nums[slow];
		fast = nums[nums[fast]];
		while(slow != fast) {
			slow = nums[slow];
			fast = nums[nums[fast]];
		}
		fast = 0;
		while(slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}
		return slow;
	}
	
	/**
	 * v2.0
	 * 位运算
	 * 规则：不加重复数时，第i位的1总和为x；加重复数时，第i位的1总和为y。若第i位的y>x，则重复数的第i位为1。
	 */
	public int findDuplicate2(int[] nums) {
		int n = nums.length;
		int res = 0;
		int bitNum = 31;
		while(((n-1)>>bitNum & 1) == 1) {
			bitNum--;
		}
		
		for(int i=0; i<bitNum; i++) {
			int sum1 = 0;
			for(int j=1; j<=n-1; j++) {
				if(((j >> i) & 1) == 1) {
					sum1++;
				}
			}
			int sum2 = 0;
			for(int j=0; j<n; j++) {
				if(((nums[j] >> i) & 1) == 1) {
					sum2++;
				}
			}
			if(sum2 > sum1) {
				res |= 1 << i;
			}
		}
		
		return res;
	}
	
	/**
	 * v1.0
	 * 排序，遍历查重
	 */
	public int findDuplicate1(int[] nums) {
		
		int temp = nums[0];
		int res = -1;
		for(int i=1; i<nums.length; i++) {
			temp ^= nums[i];
			if(temp==0) {
				res = nums[i];
				break;
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,3,4,2,2};
		int res = new Solution287().findDuplicate(nums);
		System.out.println(res);
	}

}
