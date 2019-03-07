package sudoku;
import java.awt.*;
import javax.swing.*;
public class CellPanel{
	
	private JPanel singleState, gridState;
	private Cell x;
	private JButton[][] grid = new JButton[3][3];
	private JButton singleButton;
	private int gridLabel = 1;
	
	public CellPanel(Cell a) {
		x = a;
		
		singleState.setPreferredSize(new Dimension(30, 30));
		gridState.setPreferredSize(new Dimension(30, 30));
		
		gridState.setLayout(new GridLayout(3,3));

		singleButton = new JButton (/*x.cellmethod*/);
		singleState.add(singleButton);
		
		for(int i=0; i<2; i++) {
			for(int j=0; j<2; j++) {
				gridLabel++;
				grid[i][j] = new JButton(Integer.toString(gridLabel));
			}
		}
		
	}
	
	public JPanel getSingleState() {
		return singleState;
	}
	
	public JPanel getGridState() {
		return gridState;
	}

}
