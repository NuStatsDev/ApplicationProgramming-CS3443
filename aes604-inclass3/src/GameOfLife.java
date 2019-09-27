public class GameOfLife {


// dont need this i can just set the iint[] = to another int[][] thanks java!
//	public static int[][] getBoard(){
//
//		for (int row = 0; row < rows; row++) {
//			for (int col = 0; col < cols; col++) {
//				copyBoard[row][col] = board[row][col];
//			}
//		}
//
//	}
//

	/**
	 * Name: gameOfLife()
	 * Description: Logical part of the game of life game, pretty much just checks for different cases between 2 2d arrays
	 * 				discussed in class today.
	 * @param board
	 */
	public static void gameOfLife(int[][] board) {
		int[] neighbors = {0, 1, -1};
		int rows = board.length, cols = board[0].length, nCol, nRow,liveNeighbors = 0;
		// Create a copy of the original board
		int[][] copyBoard =board;

		// Iterate through the board cell by cell.
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				// reset this every iteration
				liveNeighbors = 0;
				// For each cell count the number of neighbors that are alive.
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++){
						if (!(neighbors[i] == 0 && neighbors[j] == 0)) {
							nRow = (row + neighbors[i]);
							nCol = (col + neighbors[j]);
							if ((nRow < rows && nRow >= 0) && (nCol < cols && nCol >= 0) && (copyBoard[nRow][nCol] == 1)) {
							liveNeighbors += 1;
							}
						}
					}
				}

				// Rule 1:current element is = to 1 and it has more than 2 live neighbors  or  Rule 3: it has more than 3 live neighbors
				if ((copyBoard[row][col] == 1) && (liveNeighbors < 2 || liveNeighbors > 3)) {
				board[row][col] = 0;
				}
				// Rule 4: if the value at the elemenet is 0 and live neighbors is = to 3 then rebirth
				if (copyBoard[row][col] == 0 && liveNeighbors == 3) {
				board[row][col] = 1;
				}
			}
		}
	}


	/**
	 * NAME: main()
	 * Description: main function of GameOfLife, all it does is give it a board (idk why because i thought thats what activity test was supposed to do
	 * 				and it also calls activity test to print a 2d array of the board... not sure if thats working though i only seem to get the out put
	 * 				to display
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] board = new int[][] { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };
		GameOfLife.gameOfLife(board);
		ActivityTest.print2DArray(board);
	}

}