
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
	
	public boolean addValue(int vertPos, int horiPos, int value) {

		vertPos--;
		horiPos--;
		if(checkArrayBound(horiPos, vertPos, value)){
		
			for(int i = 0; i < SIZE; i++)
				if(board[vertPos][i] == value)
					return false;
			
			for(int i = 0; i < SIZE; i++)
				if(board[i][horiPos] == value)
					return false;
			
			
			board[vertPos][horiPos] = value;
			
			return true;
		}
		return false;
	}
	
	public void removeValue(int horiPos, int vertPos) {
		
		vertPos--;
		horiPos--;
		if(checkArrayBound(horiPos, vertPos, 0))
			board[horiPos][vertPos] = 0;
	}

	public void printBoard() {
		
		System.out.println("    1  2  3  4");
		System.out.println("  --------------");
		
		for(int i = 0; i < SIZE; i++) {
			System.out.print(i+1 + " |");
			for(int j = 0; j < SIZE; j++) {
				System.out.print(" " + board[i][j] + " ");
			}
			System.out.println("|");
		}
		
		System.out.println("  --------------");
	}
	
	public boolean checkVictory() {
		
		for(int i = 0; i < SIZE; i++)
			for(int j = 0; j < SIZE; j++)
				if(board[i][j] == 0)
					return false;
		
		return true;
	}
	
	private boolean checkArrayBound(int horiPos, int vertPos, int value) {
		
		if(horiPos < 0 || horiPos > 3)
			return false;
		if(vertPos < 0 || vertPos > 3)
			return false;
		if(value < 1 || value > 4)
			return false;
		
		return true;
	}
}
