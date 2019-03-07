package sudoku;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class Window
{
	JFrame frame;
	JPanel contentPane;
	public Window()
	{
		frame = new JFrame("Sudoku");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		contentPane.add(new Menu());
		frame.setContentPane(contentPane);
		frame.setSize(800, 800);
		frame.setVisible(true);
	}
}
