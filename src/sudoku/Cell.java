package sudoku;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Cell implements Cloneable{
	static int cellSide = 72;
	private int state;
	private boolean[][] emphasis = new boolean[3][3];
	private int count;
//	private boolean changeable;

	private int[][] nums = {
			{1,2,3},
			{4,5,6},
			{7,8,9}
};

	public Cell() {
		state = 0;
		resetEmphasis();
	}
	private void resetEmphasis() {
		for(int r=0;r<3;r++) {
			for(int c=0;c<3;c++) {
				emphasis[r][c] = true;
			}
		}
		count = 9;
	}
	
	public Cell(int state) {
		this.state = state;
		
	}
	private void setState() {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(emphasis[i][j]) {
					state = nums[i][j];
				}
			}
		}
	}
	public void click(int r, int c, boolean solvingMode) {
		if(solvingMode) {
			if(state!=0) {
				state = 0;
			}
			else if(emphasis[r][c]&&count==1) {
				setState();
			}
			else if(emphasis[r][c]) {
				emphasis[r][c] = false;
				count--;
				if(count==1) {
					setState();
				}
			}
			else if(!emphasis[r][c]){
				emphasis[r][c] = true;
				count++;
				if(count==1) {
					setState();
				}
			}	
		} else {
			if(state!=0) {
				state = 0;
			} else {
				state = nums[r][c];
			}
		}
	}
	public void draw(Graphics g, int row, int col) {
		Font f = new Font("Roboto", Font.PLAIN, 30);
		g.setFont(f);
		int width = g.getFontMetrics().stringWidth(""+state);
		int height = g.getFontMetrics().getHeight();
		if(state==0) {
			f = new Font("Roboto", Font.PLAIN, 12);
			g.setFont(f);
			width = g.getFontMetrics().stringWidth(""+0);
			height = g.getFontMetrics().getHeight();
			for(int r=0;r<3;r++) {
				for(int c=0;c<3;c++) {
					if(emphasis[r][c]) {
						g.setColor(Color.white);
					} else {

						g.setColor(Color.lightGray);
					}
					g.fillRect(col*cellSide+cellSide*c/3, row*cellSide+cellSide*r/3,cellSide/3, cellSide/3);
					g.setColor(Color.black);
					g.drawString("" + nums[r][c], col*cellSide+cellSide*c/3+width/2+4, row*cellSide+cellSide*r/3+height/2+8);
					drawLines(g, row, col);
				}
			}
		} else {
			g.setColor(Color.black);
			g.drawString(""+state, col*cellSide+width/2+16, row*cellSide+height/2+30);
		}
	}
	
	private void drawLines(Graphics g, int r, int c) {
		for(int row=1;row<=2;row++) {
			int x1 = c*cellSide;
			int x2 = (c+1)*cellSide;
			int y = r*cellSide+cellSide*row/3;
			g.drawLine(x1, y, x2, y);
		}
		for(int col=1;col<=2;col++) {
			int x = c*cellSide+cellSide*col/3;
			int y1 = r*cellSide;
			int y2 = (r+1)*cellSide;
			g.drawLine(x, y1, x, y2);
		}
	}
	public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
	
	public static void main(String[] str) {
		Cell del = new Cell();
		
		try {
			System.out.println(del==(Cell)del.clone());
		//	Cell delTemp = (Cell) del.clone();
		} catch (CloneNotSupportedException e) {
		
			
		}
		
	}
}
