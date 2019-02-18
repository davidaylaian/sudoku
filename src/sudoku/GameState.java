package sudoku;

import java.io.File;
import java.io.IOException;

public class GameState
{
	private InternalBoard solution;
	private Board gameboard;
	private boolean[][] emphasis;
	
	public GameState()
	{
		solution = new InternalBoard();
		gameboard = new Board();
		emphasis = new boolean[9][9];
	}
	
	public void save(File f) throws IOException
	{
		// stub
	}
	
	public void load(File f) throws IOException
	{
		// stub
	}
}
