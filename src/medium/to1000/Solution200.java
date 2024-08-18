package medium.to1000;

import java.util.LinkedList;
import java.util.Queue;

public class Solution200 {

	/**
	 * v2.0
	 * 广度优先遍历，队列
	 * @param grid
	 * @return
	 */
	public int numIslands(char[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int res = 0;
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(grid[i][j]=='1') {
					res++;
					grid[i][j]='0';
					Queue<Integer> queue = new LinkedList<Integer>();
					queue.add(i*n+j);
					while(!queue.isEmpty()) {
						int temp = Integer.parseInt(queue.poll().toString());
						int row = temp/n;
						int column = temp%n;
						if(row+1<m && grid[row+1][column]=='1') {
							queue.offer((row+1)*n+column);
							grid[row+1][column]='0';
						}
						if(row-1>=0 && grid[row-1][column]=='1') {
							queue.offer((row-1)*n+column);
							grid[row-1][column]='0';
						}
						if(column+1<n && grid[row][column+1]=='1') {
							queue.offer(row*n+(column+1));
							grid[row][column+1]='0';
						}
						if(column-1>=0 && grid[row][column-1]=='1') {
							queue.offer(row*n+(column-1));
							grid[row][column-1]='0';
						}
					}
				}
			}
		}
		return res;
	}
	
	/**
	 * v1.0
	 * 深度优先遍历，递归
	 * 遇到1往下递归，并将其置为0
	 * @param grid
	 * @return
	 */
	public int numIslands1(char[][] grid) {
		int res = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					res++;
					dfs(grid, i, j);
				}
			}
		}
		return res;
	}

	public void dfs(char[][] grid, int i, int j) {
		if (i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || grid[i][j] == '0') {
			return;
		}
		grid[i][j] = '0';
		dfs(grid, i + 1, j);
		dfs(grid, i, j + 1);
		dfs(grid, i - 1, j);
		dfs(grid, i, j - 1);
	}
}
