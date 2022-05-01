 package org.preeti;
 import java.io.IOException;
 import java.util.ArrayList;
 import java.io.File;
 import java.io.FileWriter;
 import java.util.Scanner;
 import java.io.PrintWriter;
 import java.util.Arrays;

 /**
  * Main class.
  * 
  * @author KNIME GmbH
  */
 public class Main{

     public static void main(String args[]) {
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


         } catch (IOException e) {
             e.printStackTrace();
             System.exit(0);
         }

         try {
             FileWriter fileWriter = new FileWriter(outFile);
             PrintWriter printWriter = new PrintWriter(fileWriter);
             PrintWriter out = new PrintWriter(outFile);
             lines.forEach((line) -> {
                 printWriter.printf(line + "\n");
             });
             printWriter.close();


         } catch (IOException e) {
             e.printStackTrace();
             System.exit(0);
         }
     }

     static int reverseNumber(int number) {
         int reverse = 0;
         while (number != 0) {
             int remainder = number % 10;
             reverse = reverse * 10 + remainder;
             number = number / 10;
         }
         return reverse;
     }

     static String reverseString(String str) {
         String reversedStr = "";
         for (int i = str.length() - 1; i >= 0; i--) {
             char ch = str.charAt(i);
             reversedStr += ch;
         }
         return reversedStr;

     }
     

 }
