/*
 * Class takes a sudoku upon construction, and provides print and solve methods to public
 * 
 */
public class Sudoku {
	private int[][] sudokuArray = new int[9][9];
	
	public Sudoku(int[][] passSudoku){
		sudokuArray = passSudoku;
	}
	
	public int[][] returnSudoku(){
		return sudokuArray;
		
	}
	
	private boolean findLegal(int x, int y, int value){
		//Check x axis
		for(int incrementX=0; incrementX<9; incrementX++){
			if(incrementX!=x){
				if(sudokuArray[incrementX][y]==value){
					return false;
				}
			}
		}
		//Check y axis
		for(int incrementY=0; incrementY<9; incrementY++){
			if(incrementY!=y){
				if(sudokuArray[x][incrementY]==value){
					return false;
				}
			}
		}
		//Check Square
		int leftMost = (x/3)*3;
		int upperMost = (y/3)*3;
		for(int tempX = leftMost; tempX<(leftMost+3); tempX++){
			for(int tempY = upperMost; tempY<(upperMost+3); tempY++){
				if(tempX!=x || tempY!=y){
					if(sudokuArray[tempX][tempY]==value){
						return false;
					}
				}
			}
		}
		return true;
	}
	//Prints Sudoku
	public void printSudoku(){
		for(int y = 0; y<9; y++){
			for (int x = 0; x<9; x++){
					System.out.print(sudokuArray[x][y]);
				
			}
			System.out.println();
		}
		System.out.println("@@@@@@@@@");
	}

	/*
	 * Solves sudoku matrix. It tests if number is blank, and if it is finds the legal values for 
	 * for it. For each legal value it will try to proceed ‎to call itself for the next blank.
	 * If it encounters failure, no possible values for a blank, it rolls back to the last blank
	 * that still has a valid higher value.
	 */
	public boolean solveSudoku(int x, int y){
		if(sudokuArray[x][y]==0){
			for (int value=1; value<10; value++){
				if(findLegal(x,y,value)==true){
					sudokuArray[x][y]=value;
					if(x<8){
						//System.out.println("trueX<8 + "+x +" "+y + " "+ value);
						if(solveSudoku(x+1, y)!=false){
							return true;
						}
						else{
							//System.out.println("falseX<8 + "+x +" "+y +" "+value);
							sudokuArray[x][y]=0;
						}
					}
					else if(y<8){
						 //System.out.println("trueY<8 + "+x +" "+y);
						 if(solveSudoku(0, y+1)!=false){
							 return true;
						 }
						 else{
							 //System.out.println("falseY<8 + "+x +" "+y);
							 sudokuArray[x][y]=0;
						 }
					}
					else{
						printSudoku();
						return true;
					}
				}
			}
			//System.out.println("false + "+x +" "+y);
			//printSudoku();
			return false;
			}
		else{
			if(x<8){
				return solveSudoku(x+1, y);
			}
			else if(y<8){
				return solveSudoku(0, y+1);
			}
			else{
				printSudoku();
				return true;
			}
		}
	}
	
}
