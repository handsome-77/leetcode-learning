package hard.to10;

public class Solution4 {
	
	/**
	 * v3.0
	 * @param nums1
	 * @param nums2
	 * @return
	 */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	int len1=nums1.length;
    	int len2=nums2.length;
    	int left = (len1+len2+1)/2;
    	int right = (len1+len2+2)/2;
    	
    	return (getKth(nums1, 0, len1-1, nums2, 0, len2-1, left)
    			+getKth(nums1, 0, len1-1, nums2, 0, len2-1, right))*0.5;
    }
    public int getKth(int[] nums1, int s1, int e1, int[] nums2, int s2, int e2, int k) {
    	int len1 = e1-s1+1;
    	int len2 = e2-s2+1;
    	
    	if(len1>len2) {
    		return getKth(nums2, s2, e2, nums1, s1, e1, k);
    	}
    	
    	if(len1==0) {
    		return nums2[s2+k-1];
    	}
    	
    	if(k==1) {
    		return Math.min(nums1[s1], nums2[s2]);
    	}
    	
    	int i = s1+Math.min(len1, k/2)-1;
    	int j = s2+Math.min(len2, k/2)-1;
    	
    	if(nums1[i]<nums2[j]) {
    		return getKth(nums1, i+1, e1, nums2, s2, e2, k-(i-s1+1));
    	}else {
    		return getKth(nums1, s1, e1, nums2, j+1, e2, k-(j-s2+1));
    	}
    	
    }
	
    /**
     * v2.0
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
    	int len1=nums1.length;
    	int len2=nums2.length;
    	int len=len1+len2;
    	
    	int[] nums = new int[len];
    	
    	boolean isOdd = true;
    	int midIdx = len/2;
    	if(len%2==0) {
    		isOdd = false;
    	}
    	
    	int i=0,j=0,k=0;
    	while(k<=midIdx && i<len1 && j<len2) {
    		if(nums1[i]<nums2[j]) {
    			nums[k++] = nums1[i++];
    		}else {
				nums[k++] = nums2[j++];
			}
    	}
    	while(k<=midIdx && i<len1) {
    		nums[k++] = nums1[i++];
    	}
    	while (k<=midIdx && j<len2) {
			nums[k++] = nums2[j++];
		}
    	if(isOdd) {
    		return nums[midIdx];
    	}
    	return ((double)nums[midIdx]+nums[midIdx-1])/2;
    	
    }
	
    /**
     * v1.0
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1+len2;
        
        int[] nums = new int[len1+len2];
        int i=0,j=0,k=0;
        while(true){
            if(i==len1 || j==len2){
                break;
            }
            if(nums1[i]<nums2[j]){
                nums[k++]=nums1[i++];
            }else{
                nums[k++]=nums2[j++];
            }
        }
        while(i<len1){
            nums[k++]=nums1[i++];
        }
        while(j<len2){
            nums[k++]=nums2[j++];
        }
        if(len%2!=0){
            return nums[len/2];
        }
        return ((double)nums[len/2-1]+(double)nums[len/2])/2;
    }
    
    public static void main(String[] args) {
    	int[] nums1 = {1,2};
    	int[] nums2 = {3,4};
    	new Solution4().findMedianSortedArrays(nums1, nums2);
    }
}
