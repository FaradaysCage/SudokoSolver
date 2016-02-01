import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.Scanner;
import java.text.NumberFormat;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

import javax.swing.*;

/**
 * Creates a frame with a suduko board, gets users to import the known numbers,
 * and then solves if possible, else warns of invalid input numbers. Created By
 * Ross Hanson
 */
public class SudokuSolver extends JPanel implements PropertyChangeListener, ActionListener {

	// grid of sudoku
	private JFormattedTextField[][] fields = new JFormattedTextField[9][9];

	// making sudoku grid
	private int sudokuArray[][] = new int[9][9];

	// Set format for JFormatted Text
	private NumberFormat valueFormat;

	// solve button
	private JButton solveButton;

	/**
	 * Constructor for the class SudokuSolver that extends Frame. Makes panels,
	 * JFormatedText fields and buttons, adds them to the frame.
	 */
	private SudokuSolver() {

		valueFormat = NumberFormat.getNumberInstance();

		// Creates fieldPanel
		JPanel fieldPanel = new JPanel(new GridLayout(9, 9));

		// Creates buttonPanel
		JPanel buttonPanel = new JPanel();

		// Goes through the rows and columns of fields and set them up.
		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 9; x++) {
				// Initializes the JFormatedTextFields
				fields[x][y] = new JFormattedTextField(valueFormat);

				// Sets the value to the default of int arrays, 0.
				fields[x][y].setValue(sudokuArray[x][y]);

				// Sets size column size to 1
				fields[x][y].setColumns(1);

				// Adds PropertyChangeListener (Update when field[][] changes
				fields[x][y].addPropertyChangeListener("value", this);

				// Attaches the JFormattedTextFields to the panel
				fieldPanel.add(fields[x][y]);
			}
		}
		// Creates JButton
		solveButton = new JButton("solve");

		// Make JButton Listen to this class
		solveButton.addActionListener(this);

		// Adds JButton to panel
		buttonPanel.add(solveButton);

		// Adds panels to frame
		add(fieldPanel);
		add(buttonPanel);
	}

	/**
	 * Called when a fields "value" property changes.
	 */
	public void propertyChange(PropertyChangeEvent e) {
		Object source = e.getSource();
		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 9; x++) {
				if (source == fields[x][y]) {
					sudokuArray[x][y] = ((Number) fields[x][y].getValue()).intValue();
				}
			}
		}
	}

	/**
	 * Button for solve, solves the sudoku, and updates the grid
	 * 
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		Sudoku toSolve = new Sudoku(sudokuArray);
		int[][] temp = toSolve.returnSudoku();
		toSolve.printSudoku();
		toSolve.solveSudoku(0, 0);
		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 9; x++) {
				fields[x][y].setValue(temp[x][y]);
			}
		}

	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event dispatch thread.
	 */
	private static void createAndShowGUI() {
		// Create and set up the window
		JFrame frame = new JFrame("SudokuSolver");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Creates instance of SudokuSolver and adds it to the frame
		frame.add(new SudokuSolver());

		// Sets the window to be the preferred size of its subcomponents
		frame.pack();

		// Displays window
		frame.setVisible(true);

		// stops windows from being resizable
		frame.setResizable(false);

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
		
		//To solve Sudoku by using console instead of GUI
		/*
		 * Scanner input = new Scanner(System.in); boolean correct = false;
		 * int[][] test = new int[9][9]; while (!correct) { System.out.println(
		 * "Please enter values of the sudoku starting from the top left, along"
		 * +
		 * " the x axis, then each subsequent row. Please enter blanks as naught."
		 * ); for (int y = 0; y < 9; y++) { for (int x = 0; x < 9; x++) {
		 * test[x][y] = input.nextInt(); } } System.out.println(
		 * "is the following sudoku correct? please enter y or n"); Sudoku
		 * sudokuTest = new Sudoku(test); sudokuTest.printSudoku(); String
		 * answer = input.next(); if (answer.equals("y")) { correct = true;
		 * sudokuTest.solveSudoku(0, 0); }
		 * 
		 * } input.close();
		 */

	}

}
