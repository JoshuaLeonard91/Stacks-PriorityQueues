package project2;
/**
 * <b>COP 3530: Project 2 – Stacks and Priority Queues </b>  
 * <p>
 * This class handles pushing, popping, and printing the stack.<br>
 * <p>
 * <pre>
 * <b>push</b>        : push(add) country object
 * <b>pop</b>         : pop(remove) country object
 * <b>isFull</b>      : checks if the stack is full
 * <b>isEmpty</b>     : checks if the stack is empty
 * <b>printStack</b>  : prints out the entire stack
 * </pre>
 * @author Joshua Leonard
 * @version 9/30/2022
 */
public class Stack {
	
	Country[] cArray;
	int top = -1;
	int maxSize;
	/**
	 * <b>Required method for project</b>
	 * <p>
	 * Constructor for the stack.
	 * <p>
	 * Initializes maxSize and the country array of objects.
	 * @param capacity the capacity of the array
	 */
	public Stack(int capacity) {
		this.maxSize = capacity;
		this.cArray = new Country[maxSize];
	}
	/**
	 * <b>Required method for project</b>
	 * <p>
	 * This method pushes a country object to the stack.
	 * <p>
	 * If the stack is full it clone the country array of objects to temp, double the maxSize variable
	 * and create a new cArray stack with the new size and add the contents from the temp country array back.
	 * At the end it will increment the top and push the item.
	 * @param item Country object created by the user
	 */
	public void push(Country item) {
		if(isFull()) {
			Country[] temp = new Country[maxSize];
			temp = cArray.clone();
			maxSize = maxSize*2;
			cArray = new Country[maxSize];
			for(int i = 0;i<temp.length;i++) {
				cArray[i] = temp[i];
			}
		}
		this.cArray[++top] = item;
	}//end push
	/**
	 *<b>Required method for project</b>
	 *<p>
	 * This method will pop the stack, the top and then decrement the counter. If the stack is empty it will
	 * return null and print out the stack is empty.
	 * @return The popped object (removed object)
	 */
	public Country pop() {
		if(isEmpty()) {
			System.out.println("Stack is empty.");
			return null;
		}else {
			return cArray[top--];
		}
	}//end pop
	/**
	 * <b>Required method for project</b>
	 * <p>
	 * This method will print the stack from top to bottom.
	 */
	public void printStack() {
		for(int i = top; i >=0 ;i--) {
			System.out.println(cArray[i].getData());
		}
	}//end printStack
	/**
	 * <b>Required method for project</b>
	 * <p>
	 * Checks if the stack is empty.
	 * @return true or false
	 */
	public boolean isEmpty() {
		return (top == -1);
	}//end isEmpty
	/**
	 * <b>Required method for project</b>
	 * <p>
	 * Checks if the stack is full.
	 * @return true or false
	 */
	public boolean isFull() {
		return (top == maxSize-1);
	}//end isFull
}//end class Stack