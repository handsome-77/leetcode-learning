package medium.to1000;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution994 {

	/**
	 * 广度优先遍历，队列
	 * @param grid
	 * @return
	 */
	public int orangesRotting(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
//		队列，存储腐烂橘子的坐标（一维）
		Queue<Integer> queue = new LinkedList<Integer>();
//		数组，存储新鲜橘子的坐标（一维）
		List<Integer> listOfFresh = new ArrayList<Integer>();
		int res = 0;
//		初始化队列和数组
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(grid[i][j]==2) {
					queue.offer(i*n+j);
				}
				if(grid[i][j]==1) {
					listOfFresh.add(i*n+j);
				}
			}
		}
//		如果没有新鲜橘子，则直接返回0
		if(listOfFresh.isEmpty()) {
			return 0;
		}
//		遍历队列
		while(!queue.isEmpty()) {
			res++;
//			需要分次序弹出队列，即分层次
			int size = queue.size();
			while(size>0) {
				int temp = queue.poll();
				int row = temp/n;
				int column = temp%n;
				grid[row][column]=0;
				if(row+1<m && grid[row+1][column]==1) {
					grid[row+1][column]=2;
					queue.offer((row+1)*n+column);
					listOfFresh.remove(Integer.valueOf((row+1)*n+column));
				}
				if(row-1>=0 && grid[row-1][column]==1) {
					grid[row-1][column]=2;
					queue.offer((row-1)*n+column);
					listOfFresh.remove(Integer.valueOf((row-1)*n+column));
				}
				if(column+1<n && grid[row][column+1]==1) {
					grid[row][column+1]=2;
					queue.offer(row*n+(column+1));
					listOfFresh.remove(Integer.valueOf(row*n+(column+1)));
				}
				if(column-1>=0 && grid[row][column-1]==1) {
					grid[row][column-1]=2;
					queue.offer(row*n+(column-1));
					listOfFresh.remove(Integer.valueOf(row*n+(column-1)));
				}
				size--;
			}
//			若没有新鲜橘子，则退出遍历
			if(listOfFresh.isEmpty()) {
				break;
			}
		}
//		若还有新鲜橘子，则表示有橘子永远不会腐烂，返回-1
		if(!listOfFresh.isEmpty()) {
			return -1;
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[][] grid = {
				{2,1,1},
				{1,1,0},
				{0,1,1}
		};
		int res = new Solution994().orangesRotting(grid);
		System.out.println(res);
	}
}
