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
	
	public boolean[][] getEmphasis()
	{
		return emphasis;
	}
	
	public void setEmphasis(boolean[][] new_emphasis)
	{
		emphasis = new_emphasis;
	}
	
	public void setBoards(InternalBoard new_solution, Board new_gameboard)
	{
		solution = new_solution;
		gameboard = new_gameboard;
	}
	
	public InternalBoard getSolution()
	{
		return solution;
	}
	
	public Board getGameboard()
	{
		return gameboard;
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
