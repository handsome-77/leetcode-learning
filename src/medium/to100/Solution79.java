package medium.to100;

public class Solution79 {

	boolean isExist = false;
	public boolean exist(char[][] board, String word) {
		int m = board.length;
		int n = board[0].length;
		boolean[][] visited = new boolean[m][n];
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
		if(isExist) {
			return;
		}
		if(wordIdx == word.length()) {
			isExist = true;
			return;
		}
		if(row == board.length || column == board[0].length || row < 0 || column < 0) {
			return;
		}
		if(visited[row][column]) {
			return;
		}
		if(word.charAt(wordIdx) != board[row][column]) {
			return;
		}
		visited[row][column]=true;
		backtrack(board, word, wordIdx+1, row+1, column, visited);
		backtrack(board, word, wordIdx+1, row, column+1, visited);
		backtrack(board, word, wordIdx+1, row-1, column, visited);
		backtrack(board, word, wordIdx+1, row, column-1, visited);
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
