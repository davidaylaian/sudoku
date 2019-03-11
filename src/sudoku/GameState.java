package sudoku;

import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;

public class GameState
{
	private int[][] solution;
	private Cell[][] gameBoard;

	private class Change
	{
		Cell modifiedCell;
		int indexX;
		int indexY;
	}

	private List<Change> history;
	private int historyIndex;

	public GameState(int[][] newSolution)
	{
		solution = newSolution;
		history = new ArrayList<>();
		historyIndex = 0;
	}

	public void setGameBoard(Cell[][] newGameBoard)
	{
		gameBoard = newGameBoard;
	}

	public Cell[][] getGameBoard()
	{
		return gameBoard;
	}

	public int[][] getSolution()
	{
		return solution;
	}

	public void undo()
	{
		// stub
	}

	public void redo()
	{
		// stub
	}

	public boolean redo_enabled()
	{
		return historyIndex == history.size() - 1;
	}

	public void save(File f) throws IOException
	{
		FileOutputStream FOS = new FileOutputStream(f);
		XMLEncoder E = new XMLEncoder(FOS);

		E.writeObject(this);
		E.close();
		FOS.close();
	}

	public static GameState load(File f) throws IOException
	{
		FileInputStream FIS = new FileInputStream(f);
		XMLDecoder D = new XMLDecoder(FIS);
		GameState g = (GameState) D.readObject();

		D.close();
		FIS.close();
		return g;
	}
}
