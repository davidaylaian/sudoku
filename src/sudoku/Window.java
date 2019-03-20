package sudoku;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window
{

	private static JFrame frame;
	private static JPanel contentPane;
	private static GameState gs;
	private static Menu menu;
	private static BoardPanel board;

	private static GameState game;
	static BoardPanel b = new BoardPanel();
	// true = solving, entry = false
	static boolean mode;



	public static boolean getMode() {
		return mode;
	}

	public static void entryMode() {
		mode = false;
	}

	public static void solvingMode() {
		mode = true;
	}

	public static GameState getGameState() {
		return gs;
	}

	public static void setGameState(GameState newState) {
		gs = newState;
	}

	public static void passUpdateUndoRedo()
	{
		menu.updateUndoRedo();
	}

	public static void repaintBoard()
	{
		board.repaint();
	}

	public Window()
	{
		frame = new JFrame("Sudoku");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		frame.setContentPane(contentPane);

		menu = new Menu();
		board = new BoardPanel();
		contentPane.add(menu);
		contentPane.add(board);

		frame.setVisible(true);
		frame.pack();
		
//		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
//		frame.setLocation((int) ((screen.width/2) - (frame.size().getWidth()/2)), (int) ((screen.height/2) - (frame.size().getHeight()/2)));
		frame.setLocationRelativeTo(null);
		entryMode();
		menu.updateUndoRedo();
		menu.updateHint();
		menu.updateGenerate();
		menu.updateSolve();
	}
}
