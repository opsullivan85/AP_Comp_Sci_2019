package Scrabble_Project;

import java.io.File;
import java.util.Scanner;
import java.io.IOException;


abstract class TextFileAccessor {
	private Scanner scan;

	//Write the openFile method that returns nothing and accepts the file name as a
	// parameter and assigns the file to the Scanner object scan
	public void openFile(String fileName) throws IOException{

		this.scan = new Scanner(new File(fileName));
	}

   //Write the processFile method which takes no parameters and hands each line to
   //the processLine method in a loop before closing the Scanner
   void processFile(){
		while (scan.hasNextLine()){
			this.processLine(scan.nextLine());
		}
		scan.close();
	}

	protected abstract void processLine(String line);
	public abstract String getReportStr();

}



