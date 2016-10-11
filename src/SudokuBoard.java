
public class SudokuBoard {
	
	final private int SIZE = 4;
	private int[][] board;
	
	public SudokuBoard() {
		
		board = new int[SIZE][SIZE];
		
		// Init board
		for(int i = 0; i < SIZE; i++)
			for(int j = 0; j < SIZE; j++)
				board[i][j] = 0;
		
	}
	
	public void setPos(int horiPos, int vertPos, int index) {
		
		board[horiPos][vertPos] = index;
	}

	public void printBoard() {
		
		System.out.println("    1  2  3  4");
		System.out.println("  -------------");
		
		for(int i = 0; i < SIZE; i++) {
			System.out.print(i+1 + " |");
			for(int j = 0; j < SIZE; j++) {
				System.out.print(" " + board[i][j] + " ");
			}
			System.out.println("|");
		}
		
		System.out.println("  -------------");
	}
}
