package sudoku;

// Important: Potential violation of the dependency inversion principle? Discuss later

public class Board
{
	int[][] grid;
	
	public Board()
	{
		grid = new int[9][9];
	}
	
	public Board(int[][] new_grid)
	{
		grid = new_grid;
	}
	
	public int getCell(int row, int col)
	{
		return grid[row][col];
	}
	
	public void setCell(int row, int col, int val)
	{
		grid[row][col] = val;
	}
	
	public int[][] getGrid()
	{
		return grid;
	}
}
