package project2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
/**
 * <b>COP 3530: Project 2 – Stacks and Priority Queues </b>  
 * <p>
 * This class handles anything related to files.<br>
 * <br>
 * Methods:<br>
 * <br>
 * readCountry: Reads file contents to get country data.<br>
 * setSize: Sets the size of the country array.<br>
 * @author Joshua Leonard
 * @version @version 9/30/2022
 */

public class FileHandler {
	/**
	 * Scans through a csv file and delimits with comma, or a new line character \n.<br>
	 * The first line in the csv file is scanned first as it normally contains a header.
	 * This method will scan each comma separated string and store it directly into a object that will then
	 * be stored into both a priority queue and a stack.<br>
	 * @param file file named to be scanned
	 * @throws IOException this will be caught in main method
	 */
	public void readCountry(String file) throws IOException {
		
        Scanner scanFile = null;
        scanFile = new Scanner(new File(file));
        Country newCountry;
        scanFile.useDelimiter(",|\n");
        scanFile.nextLine();
        int i = 0;
        //scans the file and adds each delimited text to the appropriate category
        while (scanFile.hasNext()) {
            newCountry = new Country(scanFile.next(),scanFile.next(),Double.parseDouble(scanFile.next()),
            		Double.parseDouble(scanFile.next()),Double.parseDouble(scanFile.next()),
            		Double.parseDouble(scanFile.next()),Double.parseDouble(scanFile.next()));
                Project2.countryStack.push(newCountry);
                Project2.countryQueue.insert(newCountry);
                i++;
            }//end while
        scanFile.close();
        }//end readCountry
	/**
	 * Reads a file line by line and increments cnt and returns
	 * cnt for the final size of the array.<br>
	 * @param file file name to be scanned
	 * @return the number of lines counted in the csv file
	 * @throws FileNotFoundException this will be caught in main method
	 */
	public int setSize(String file) throws FileNotFoundException {
		int cnt = 0;
		try(BufferedReader lineCounter = new BufferedReader(new FileReader(file))){
			lineCounter.readLine();
			while(lineCounter.readLine()!= null) {
				cnt++;
			}//end while
			lineCounter.close();
		}catch (IOException e) {
			System.out.println("Cannot read file."+e.getMessage());
		}
		
		return cnt;
	}//end setSize
}

