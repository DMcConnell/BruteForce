package bruteForce;

import javax.swing.*;
import java.awt.*;

public class crackingGUI extends JFrame
{
	static JPanel panel, centered;
	static JLabel label;
	
	public crackingGUI(String solution)
	{
		panel = new JPanel();
		centered = new JPanel();
		panel.setLayout(new BorderLayout());
		centered.setLayout(new FlowLayout(FlowLayout.CENTER));
		label = new JLabel(solution);
		centered.add(label);
		panel.add(centered, BorderLayout.CENTER);
		add(panel);
	}
}
