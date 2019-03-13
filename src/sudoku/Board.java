package sudoku;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Board extends JPanel{
	
	Cell[][] board = new Cell[9][9];
	
	Board() {
		setPreferredSize(new Dimension(630, 630));
		for(int r=0;r<9;r++) {
			for(int c=0;c<9;c++) {
				board[r][c] = new Cell();
			}
		}
	}
	
	Board(int[][] generatedBoard) {
		setPreferredSize(new Dimension(630, 630));
		for(int r=0; r<9; r++) {
			for(int c=0; c<9; c++) {
				if(generatedBoard[r][c]==0) {
					board[r][c] = new Cell();
				}else {
//					board[r][c] = new Cell(generatedBoard[r][c]);
				}
			}
		}	
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawGrid(g);
//		for(int r=0; r<9; r++) {
//			for(int c=0; c<9; c++) {
//				board[r][c].draw(g, r, c);
//			}
//		}
	}
	
	private void drawGrid(Graphics g) {
		for(int x=0; x<630; x+=70) {
			if(x%210==0) {
				g.fillRect(x-1, 0, 3, 630);
			}else {
				g.drawLine(x, 0, x, 630);
			}
		}
		for(int y=0; y<630; y+=70) {
			if(y%210==0) {
				g.fillRect(0, y-1, 630, 3);
			}else {
				g.drawLine(0, y, 630, y);
			}
		}
	}
	
	public static void main(String[] str) {
		JFrame frame = new JFrame("Test");
		Board b = new Board();
		frame.setContentPane(b);
		frame.pack();
		frame.setVisible(true);
	}
}
