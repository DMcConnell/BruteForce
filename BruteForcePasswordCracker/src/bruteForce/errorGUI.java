package bruteForce;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class ErrorGui extends JFrame
{
	static JLabel errorMessage;
	static JButton button;
	static JPanel panel, bottom;
	
	public ErrorGui()
	{
		event listener = new event();
		errorMessage = new JLabel("  Your password did not fufill the rule requirements!  ");
		button = new JButton("Okay");
		button.addActionListener(listener);
		panel = new JPanel();
		bottom = new JPanel();
		bottom.setLayout(new FlowLayout());
		panel.setLayout(new BorderLayout());
		bottom.add(button);
		panel.add(errorMessage, BorderLayout.NORTH);
		panel.add(bottom, BorderLayout.SOUTH);
		add(panel);
	}
	
	public class event implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			dispose();
		}
	}
}
