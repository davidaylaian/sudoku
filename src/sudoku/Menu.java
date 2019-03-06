package sudoku;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Menu extends JPanel implements ActionListener{
	JLabel fileName;
	JButton hint, undo, redo, gen, solve, save, open;
	JRadioButton a,b;
	JLabel entry, solving;
	public Menu() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(10, 10, 10, 10);
		
		fileName = new JLabel();
		hint = new JButton("Hint");
		hint.setActionCommand("Hint");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		this.add(hint, c);
		
		undo = new JButton("Undo");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 0;
		this.add(undo, c);
		
		redo = new JButton("Redo");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3;
		c.gridy = 0;
		this.add(redo, c);
		
		c.insets = new Insets(0, 0, 0, 0);
		a = new JRadioButton();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 4;
		c.gridy = 0;
		this.add(a, c);
		
		entry = new JLabel("Entry");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 5;
		c.gridy = 0;
		this.add(entry, c);
		
		c.insets = new Insets(10, 10, 10, 10);
		gen = new JButton("Generate");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		this.add(gen, c);
		
		solve = new JButton("Solve");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
		this.add(solve, c);
		
		save = new JButton("Save");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 1;
		this.add(save, c);
		
		open = new JButton("Open");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3;
		c.gridy = 1;
		this.add(open, c);
		
		c.insets = new Insets(0, 0, 0, 0);
		b = new JRadioButton();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 4;
		c.gridy = 1;
		this.add(b, c);
		
		solving = new JLabel("Solving");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 5;
		c.gridy = 1;
		this.add(solving, c);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String eventName = e.getActionCommand();
	}

}





