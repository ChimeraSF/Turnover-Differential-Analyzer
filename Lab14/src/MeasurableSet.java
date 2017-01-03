////////////////////////////////////////////////////////////////////////////////
//  Course:   CSC 151 Spring 2014
//  Section:  0001
// 
//  Project:  Lab11
//  File:     MeasurableSet.java
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
import java.util.ArrayList;

public class MeasurableSet
{
	ArrayList<Measurable> MeasurableSet = new ArrayList<Measurable>();
	Measurable min, max;
	int count = 0;
	
	public MeasurableSet() {
		
	}
	
	// mutator to add a new Measurable object to the MeasurableSet.  
	// Set min if the object is smaller than any previously seen object, 
	// max if the object is larger than any previously seen object.
	void add(Measurable m)
	{
		MeasurableSet.add(m);
		count++;
		
		min = MeasurableSet.get(0);
		max = MeasurableSet.get(0);
		
		for (Measurable set: MeasurableSet) {
			if (max.getMeasure() < set.getMeasure()) {
				max = set;
			}
			
			if (min.getMeasure() > set.getMeasure()) {
				min = set;
			} 
		}
	
	}
	
	public int getCount() {
		return count;
	}
	

	// accessor to return the min object
	public Measurable getMin()
	{
		return min;
	}

	// accessor to return the max object
	public Measurable getMax()
	{
		return max;
	}

	// accessor to return the Measurable objects in the MeasurableSet whose Measurable value is greater than or equal to floor, and less than or equal to ceiling
	public int getMiddle(int floor, int ceiling)
	{
		int count = 0;
		
		for (Measurable set: MeasurableSet) {
			if (set.getMeasure() >= floor && set.getMeasure() <= ceiling) {
				count++;
			}
		}
		
		return count;
	}
	
	public int getBelow(int floor) {
		int count = 0;
		
		for (Measurable set: MeasurableSet) {
			if (set.getMeasure() < floor) {
				count++;
			}
		}
		
		return count;
	}
	
	public int getAbove(int ceiling) {
		int count = 0;
		
		for (Measurable set: MeasurableSet) {
			if (set.getMeasure() > ceiling) {
				count++;
			}
		}
		
		return count;
	}
}
