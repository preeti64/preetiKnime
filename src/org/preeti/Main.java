 package org.preeti; 
 import java.io.IOException;
 import java.util.ArrayList;
 import java.io.File;
 import java.io.FileWriter;
 import java.util.Scanner;
 import java.io.PrintWriter;
 import java.lang.Thread;
 

 /**
  * Main class.
  * 
  * @author KNIME GmbH
  */
 public class Main{
     /**
      * Argument and accessor of main args(arguments) to be used in the Thread Class
      */
     private static String[] savedArgs;
     public static String[] getArgs() {
         return savedArgs;
         }
        
     public static void main(String args[]) {
    	 
    	/**
    	 * Saving the args for later use
    	 */
        savedArgs = args;
        Thread claOperations = new ClaOperations();
        claOperations.start();	   
     }
 }

 class ClaOperations extends Thread {      
      public void run(){  
    	  // Getting the arguments passed as Command Line Arguments to the Main Class
          String[] args = Main.getArgs();
          /**
           * Assigning arguments to variables for better understanding 
           * inFile will have the value at args[1]for the given input file
           * outFile will have the value at args[1]for the given input file
           * inputType specifies the type of input being passed (string|int|double)
           * operations specifies the type of operation(rev|cap|neg) for each inputtype (string|int|double)
           */
         ArrayList<String> lines = new ArrayList<>();
         String output = "";
         String text = "";
         String inFile = args[1];
         String outFile = args[9];
         String inputType = args[3];
         String operations = args[5];
         File file = new File(inFile);
        try {
             String num = "";
             Scanner in = new Scanner(file);
             while ( in .hasNextLine()) {
                 String line = in .nextLine();
                 //Checking for the input type of File
                 if (inputType.equals("int") || (inputType.equals("double"))) {
                     num = line;
                     output = num;
                     if (operations.contains("rev")) {
                         output = String.valueOf(reverseNumber(Integer.parseInt(num)));
                     }

                     if (operations.contains("neg")) {
                         int negativenumber = Integer.parseInt(output) * -1;
                         String negativeNumber = String.valueOf(negativenumber);
                         output = negativeNumber;

                     }
                     lines.add(output);
                 }

                 if (inputType.equals("string")) {
                     text = line;
                     output = text;

                     if (operations.contains("rev")) {
                         output = reverseString(text);
                     }

                     if (operations.contains("cap")) {
                         output = output.toUpperCase();

                     }
                     lines.add(output);
                 }
                 
             }
             in.close();

         } catch (IOException e) {
             e.printStackTrace();
             System.exit(0);
         }

         try {
             FileWriter fileWriter = new FileWriter(outFile);
             PrintWriter printWriter = new PrintWriter(fileWriter);
             lines.forEach((line) -> {
                 printWriter.printf(line + "\n");
             });
             printWriter.close();


         } catch (IOException e) {
             e.printStackTrace();
             System.exit(0);
         }
     }
     /**
      * 
      * @param number takes the number as input from the File
      * @return the reversed number
      */
      int reverseNumber(int number) {
         int reverse = 0;
         while (number != 0) {
             int remainder = number % 10;
             reverse = reverse * 10 + remainder;
             number = number / 10;
         }
         return reverse;
     }
      /**
       * 
       * @param str takes string as input from the File
       * @return the reversed string
       */
      String reverseString(String str) {
         String reversedStr = "";
         for (int i = str.length() - 1; i >= 0; i--) {
             char ch = str.charAt(i);
             reversedStr += ch;
         }
         return reversedStr;

     }
     
           }
       
       
