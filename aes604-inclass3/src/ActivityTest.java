public class ActivityTest {

	/**
	 * Name: print2DArray
	 * Description: sole purpose is to print the contents of a 2D array
	 * @param board
	 */
	public static void print2DArray(int[][] board) {
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {
				System.out.print(board[r][c]);
			}
			System.out.println();
		}
	}

	/**
	 * Name: print1DArray
	 * Description: sole purpose is to print the contents of a 1d array
	 * @param board
	 */
	public static void print1DArray(int[] board) {
		for (int r = 0; r < board.length; r++) {
			System.out.print(board[r] +" ");
		}
		System.out.println();
	}

	/**
	 * Name: main()
	 * Description: Driver of all the code... gets the ball rolling!
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("GAME OF LIFE RESULTS");
		System.out.println("--------------------------");
		int[][] board = new int[][] { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };
		GameOfLife.gameOfLife(board);

		ActivityTest.print2DArray(board);
		System.out.println("");
		System.out.println("FIBONACCI NUMBER!");
		System.out.println("--------------------------");
		int[] res = FibonacciNumber.getFibonacciNumbers(10);
		ActivityTest.print1DArray(res);
	}

}