////////////////////////////////////////////////////////////////////////////////
//  Course:   CSC 151 Spring 2014
//  Section:  (your section number)
// 
//  Project:  Lab13
//  File:     GamePrimer.java
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
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;
import javax.swing.border.*;


public class GamePrimer extends JPanel
{	
	JPanel mp, ip, gp;
	JLabel lowResult, numResult, highResult;
	JLabel floorResult, betweenResult, ceilingResult;
	JTextField floor, ceiling;
	
	public GamePrimer()
	{
		setLayout(new BorderLayout());
		
		//--------------------
		// Stats Panel
		//--------------------
		mp = new JPanel();
		mp.setLayout(new GridLayout(2, 3,  0, 30));
		TitledBorder tb1 = BorderFactory.createTitledBorder("Stats");
		mp.setBorder(tb1);
		
		JLabel lowMargin = new JLabel("Worst TO Margin");
		JLabel numGames  = new JLabel("Number of Games");
		JLabel highMargin = new JLabel("Best TO Margin");
		lowResult = new JLabel("");
		numResult  = new JLabel("");
		highResult = new JLabel("");
		
		mp.add(lowMargin);
		mp.add(numGames);
		mp.add(highMargin);
		mp.add(lowResult);
		mp.add(numResult);
		mp.add(highResult);
		
		//--------------------
		// Input Panel
		//--------------------
		
		ip = new JPanel();
		ip.setLayout(new GridLayout(2, 2));
		TitledBorder tb2 = BorderFactory.createTitledBorder("Enter Floor and Ceiling");
		tb2.setTitleJustification(TitledBorder.CENTER);
		ip.setBorder(tb2);
		
		JLabel floorLabel = new JLabel("Floor");
		JLabel ceilingLabel = new JLabel("Ceiling");
		floor = new JTextField(5);
		ceiling = new JTextField(5);
		
		floor.addActionListener(new GameListener());
		ceiling.addActionListener(new GameListener());
		
		ip.add(floorLabel);
		ip.add(ceilingLabel);
		ip.add(floor);
		ip.add(ceiling);
		
		//--------------------
		// Games Panel
		//--------------------
		
		gp = new JPanel();
		gp.setLayout(new GridLayout(2, 3, 0, 30));
		TitledBorder tb3 = BorderFactory.createTitledBorder("Results");
		tb3.setTitleJustification(TitledBorder.RIGHT);
		gp.setBorder(tb3);
		
		JLabel belowFloor = new JLabel("Games Below Floor");
		JLabel gamesBetween  = new JLabel("Games Between");
		JLabel aboveCeiling = new JLabel("Games Above Ceiling");
		floorResult = new JLabel("");
		betweenResult  = new JLabel("");
		ceilingResult = new JLabel("");
		
		gp.add(belowFloor);
		gp.add(gamesBetween);
		gp.add(aboveCeiling);
		gp.add(floorResult);
		gp.add(betweenResult);
		gp.add(ceilingResult);
		
		//--------------------
		// Primer Settings
		//--------------------
		
		add(mp, BorderLayout.NORTH);
		add(ip, BorderLayout.CENTER);
		add(gp, BorderLayout.SOUTH);
		
		setPreferredSize(new Dimension(500, 300));
	}
	

	private class GameListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event) {
			
		String line = null, fileName;
		Scanner file, lineParse;
		int floorNum, ceilingNum;
		
		MeasurableSet set = new MeasurableSet();
		fileName = "TOExtremes.txt";
		String text1 = floor.getText();
		floorNum = Integer.parseInt(text1);
		String text2 = ceiling.getText();
		ceilingNum = Integer.parseInt(text2);
		
		try {
			file = new Scanner(new File("nfl2013gameStatsEd2.txt"));
			PrintWriter outFile = new PrintWriter(fileName);
			
			while (file.hasNextLine()) {
				line = file.nextLine();
				lineParse = new Scanner(line);
				
				int firstItem = lineParse.nextInt();
				String desc = lineParse.nextLine();
				
				Game game1 = new Game(firstItem, desc);
				set.add(game1);
			}
			
			outFile.println("Min: " + set.getMin().getMeasure());
			outFile.println("Max: " + set.getMax().getMeasure());
			outFile.close();
		}
		
			catch (FileNotFoundException e) {
		        System.out.println("File not found.");
		        e.printStackTrace();
		    }
			
			catch (NumberFormatException e) {
				System.out.println("Invalid format: " + line);
				e.printStackTrace();
			}
		
		lowResult.setText(Integer.toString(set.getMin().getMeasure()));
		numResult.setText(Integer.toString(set.getCount()));
		highResult.setText(Integer.toString(set.getMax().getMeasure()));
		floorResult.setText(Integer.toString(set.getBelow(floorNum)));
		betweenResult.setText(Integer.toString(set.getMiddle(floorNum,ceilingNum)));
		ceilingResult.setText(Integer.toString(set.getAbove(ceilingNum)));
		
		// System.out.println("Above Ceiling: " + set.getAbove(4));
		// System.out.println("Below Floor: " + set.getBelow(1));
		// System.out.println("Middle Values: " + set.getMiddle(1, 4));
		// System.out.println("Min: " + set.getMin().getMeasure());
		// System.out.println("Max: " + set.getMax().getMeasure());
		// System.out.println("Num games: " + set.getCount());
		
		}
	}
		

}


