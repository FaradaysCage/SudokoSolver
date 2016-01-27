
public class Sudoku {
	int[][] sudokuArray = new int[9][9];
	
	public Sudoku(int[][] passSudoku){
		sudokuArray = passSudoku;
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
		int leftMost = x/3;
		int upperMost = y/3;
		for(int tempX = leftMost; tempX<(leftMost+3); tempX++){
			for(int tempY = upperMost; tempY<(upperMost+3); upperMost++){
				if(tempX!=x & tempY!=y){
					if(sudokuArray[tempX][tempY]==value){
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public void printSudoku(){
		for(int y = 0; y<9; y++){
			for (int x = 0; x<9; x++){
					System.out.print(sudokuArray[x][y]);
				
			}
			System.out.println();
		}
	}

	
	public boolean solveSudoku(int x, int y){
		if(sudokuArray[x][y]==0){
			for (int value=1; value<10; value++){
				if(findLegal(x,y,value)==true){
					sudokuArray[x][y]=value;
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
			printSudoku();
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
