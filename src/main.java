import java.util.Scanner;


public class main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SudokuBoard sudoku = new SudokuBoard();
		
		Scanner scan = new Scanner(System.in);
		
		String actionInput = "";
		int row, col, value;
		
		while(!actionInput.equals("QUIT")){
			
			sudoku.printBoard();
			System.out.println("Enter A to add new value, Enter B to remove value, Enter QUIT to quit the program");
			actionInput = scan.nextLine();
			
			
			if(actionInput.equals("A") || actionInput.equals("a")) {
				
				System.out.println("Enter row:");
				row = scan.nextInt();
				System.out.println("Enter column:");
				col = scan.nextInt();
				System.out.println("Enter value:");
				value = scan.nextInt();
				
				if(sudoku.addValue(row, col, value))
					if(sudoku.checkVictory()){
						actionInput = "QUIT";
						sudoku.printBoard();
						System.out.println("Victory!");
					}
				
			} else if(actionInput.equals("B") || actionInput.equals("b")) {
				
				System.out.println("Enter row:");
				row = scan.nextInt();
				System.out.println("Enter column:");
				col = scan.nextInt();
				sudoku.removeValue(row, col);
				
			} else if(actionInput.equals("QUIT")) {
				
				System.out.println("Thanks for playing");
				
			} else {
				
				System.out.println("Invalid input");
			}
			scan.nextLine();
		}	
	}
}
