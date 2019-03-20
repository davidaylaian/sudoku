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

	//for XML conventions
	public GameState() {}

	public GameState(int[][] newSolution)
	{
		solution = newSolution;
		history = new ArrayList<>();
		historyIndex = -1;
		gameBoard = new Cell[9][9];

		for (int x = 0; x < 9; x++)
		{
			for (int y = 0; y < 9; y++)
			{
				gameBoard[x][y] = new Cell();
			}
		}
	}

	public Cell[][] getBoard()
	{
		return gameBoard;
	}

	// warning: will reset the history as well. probably should alert the user when calling this method
	public void resetGameBoard(Cell[][] newGameBoard)
	{
		gameBoard = newGameBoard;
		history = new ArrayList<>();
		historyIndex = 0;
	}

	public void setCell(Cell newCell, int row, int col)
	{
		Change c = new Change();
		c.indexX = row;
		c.indexY = col;
		c.modifiedCell = gameBoard[row][col];

		history.add(c);
		historyIndex++;


		gameBoard[row][col] = newCell;
  }

	public Cell getCell(int indexX, int indexY)
	{
		return gameBoard[indexX][indexY];
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
		Change c = history.get(historyIndex);
		gameBoard[c.indexX][c.indexY] = c.modifiedCell;
		historyIndex--;
	}

	public void redo()
	{
		Change c = history.get(historyIndex + 1);
		gameBoard[c.indexX][c.indexY] = c.modifiedCell;
		historyIndex++;
	}

	public boolean undo_enabled()
	{
		return historyIndex >= 0;
	}

	public boolean redo_enabled()
	{
		return historyIndex < history.size() - 1;
	}

	public void save(File f) throws Exception
	{
		FileOutputStream FOS = new FileOutputStream(f);
		XMLEncoder E = new XMLEncoder(FOS);

		E.writeObject(this);
		E.close();
		FOS.close();
	}

	public static GameState load(File f) throws Exception
	{
		FileInputStream FIS = new FileInputStream(f);
		XMLDecoder D = new XMLDecoder(FIS);
		GameState g = (GameState) D.readObject();

		D.close();
		FIS.close();
		return g;
	}
}
