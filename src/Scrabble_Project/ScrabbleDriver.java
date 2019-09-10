package Scrabble_Project;

import java.util.Scanner;
import java.io.IOException;

public class ScrabbleDriver{
  public static void main(String args[]) 
  {
    try{
      Scanner s = new Scanner(System.in);
      System.out.println("Enter the file name:");
      String fileName = s.nextLine();
      TextFileAccessor scrab = new MaxScrabbleScore();
      scrab.openFile(fileName);
      scrab.processFile();
      System.out.println(scrab.getReportStr());
    }
    catch(IOException ioex)
    {System.out.println(ioex);}
  }
}