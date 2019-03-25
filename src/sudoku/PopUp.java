package sudoku;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PopUp implements ActionListener{
	
	JFrame frame;
	JPanel contentPane;
	JPanel loadingPane;
	
	JButton upValButton;
	JButton downValButton;
	JButton OK, Cancel;
	
	JLabel valueDisplay;
	JLabel epic, loadingLabel;
	
	private int answer = 0;
	boolean yesnt;
	private int hints = 0;
	private String queryStore;
	
	// enter "" for noAnswer to not have a no option
	PopUp(String query, String yesAnswer, String noAnswer) {
		String[] options;
		if(!noAnswer.equals("")) {
			options = new String[2];
			options[0] = yesAnswer;
			options[1] = noAnswer;
			answer = JOptionPane.showOptionDialog(
					frame,
					query,
					"Please Answer Before Proceeding",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null,
					options,
					options[0]
			);
		}else {
			options = new String[1];
			options[0] = yesAnswer;
			answer = JOptionPane.showOptionDialog(
					frame,
					query,
					"Please Answer Before Proceeding",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.WARNING_MESSAGE,
					null,
					options,
					options[0]
			);
		}
	
		yesnt = answer == JOptionPane.YES_OPTION;
	}

	//use this constructor for getting hints wanted (generate button)
	PopUp(String query)
	{
		queryStore = query;
		
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		frame = new JFrame("Answer Before Proceeding");
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(BorderFactory.createEmptyBorder(10, 100, 10, 100));
		contentPane.setBackground(Color.white);
		contentPane.setLayout(new GridLayout(3, 2, 10, 5));
		
		epic = new JLabel(queryStore);
		contentPane.add(epic);
		
		valueDisplay = new JLabel("0");
		contentPane.add(valueDisplay);
		
		downValButton = new JButton("-1");
		downValButton.setActionCommand("-1");
		
		downValButton.setAlignmentX(JButton.RIGHT_ALIGNMENT);
		downValButton.addActionListener(this);
		downValButton.setBackground(Color.WHITE);
		contentPane.add(downValButton);
		
		upValButton = new JButton("+1");
		upValButton.setActionCommand("+1");
		upValButton.setAlignmentX(JButton.LEFT_ALIGNMENT);
		upValButton.addActionListener(this);
		upValButton.setBackground(Color.WHITE);
		contentPane.add(upValButton);
		
		OK = new JButton("OK");
		OK.addActionListener(this);
		OK.setActionCommand("OK");
		contentPane.add(OK);
		
		Cancel = new JButton("Cancel");
		Cancel.addActionListener(this);
		Cancel.setActionCommand("cancel");
		contentPane.add(Cancel);
		
		frame.setContentPane(contentPane);
		frame.pack();
		int frameHeight=contentPane.getHeight();
		int frameWidth=contentPane.getWidth();
		
		loadingPane = new JPanel();
		loadingPane.setBackground(Color.WHITE);
		loadingPane.setPreferredSize(new Dimension(frameWidth,frameHeight));
		loadingPane.setLayout(new GridBagLayout());
		loadingLabel = new JLabel("The Puzzle is Loading...");
		loadingPane.add(loadingLabel);
		frame.setContentPane(loadingPane);
	
		frame.pack();
		
		frame.setLocation((int) ((screen.width/2) - (frame.size().getWidth()/2)), (int) ((screen.height/2) - (frame.size().getHeight()/2)));
	
		frame.setVisible(true);
		
	
	}
	
	public void doneLoading() {
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setContentPane(contentPane);
		frame.pack();
		frame.setLocation((int) ((screen.width/2) - (frame.size().getWidth()/2)), (int) ((screen.height/2) - (frame.size().getHeight()/2)));
	}
	
	public boolean getYesOrNo() {
		return yesnt;
	}
	
	public int getHints() {
		return hints;
	}
	
	public void actionPerformed(ActionEvent event) { 
		String y = event.getActionCommand();
		if(y.equals("+1")) {
			hints += 1;
			valueDisplay.setText(Integer.toString(hints));
		}else if(y.equals("-1")){
			if(hints > 0) {
			hints -= 1;
			valueDisplay.setText(Integer.toString(hints));
			}
		}else if(y.equals("cancel")){
			hints = -1;
			frame.setVisible(false);
		}else {
			frame.setVisible(false);
		}
	}
	
}
