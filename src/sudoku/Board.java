package sudoku;

// Important: Potential violation of the dependency inversion principle? Discuss later

public class Board
{
	int[][] grid;
	
	public Board()
	{
		grid = new int[9][9];
		
		for (int x = 0; x < 9; x++)
		{
			for (int y = 0; y < 9; y++)
			{
				grid[x][y] = 0;
			}
		}
	}
	
	public int getCell(int x, int y)
	{
		return grid[x][y];
	}
	
	public void setCell(int x, int y, int val)
	{
		grid[x][y] = val;
	}
}
