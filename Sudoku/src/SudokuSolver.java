import javax.swing.JFrame;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.WindowConstants;

/* Creates a frame with a suduko board, gets users to import the known
 * numbers, and then solves if possible, else warns of invalid input
 * numbers.
 */
public class SudokuSolver extends JFrame implements ActionListener{
	private JButton b1;
	private SudokuSolver(){
		super("Sudoku Solver");
}
	

	public static void main(String[] args) {
		System.out.println("test");
		int[][] test ={{0,0,0,6,0,0,0,7,0,0},{6,0,5,0,9,0,0,3,2},{0,0,0,0,0,7,0,0,0},
				{0,3,9,0,2,8,0,0,6},{5,0,0,0,0,0,0,0,4},{1,0,0,7,4,0,9,2,0},
				{0,0,0,9,0,0,0,0,0},{7,5,0,0,3,0,2,0,8},{0,1,0,0,0,6,0,0,0}};

		Sudoku sudokuTest = new Sudoku(test);
		sudokuTest.printSudoku();
		System.out.println("break");
		sudokuTest.solveSudoku(0, 0);
		}
		/*
		SudokuSolver solverFrame = new SudokuSolver();
		solverFrame.setSize(300,400);
		solverFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		solverFrame.setVisible(true);
		JButton b1 = new JButton("disable middle button");
*/
	}


