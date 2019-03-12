package sudoku;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PopUp{
	
	JFrame frame;
	JPanel contentPane;
	JButton rollDie;
	private int answer = 0;
	boolean yesnt;
	
	PopUp(String query, String yesAnswer, String noAnswer) {
		
		JOptionPane x = new JOptionPane();
		String[] options = {yesAnswer,noAnswer};
		answer = x.showOptionDialog(frame,query,"Please Answer Before Proceeding",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
	
		if(answer == JOptionPane.YES_OPTION) {
			yesnt = true;
			
		}else {
			yesnt = false;
		}
	
	}
	
	public boolean getAnswer() {
		return yesnt;
	}

}
	
	
	