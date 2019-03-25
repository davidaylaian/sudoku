package sudoku;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.color.*;

public class BoardPanel extends JPanel 
{
	final static Color light = new Color(170,170,170);
	final Color dark = new Color(85,85,85);
	final Color darker = new Color(0,0,0);
	
	BoardPanel()
	{
		Window.setGameState(new GameState(null));
		setup();
	}

	private void setup()
	{
		
		setPreferredSize(new Dimension(638, 648));
		this.setBackground(Color.white);

		
		this.addMouseListener(new MouseListener()
		{
			public void mouseClicked(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}

			public void mousePressed(MouseEvent e)
			{
				int colOfCell = e.getX()/Cell.cellSide;
				int rowOfCell = e.getY()/Cell.cellSide;

				int colInside = e.getX()/(Cell.cellSide/3);
				int rowInside = e.getY()/(Cell.cellSide/3);

				GameState state = Window.getGameState();
				Cell copy = state.getCell(rowOfCell, colOfCell).makeCopy();
				copy.click(rowInside-(rowOfCell*3), colInside-(colOfCell*3), true);
				state.setCell(copy, rowOfCell, colOfCell);

				Window.passUpdateUndoRedo();
				repaint();
			}

			public void mouseReleased(MouseEvent e) {}
		});
	}

	public void paintComponent(Graphics g)
	{
		GameState state = Window.getGameState();
		super.paintComponent(g);

		for(int r=0; r<9; r++) {
			for(int c=0; c<9; c++) {
				state.getCell(r, c).draw(g, r, c);
			}
		}
		drawGrid(g);
	}

	private void drawGrid(Graphics g) {
		for(int x=0; x<648; x+=72) {
			if(x%216==0) {
				g.setColor(darker);
			//	g.drawLine(x, 0, x, 648);
				g.fillRect(x-2, 0, 2, 648);
				
			}else {
				g.setColor(dark);
				//g.drawLine(x, 0, x, 648);
				g.fillRect(x-1, 0, 1, 648);
			}
		}

		for(int y=0; y<648; y+=72) {
			if(y%216==0) {
				g.setColor(darker);
			//	g.drawLine(0, y, 648, y);
				g.fillRect(0, y-2, 648, 2);
			}else {
				g.setColor(dark);
			//	g.drawLine(0, y, 648, y);
				g.fillRect(0, y-1, 648, 1);
			}
		}
	}
}
