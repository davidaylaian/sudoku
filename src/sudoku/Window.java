package sudoku;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window
{
	JFrame frame;
	JPanel contentPane;

	// true = solving, entry = false
	public static boolean mode;

	public static boolean getMode() {
		return mode;
	}

	public static void entryMode() {
		mode = false;
	}

	public static void solvingMode() {
		mode = true;
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
		contentPane.add(new BoardPanel());

		frame.setVisible(true);
		frame.pack();

		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((int) ((screen.width/2) - (frame.size().getWidth()/2)), (int) ((screen.height/2) - (frame.size().getHeight()/2)));
		frame.setLocationRelativeTo(null);

		entryMode();
		menu.updateUndoRedo();
	}
}
