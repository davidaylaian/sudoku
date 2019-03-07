package sudoku;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
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
		try {
			FileOutputStream FOS = new FileOutputStream(f);
			XMLEncoder E = new XMLEncoder(FOS);
			E.writeObject(this);
			E.close();
			FOS.close();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public static GameState load(File f)
	{
		GameState g = null;
		
		try {
			FileInputStream FIS = new FileInputStream(f);
			XMLDecoder D = new XMLDecoder(FIS);
			g = (GameState) D.readObject();
			D.close();
			FIS.close();
		} catch (IOException e){
			e.printStackTrace();
		}
		
		return g;
	}
}
