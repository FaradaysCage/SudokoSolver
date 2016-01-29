import javax.swing.JFrame;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.WindowConstants;
import java.util.Scanner;

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
		Scanner input = new Scanner (System.in);
		boolean correct = false;
		int[][] test = new int[9][9];
		while(!correct){
			System.out.println("Please enter values of the sudoku starting from the top left, along"
					+ " the x axis, then each subsequent row. Please enter blanks as naught.");
			for(int y=0; y<9; y++){
				for(int x = 0; x<9; x++){
						test[x][y]= input.nextInt();
					}
				}
			System.out.println("is the following sudoku correct? please enter y or n");
			Sudoku sudokuTest = new Sudoku(test);
			sudokuTest.printSudoku();
			String answer = input.next();
			if(answer.equals("y")){
				correct = true;
				sudokuTest.solveSudoku(0, 0);
				}

			}
		input.close();
	}


		/*
		SudokuSolver solverFrame = new SudokuSolver();
		solverFrame.setSize(300,400);
		solverFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		solverFrame.setVisible(true);
		JButton b1 = new JButton("disable middle button");
*/
}


