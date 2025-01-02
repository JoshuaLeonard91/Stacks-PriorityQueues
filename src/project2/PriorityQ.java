package project2;
/**
 * <b>COP 3530: Project 2 – Stacks and Priority Queues </b>  
 * <p>
 * This class handles inserting, removing, and printing out the priority queue.<br>
 * <b>Methods:<br></b>
 * <pre>
 * <b>insert</b>     : Inserting items lowest number = highest priority.
 * <b>remove</b>     : Removes highest priority item (Lowest item) O(1).
 * <b>isEmpty</b>    : Checks if the queue is empty.
 * <b>isFull</b>     : Checks if the queue is full.
 * <b>printQueue</b> : Prints the priority queue.
 * </pre>
 * @author Joshua Leonard
 * @version 9/30/2022
 */

public class PriorityQ {
	private int maxSize;
	private Country[] cArray;
	private int nItems;
	/**
	 * <b>Required constructor for project</b>
	 * <p>
	 * Constructor for the priority queue.
	 * <p>
	 * Initializes the maxSize, number of items,rear and creates the array with the maxSize variable.
	 * @param capacity the capacity of the array
	 */
	public PriorityQ(int capacity) {
		maxSize = capacity; nItems = 0;
		this.cArray = new Country[maxSize];
	}//end prioQueue
	/**
	 * <b>Required method for project</b>
	 * <p>
	 * This method inserts a new country object into the appropriate position based on its priority.<br>
	 * <p>
	 * If the priority queue is already at max size it will clone the array to a temp array, double maxSize, create a new 
	 * cArray with the doubled maxSize and add the contents from the temp array back into the new larger array. This method will also
	 * increment rear which is used for the peekMethod.
	 * @param item Country object created by the user
	 */
	public void insert(Country item) {
		
		if(isFull()) {
			Country[] temp = new Country[maxSize];
			temp = cArray.clone();
			maxSize = maxSize*2;
			cArray = new Country[maxSize];
			for(int i = 0;i<temp.length;i++) {
				cArray[i] = temp[i];
			}
		}
		
		int j;
		if(nItems == 0) {
			cArray[nItems++] = item;
		}else {
			for(j = nItems-1;j>=0;j--) {
				if(item.getCFR() > cArray[j].getCFR()){
					cArray[j+1] = cArray[j];
				}else {
					break;
				}
			}
			cArray[j+1] = item;
			nItems++;
		}
	}//end insert
	/**
	 * <b>Required method for project</b>
	 * <p>
	 * This method will remove a country object from the queue and return it. If the queue is empty it returns null 
	 * and prints that the queue is empty. It will also decrement rear, which is used for the peekRear method.
	 * @return The removed object
	 */
	public Country remove() {//remove min item
		if(isEmpty()) {
			System.out.println("Priority queue is empty.");
			return null;
		}else {
			return cArray[--nItems];
		}
	}//end remove
	/**
	 * <b>Required method for project</b>
	 * <p>
	 * Checks if the priority queue is empty.
	 * @return true or false
	 */
	public boolean isEmpty() {//true of queue is empty
		return (nItems==0);
	}//end isEmpty
	/**
	 * <b>Required method for project</b>
	 * <p>
	 * Checks if the priority queue is full.
	 * @return true or false
	 */
	public boolean isFull() {//true if queue is full
		return (nItems==maxSize);
	}//end isFull
	/**
	 * <b>Required method for project</b>
	 * <p>
	 * This method will print the priority queue from the highest priority to the lowest.
	 */
	public void printQueue() {
		for(int i = nItems-1;i>=0;i--) {
			System.out.println(cArray[i].getData());
		}
	}//end printQueue
}//end class Queue

