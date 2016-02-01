import java.awt.*;
import javax.swing.*;
import java.util.Scanner;
import java.text.NumberFormat;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
/* Creates a frame with a suduko board, gets users to import the known
 * numbers, and then solves if possible, else warns of invalid input
 * numbers.
 */
public class SudokuSolver extends JPanel implements PropertyChangeListener{
	
	//Default value of textfield
	private int fieldDefault = 0;
	
	//grid of sudoku
	private JFormattedTextField[][] fields = new JFormattedTextField[9][9];

	
	private NumberFormat valueFormat;
	
	private SudokuSolver(){
		
		valueFormat = NumberFormat.getNumberInstance();
		
		JPanel fieldPanel = new JPanel(new GridLayout(9,9));
		
		//Create the text fields and set them up.
		
		for(int x = 0; x<9; x++){
			for(int y = 0; y<9; y++){
				fields[x][y]= new JFormattedTextField(valueFormat);
				fields[x][y].setValue(fieldDefault);
				fields[x][y].setColumns(1);
				fields[x][y].addPropertyChangeListener("value", this);
				fieldPanel.add(fields[x][y]);
				}
			}
		add(fieldPanel);
			
	        
	        
			
	}
	

	public static void main(String[] args) {
		JFrame frame = new JFrame ("SudokuSolver");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new SudokuSolver());
		frame.pack();
		frame.setVisible(true);
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
	


}


