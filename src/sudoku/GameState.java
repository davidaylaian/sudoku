package sudoku;

import java.io.*;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;

public class GameState
{
	private int[][] solution;
	private Cell[][] gameBoard;
	
	public GameState(int[][] newSolution)
	{
		solution = newSolution;
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
