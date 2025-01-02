/*
 * Author: Joshua Leonard
 * Course: COP3530
 * Project #: 2
 * Title: Stacks and Priority Queues
 * Due Date: 10/7/2022
 *
 * This program demonstrates the use of:
 * 1: Stacks
 * 		a)Setting up Stack class
 * 		b)Pushing
 * 		c)Popping
 * 2: Priority Queues
 * 		a)Setting up Priority Queue class
 * 		b)Inserting
 * 		c)Removing
 * 
 */
package project2;

import java.io.IOException;
import java.util.Scanner;
/**
 * <b>COP 3530: Project 2 – Stacks and Priority Queues </b> 
 * <p>
 * This is the main class file that handles the display menu, reading in the user input for the file
 * creating the stacks and priority queues, and printing formatted strings with country data.
 * @author Josh
 * @version 9/30/2022
 */
public class Project2 {
	
	public static Stack countryStack;//stack
	public static PriorityQ countryQueue;//Priority queue
	private static Scanner scnr = new Scanner(System.in);
	private static FileHandler fileHandler = new FileHandler();
	private static String fileName;
	/**
	 * <b>!Entry Point!</b>
	 * <p>
	 * This is the main function.
	 * <p>
	 * It prints out the the Project #, Who the instructor is, who the student is, students N#:,
	 * and the name of the project.
	 * <p>
	 * The program will loop until a correct file name is given, it will create a new stack and priority queue of country objects with its
	 * size set equal to the number of lines counted in the file.
	 * <p>
	 * If the file was successfully read it will create the stack and priority queue and print out the number of 
	 * records read and call the display menu. After the display menu option 7 is used this class will set the flag to true and
	 * end the program.
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("COP3530 Project 2\nInstructor: Professor Liu\nStudent: Joshua Leonard\nN#: N01476308\nStacks and Priority Queues\n");
		
		
		boolean flag = false;
		while(!flag) {
			try {
				System.out.print("Enter the file name: ");
				fileName = scnr.nextLine();
				int capacity = fileHandler.setSize(fileName);
				countryStack = new Stack(capacity);
				countryQueue = new PriorityQ(capacity);
				fileHandler.readCountry(fileName);
				System.out.println();
				System.out.println("Stack created of "+capacity+" countries. ");
				System.out.println("Priority queue created of "+capacity+" countries.");
				System.out.println();
				displayMenu();
				flag = true;
			}catch (IOException e) {
				System.out.println("File not found: " + e.getMessage());
				}
		}//end while loop
		scnr.close();
	}//end main
	/**
	 * This methods is the display menu, it will loop until the user selects 7 to quit the program. Each input
	 * will call on another method or methods to get the correct data.
	 * <p>
	 * <pre>
	 * 1: Prints the stack from top to bottom
	 * 2: Pop a country object from the stack
	 * 3: Push a country object onto the stack
	 * 4: Print the priority queue from highest priority to lowest
	 * 5: Remove a country object from the priority queue
	 * 6: Insert a country object into the priority queue
	 * 7: Quits program
	 * </pre>
	 */
	public static void displayMenu()
    {
	//variable declarations
    boolean flag = true;
    boolean inputFlag = false;
   
    //Loop user options until user types "7" sets the flag
    // to false will call a new displayMenu.
    do {
        //user options print statements
        System.out.println("Please make a selection: ");
        System.out.println("1) Print the Stack.");
        System.out.println("2) Pop a country object from stack.");
        System.out.println("3) Push a country object onto stack.");
        System.out.println("4) Print priority queue.");
        System.out.println("5) Remove a country object from priority queue.");
        System.out.println("6) Insert a country object into priority queue.");
        System.out.println("7) Exit");
        //prints out what the user selected
        String input = "";
        while(!inputFlag) {
        	input = scnr.nextLine();
        	if(input.matches("1|2|3|4|5|6|7")){
        		inputFlag = true;
        	}else {
        		System.out.print("Invalid Choice! Enter your choice:");
        	}//end if/else
        }//end while
        	inputFlag = false;
        	switch (input) {
            	case "1" : printData("stack");
                	break;
            	case "2" :
            		countryStack.pop();
            		System.out.println("\nOne country is popped from the stack.\n");
            		
            		break;
            	case "3" :nCountry("stack");//NEW COUNTRY
                	break;
            	case "4" :printData("queue");
                	break;
            	case "5" :
            		countryQueue.remove();
            		System.out.println("\nOne country removed from the priority.\n");
            		break;
            	case "6" :nCountry("queue");//NEW COUNTRY
                	break;
            	case "7" : System.out.println("Program Exiting");
                	flag = false;
        	}
    	}while(flag);//end do-while
	}//end displayMenu
	/**
	 * This methods prints out the header followed by dash line to indicate separation.
	 * <p>
	 * The second half of this method will print out each country in the stack or priority in the specified format.
	 * <p>
	 * <b>NAME CAPTIAL GDPPC CASERATE DEATHRATE POPDENS</b>
	 * <p>
	 * @param type String either "stack" or "queue"
	 */
	public static void printData(String type) {
		System.out.println("\n");
		String name = "Name";
		String capital = "Capital";
		String gdppc = "GDPPC";
		String cfr = "CFR";
		String cr = "CaseRate";
		String dr = "DeathRate";
		String den = "PopDensity";
		System.out.printf("%-39s %s %11s %11s %13s %13s %13s\n",name,capital,gdppc,cfr,cr,dr,den);
		System.out.println
		("--------------------------------------------------------------------------------------------------------------------");
		if(type.equals("stack")) {
			countryStack.printStack();
		}else {
			countryQueue.printQueue();
		}
		System.out.println("\n");	
	}//end printData
	/**
	 * This method is used to create a new country object and insert/push it into the priority queue or push to the stack.
	 * <p>
	 * If the user inputs a invalid choice, the variable ic(invalid choice) will be set to true and will inform the user that the choice is invalid
	 * and tell the user to try again.
	 * <p>
	 * If the data the user inputs is valid it will either insert or push the country object onto the stack or priority queue.
	 * @param type String either "stack" or "queue"
	 */
	public static void nCountry(String type) {
		Country newCountry;
		boolean ic = false;
		String name = "";String capital = "";
		double population = 0;double gdp = 0;double cCases = 0;double cDeaths = 0;double area = 0;
		
		
		System.out.print("Enter Name: ");
		name = scnr.nextLine();
		System.out.print("Enter Capital: ");
		capital = scnr.nextLine();
		
		try {
				System.out.print("Enter Population: ");
				population = scnr.nextDouble();
				System.out.print("Enter GDP(USD): ");
				gdp = scnr.nextDouble();
				System.out.print("Enter Covid Cases: ");
				cCases = scnr.nextDouble();
				System.out.print("Enter Covid Deaths: ");
				cDeaths = scnr.nextDouble();
				System.out.print("Enter Area(km2): ");
				area = scnr.nextDouble();
					
			} catch (Exception e) {
					System.out.println("\nInvalid attempt, please enter valid correct data for each choice.");
					ic = true;
					
			}
		
		if(ic == true) {
			System.out.println("Please try again.\n");
		}else {
			newCountry = new Country(name, capital, population, gdp, cCases, cDeaths, area);
			if(type.equals("stack")) {
				countryStack.push(newCountry);
			}else {
				countryQueue.insert(newCountry);
			}
		}
		scnr = new Scanner(System.in);
		System.out.println();
	}//end nCountry

}
