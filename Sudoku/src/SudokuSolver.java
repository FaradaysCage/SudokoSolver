import javax.swing.JFrame;
import javax.swing.WindowConstants;

/* Creates a frame with a suduko board, gets users to import the known
 * numbers, and then solves if possible, else warns of invalid input
 * numbers.
 */
public class SudokuSolver {

	public static void main(String[] args) {
		System.out.println("test");
		JFrame solverFrame = new JFrame("Sudoku Solver");
		solverFrame.setSize(300,400);
		solverFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		solverFrame.setVisible(true);


	}

}
