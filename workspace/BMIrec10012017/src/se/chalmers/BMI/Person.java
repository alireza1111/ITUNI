package se.chalmers.BMI;

/**
 * This class specifies the individual person's body charactristics
 * and check if he is alive or not!
 * @author alidav
 *
 */

public class Person {
	
	private int weight=2; //person's weight in kg
	private double height;  //person's height in meters
/**
 * cunstructor: initialize values 
 */
	public Person(){
		
/*		weight= 0;
		height= 0;*/
	}
public int getWeight() {
	return weight;
}
public void setWeight(int weight) {
	this.weight = weight;
}
public double getHeight() {
	return height;
}
public void setHeight(double d) {
	this.height = d;
}
/*private boolean isDead(){
	if
}*/
}
