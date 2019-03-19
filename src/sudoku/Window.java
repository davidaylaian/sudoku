package sudoku;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window
{
	JFrame frame;
	JPanel contentPane;

	private static GameState game;
	static BoardPanel b = new BoardPanel();
	// true = solving, entry = false
	static boolean mode;


	public static GameState getGameState() {
		return game;
	}

	public static void setGameState(GameState g) {
		game = g;
	}
	public static void reset() {
		b.reset();
		b.repaint();
	}
	public Window()
	{
		frame = new JFrame("Sudoku");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		frame.setContentPane(contentPane);

		Menu menu = new Menu();
		contentPane.add(menu);

		contentPane.add(b);

		frame.setVisible(true);
		frame.pack();
		
//		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
//		frame.setLocation((int) ((screen.width/2) - (frame.size().getWidth()/2)), (int) ((screen.height/2) - (frame.size().getHeight()/2)));
		frame.setLocationRelativeTo(null);


		GameState state = new GameState(null);
		setGameState(state);

		menu.updateUndoRedo();
		menu.updateHint();
		menu.updateGenerate();
		menu.updateSolve();
	}
}
