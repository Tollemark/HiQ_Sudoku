import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TestCase {

	SudokuBoard sudoku;
	
	@Before
	public void setup(){
		sudoku = new SudokuBoard();
	}
	
	@Test
	public void testAddCorrectLowCell() {
		boolean test = sudoku.addValue(1, 1, 1);
		assertEquals(true, test);
	}

	@Test
	public void testAddCorrectHighCell() {
		boolean test = sudoku.addValue(4, 4, 4);
		assertEquals(true, test);
	}
	
	@Test
	public void testAddIncorrectLowCell() {
		boolean test = sudoku.addValue(0, 1, 4);
		assertEquals(false, test);
	}
	
	@Test
	public void testAddIncorrectHighCell() {
		boolean test = sudoku.addValue(1, 5, 3);
		assertEquals(false, test);
	}
	
	@Test
	public void testAddIncorrectLowValue() {
		boolean test = sudoku.addValue(1, 3, 0);
		assertEquals(false, test);
	}
	
	@Test
	public void testAddIncorrectHighValue() {
		boolean test = sudoku.addValue(4, 4, 5);
		assertEquals(false, test);
	}
	
	
}
