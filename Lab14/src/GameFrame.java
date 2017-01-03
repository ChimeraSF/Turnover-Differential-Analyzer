////////////////////////////////////////////////////////////////////////////////
//  Course:   CSC 151 Spring 2014
//  Section:  (your section number)
// 
//  Project:  Lab14
//  File:     GameFrame.java
//  
//  Name:     Shaylene Frank
//  Email:    (your Wake Tech Email Address)
////////////////////////////////////////////////////////////////////////////////

/**
 * (Insert a comment that briefly describes the purpose of this class definition.)
 *
 * <p/> Bugs: (List any known issues or unimplemented features here)
 * 
 * @author (Insert your first and last name)
 *
 */
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.border.Border;

public class GameFrame
{
	public static void main(String[] args) 
	{
		JFrame frame = new JFrame("Turnover Differential Analyzer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		GamePrimer panel = new GamePrimer();
		Border b1 = BorderFactory.createRaisedBevelBorder();
		Border b2 = BorderFactory.createEmptyBorder(8, 8, 8, 8);
		panel.setBorder(BorderFactory.createCompoundBorder(b2, b1));
		panel.setBackground(Color.LIGHT_GRAY);
		
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
	}
}
