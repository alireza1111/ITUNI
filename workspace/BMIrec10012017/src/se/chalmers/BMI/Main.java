package se.chalmers.BMI;

import java.util.Scanner;

public class Main {
	static Person p= new Person();
	static Operation op= new Operation();
	private static Scanner input;
	public static void main(String[] args) {
		input = new Scanner(System.in);
		System.out.print("Enter the person's weight: ");
		p.setWeight(input.nextInt());
		System.out.println();
		System.out.print("Enter person's height: ");
		p.setHeight(input.nextDouble());
		System.out.println();
		//double res=0.00d;
		double res=op.parse(op.calc(p.getHeight(),  p.getWeight()));
		try{
			System.out.print("The result is "+ res);
		} catch (NumberFormatException e){
			System.out.println("exception!:				"+e);
		}

	}

}
