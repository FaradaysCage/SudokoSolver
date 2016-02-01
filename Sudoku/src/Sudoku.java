/**
 * Class takes a sudoku upon construction, and provides print and solve methods
 * to public Created By Ross Hanson
 */

public class Sudoku {
	private int[][] sudokuArray = new int[9][9];

	public Sudoku(int[][] passSudoku) {
		sudokuArray = passSudoku;
	}

	public int[][] returnSudoku() {
		return sudokuArray;

	}

	/**
	 * Method that takes takes coordinates and a value as arguments and checks
	 * if that value in that coordinate is legal in the Sudoku
	 * 
	 * @param x,
	 *            columns of sudoku
	 * @param y,
	 *            rows of sudoku
	 * @param value,
	 *            number in particular row and column
	 * @return
	 */
	private boolean findLegal(int x, int y, int value) {
		// Check x axis
		for (int incrementX = 0; incrementX < 9; incrementX++) {
			if (incrementX != x) {
				if (sudokuArray[incrementX][y] == value) {
					return false;
				}
			}
		}
		// Check y axis
		for (int incrementY = 0; incrementY < 9; incrementY++) {
			if (incrementY != y) {
				if (sudokuArray[x][incrementY] == value) {
					return false;
				}
			}
		}
		// Check Square
		int leftMost = (x / 3) * 3;
		int upperMost = (y / 3) * 3;
		for (int tempX = leftMost; tempX < (leftMost + 3); tempX++) {
			for (int tempY = upperMost; tempY < (upperMost + 3); tempY++) {
				if (tempX != x || tempY != y) {
					if (sudokuArray[tempX][tempY] == value) {
						return false;
					}
				}
			}
		}
		return true;
	}

	/**
	 * Prints sudoku out to console.
	 */
	public void printSudoku() {
		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 9; x++) {
				System.out.print(sudokuArray[x][y]);

			}
			System.out.println();
		}
		System.out.println("@@@@@@@@@");
	}

	/**
	 * Solves sudoku matrix. It tests if field is blank (shown by 0), and if it
	 * is finds the legal values for for it. For each legal value it will try to
	 * proceed ‎and call itself for the next blank field. If it encounters
	 * failure, no possible values for a blank, it rolls back to the last blank
	 * that still has a valid higher value.
	 * 
	 * @param x,columns
	 *            of sudoku
	 * @param y,rows
	 *            of sudoku
	 * @return boolean, if there is a legal value for that field
	 */
	public boolean solveSudoku(int x, int y) {

		// Tests if field is blank
		if (sudokuArray[x][y] == 0) {

			// Iterates through possible values
			for (int value = 1; value < 10; value++) {

				// If value is legal, it trys putting it in the field
				if (findLegal(x, y, value) == true) {
					sudokuArray[x][y] = value;

					// If it is not at the end of the row, it calls
					// itself in the next column in the row
					if (x < 8) {

						// Checks if value lets Sudoku be solvable in
						// future fields
						if (solveSudoku(x + 1, y) != false) {
							return true;
						} else {
							// If value leaves Sudoku unsolvable,reset
							// to blank, either a higher value will inserted
							// in for loop, or stays reset and it rolls back
							sudokuArray[x][y] = 0;
						}

						// If it is not at the end of the column, it calls
						// itself in the next row
					} else if (y < 8) {

						// If Checks if Value lets Sudoku be solvable in
						// future fields
						if (solveSudoku(0, y + 1) != false) {
							return true;
						} else {
							// If value leaves Sudoku unsolvable,reset
							// to blank, either a higher value will inserted
							// in for loop, or stays reset and it rolls back
							sudokuArray[x][y] = 0;
						}

						// When it reaches here, the Sudoku has been filled
						// with vaild values, and is solved
					} else {
						printSudoku();
						return true;
					}
				}
			}
			// There are no vaild values, roll back to last field with
			// possible higher value
			return false;

		}
		// The Sudoku field is not blank, meaning the value must be correct
		else {

			// Calls SudokuSolver on next column in row
			if (x < 8) {
				return solveSudoku(x + 1, y);

			}
			// Calls SudokuSolver on next row
			else if (y < 8) {
				return solveSudoku(0, y + 1);
			}
			// The final field was already given, sudoku is solved
			else {
				printSudoku();
				return true;
			}
		}
	}

}
