package sudoku;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class Window{
	JFrame frame;
	JPanel contentPane;
	private static GameState game;
	public final int ENTRY = 0;
	public final int SOLVING = 1;
	public int mode;
	
	public static GameState getGameState() {
		return game;
	}
	public int getMode() {
		return mode;
	}
	public void changeMode() {
		if(mode == ENTRY)
			mode = SOLVING;
		else
			mode = ENTRY;
	}
	public static void setGameState(GameState g) {
		game = g;
	}
	
	public Window()
	{
		frame = new JFrame("Sudoku");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		contentPane.add(new Menu());
		frame.setContentPane(contentPane);
		frame.setSize(630, 800);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		setGameState(new GameState(null));
	}
}
