package medium.to100;

public class Solution79 {

	boolean isExist = false;
	/**
	 * v1.0
	 * 回溯
	 */
	public boolean exist(char[][] board, String word) {
		int m = board.length;
		int n = board[0].length;
		boolean[][] visited = new boolean[m][n];
//		以不同坐标为起点查找
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(isExist) {
					return isExist;
				}
				backtrack(board, word, 0, i, j, visited);
			}
		}
		return isExist;
	}
	
	public void backtrack(char[][] board, String word, int wordIdx, int row, int column, boolean[][] visited) {
//		不存在，返回
		if(isExist) {
			return;
		}
//		坐标与单词长度一致，说明已找到单词，存在
		if(wordIdx == word.length()) {
			isExist = true;
			return;
		}
//		数组越界，返回
		if(row == board.length || column == board[0].length || row < 0 || column < 0) {
			return;
		}
//		字母已经访问过，返回
		if(visited[row][column]) {
			return;
		}
//		单词在坐标wordIdx的字母与board中行row列column的字母不一样，返回
		if(word.charAt(wordIdx) != board[row][column]) {
			return;
		}
//		访问board中行row列column的字母，置visited为true
		visited[row][column]=true;
//		分别递归row+1，column+1，row-1，column-1
		backtrack(board, word, wordIdx+1, row+1, column, visited);
		backtrack(board, word, wordIdx+1, row, column+1, visited);
		backtrack(board, word, wordIdx+1, row-1, column, visited);
		backtrack(board, word, wordIdx+1, row, column-1, visited);
//		重置行row列column的字幕visited
		visited[row][column]=false;
	}
	
	public static void main(String[] args) {
		Solution79 solution = new Solution79();
		char board[][] = {
				{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'}
		};
		String word = "ABCB";
		boolean isExist = solution.exist(board, word);
		System.out.println(isExist);
	}

}
