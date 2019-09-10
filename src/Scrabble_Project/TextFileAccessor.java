package Scrabble_Project;

import java.util.Scanner;
import java.io.IOException;
import java.io.FileReader;


public abstract class TextFileAccessor {
	protected String fileName;
	protected Scanner scan; 
   
   //Write the openFile method that returns nothing and accepts the file name as a paramter and assigns the file to the Scanner object scan

   //Write the processFile method which takes no parameters and hands each line to the processLine method in a loop before closing the Scanner
   
	protected abstract void processLine(String line);
   
   public abstract String getReportStr();

}



