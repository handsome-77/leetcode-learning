package medium.to100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution56 {

	/**
	 * v1.0
	 * 左端点排序，记录每组合并后的区间的start和end
	 * @param intervals
	 * @return
	 */
	public int[][] merge(int[][] intervals) {
		int n = intervals.length;
		List<int[]> res = new ArrayList<int[]>();
		Arrays.sort(intervals, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
		});
		int start = intervals[0][0];
		int end = intervals[0][1];
		for(int i=1; i<n; i++) {
			if(intervals[i][0] > end) {
				res.add(new int[] {start, end});
				start = intervals[i][0];
				end = intervals[i][1];
			}else {
				start = Math.min(start, intervals[i][0]);
				end = Math.max(end, intervals[i][1]);
			}
		}
		res.add(new int[] {start, end});
		return res.toArray(new int[0][]);
	}
	
	public static void main(String[] args) {
		int[][] intervals = {
				{1,4},
				{0,0}

		};
		int[][] res = new Solution56().merge(intervals);
		for(int i=0; i<res.length; i++) {
			System.out.print(res[i][0]+",");
			System.out.println(res[i][1]);
		}
	}
}
