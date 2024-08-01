package medium.to100;

public class Solution45 {

    public int jump(int[] nums) {
    	int len = nums.length;
    	int count = 0;
    	int loc = 0;
    	while(loc<len-1) {
    		int maxMoveTo = loc+nums[loc];
    		if(maxMoveTo>=len-1) {
    			count++;
    			break;
    		}
    		int max = 0;
    		for (int i = loc+1; i <= maxMoveTo && i<len; i++) {
    			if(max<=i+nums[i] && maxMoveTo<i+nums[i]) {
    				max=i+nums[i];
    				loc=i;
    			}
			}
    		if(max==0) {
    			loc=maxMoveTo;
    		}
    		count++;
    	}
    	return count;
    }
    
	
	public static void main(String[] args) {
		int[] nums = {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};
		int count = new Solution45().jump(nums);
		System.out.println(count);
	}

}
