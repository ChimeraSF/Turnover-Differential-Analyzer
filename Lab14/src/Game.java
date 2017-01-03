////////////////////////////////////////////////////////////////////////////////
//  Course:   CSC 151 Spring 2014
//  Section:  (your section number)
// 
//  Project:  Lab13
//  File:     Game.java
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
public class Game implements Measurable
{
	private int turnovers;
	private String description;
	
	public Game(int t, String d) {
		turnovers = t;
		description = d;
	}

	public int getMeasure() {
		return turnovers;
	}
	
	public String getDesc() {
		return description;
	}

	public String toString() {
		return "Turnover: " + turnovers + "/n" +
				"Description: " + description;
	}
}
