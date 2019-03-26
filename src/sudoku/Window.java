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

	public static void resetEmphasis()
	{
		gs.resetEmphasis();
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
		frame.setResizable(false);

		frame.setLocationRelativeTo(null);
		entryMode();
		menu.updateUndoRedo();
		menu.updateHint();
		menu.updateGenerate();
		menu.updateSolve();
	}
}
