import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;


public class SudokuBoard {
	
	final private int SIZE = 4;
	private int[][] board;
	private int[][] completedBoard;
	
	public SudokuBoard() {
		
		board = new int[SIZE][SIZE];
		
		// Init board
		for(int i = 0; i < SIZE; i++){
			for(int j = 0; j < SIZE; j++){
				setValue(i ,j ,0);
				
			}
		}
		
		generateBoard();
		
		// create correct board
		completedBoard = new int[SIZE][SIZE];
		
		for(int i = 0; i < SIZE; i++){
			for(int j = 0; j < SIZE; j++){
				completedBoard[i][j] = board[i][j];		
			}
		}
		
		hideNumbers();
	}
	
	// Hite board numbers
	public void hideNumbers(){
		
		Random rand = new Random();
		ArrayList<Integer> numberList = new ArrayList<Integer>();
		for(int i = 0; i < 16; i++)
			numberList.add(i);
		
		for(int i = 0; i < 10; i++) {
			int index = rand.nextInt(16 - i);
			int number = numberList.get(index);
			board[number / 4][number % 4] = 0;
			numberList.remove(index);
		}
	}
	
	
	public int getValue(int row, int col) {
		
		return board[row][col];
	}
	
	
	public void setValue(int row, int col, int value) {
		
		board[row][col] = value;
	}
	
	
	// Generating random board
	public void generateBoard() {
		
		Random rand = new Random();
		int row, col;
		
		// value
		for(int i = 1; i <= 4; i++){
			
			do{
				row = rand.nextInt(2);
				col = rand.nextInt(2);
			} while(getValue(row, col) != 0);
			
			// set value for cell 1
			setValue(row, col, i);
			
			// set value for cell 2
			row ^= 1;
			col ^= 1;
			setValue(row, col + 2, i);
			
			// set value for cell 3
			row ^= 1;
			setValue(row + 2, col, i);
			
			// set value for cell 4
			row ^= 1;
			col ^= 1;
			setValue(row + 2, col + 2, i);
		}
	}
	
	
	public boolean addValue(int row, int col, int value) {

		row--;
		col--;
		if(checkArrayBound(row, col, value)){
		
			for(int i = 0; i < SIZE; i++)
				if(getValue(row, i) == value)
					return false;
			
			for(int i = 0; i < SIZE; i++)
				if(getValue(i, col) == value)
					return false;
			
			
			board[row][col] = value;
			
			return true;
		}
		return false;
	}
	
	
	public void removeValue(int row, int col) {
		
		row--;
		col--;
		if(checkArrayBound(row, col, 1))
			setValue(row, col, 0);
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
		
		if(Arrays.deepEquals(board, completedBoard))
			return true;
		return false;
	}
	
	
	// Checking boundary
	private boolean checkArrayBound(int row, int col, int value) {
		
		boolean checker = true;
		if(row < 0 || row > 3)
			checker = false;
		else if(col < 0 || col > 3)
			checker = false;
		else if(value < 1 || value > 4)
			checker = false;
		
		if(!checker)
			System.out.println("Incorrect input");
		
		return checker;
	}
}
