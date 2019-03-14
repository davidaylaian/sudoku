package sudoku;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window {
	JFrame frame;
	JPanel contentPane;
	private static GameState game;
	public static final int ENTRY = 0;
	public static final int SOLVING = 1;
	public static int mode;

	public static GameState getGameState() {
		return game;
	}

	public static void setGameState(GameState g) {
		game = g;
	}

	public static int getMode() {
		return mode;
	}

	public static void entryMode() {
		if(getMode() != ENTRY)
			mode = ENTRY;
	}

	public static void solvingMode() {
		if(getMode() != SOLVING)
			mode = SOLVING;
	}

	public Window()
	{
		frame = new JFrame("Sudoku");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		contentPane.add(new Menu());
		frame.setContentPane(contentPane);

		frame.setVisible(true);
		frame.pack();

		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((int) ((screen.width/2) - (frame.size().getWidth()/2)), (int) ((screen.height/2) - (frame.size().getHeight()/2)));
		frame.setLocationRelativeTo(null);

		entryMode();
		setGameState(new GameState(null));
	}
}
