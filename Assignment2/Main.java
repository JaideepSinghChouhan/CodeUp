package Assignment2;

/**
 * @filename- Main.java
 * @description- Main Class to use other classes and their methods.
 * @author- JD
 */

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyNumbers numbers = new MyNumbers();
        while(true)
        {
            System.out.println("\nMenu:");
            System.out.println("1. Find Fibonacci of a number");
            System.out.println("2. Check if a number is prime");
            System.out.println("3. Convert number to words");
            System.out.println("4. Convert binary to decimal");
            System.out.println("5. Count unique palindromic substrings");
            System.out.println("6. Convert snake_case to camelCase");
            System.out.println("7. Count consonants in a string");
            System.out.println("8. Expand a compressed string");
            System.out.println("9. Compress a string");
            System.out.println("10. Find length of longest unique substring");
            System.out.println("11. Exit");

            System.out.println("\n Now enter your choice:");
            int choice = scanner.nextInt();
            
            switch(choice)
            {
         case 1:
         System.out.println("Enter a number to find its Fibonacci value:");
         int n = scanner.nextInt();
         System.out.println("Fibonacci of " + n + " is: " + numbers.getNthFibonacci(n));
         break;
         case 2:
            System.out.println("Enter a number to check if it's prime:"); 
            int m = scanner.nextInt();
            System.out.println(m + " is prime: " + numbers.isPrime(m));
            break;
         case 3:
            System.out.println("Enter a number to convert to words:(Range is 1 to 10000)");
            int num = scanner.nextInt();
            System.out.println("Number in words: " + numbers.toWords(num));
            break;
         case 4:
            System.out.println("Enter a binary number to convert to decimal:");
            String binary = scanner.next();
            System.out.println("Decimal value: " + numbers.getBinaryToDecimal(binary));
            break;
         case 5:
              System.out.println("Enter a string to count unique palindromic substrings:");
                scanner.nextLine(); // Consume newline
                String str = scanner.nextLine();
                MyString myString = new MyString(str);
                System.out.println("Count of unique palindromic substrings: " + myString.countUniquePalindromes());
                break;       
         case 6:
                System.out.println("Enter a snake_case string to convert to camelCase:");          
                scanner.nextLine(); // Consume newline
                String snakeStr = scanner.nextLine();
                MyString snakeString = new MyString(snakeStr);
                System.out.println("CamelCase: " + snakeString.snakeToCamelCase());
                break;
         case 7:
               System.out.println("Enter a string to count consonants:");
               scanner.nextLine(); // Consume newline
               String consonantStr = scanner.nextLine();
               MyString consonantString = new MyString(consonantStr);
               System.out.println("Count of consonants: " + consonantString.countConsonants());
               break;
         case 8:
                System.out.println("Enter a compressed string to expand it:");
                scanner.nextLine(); // Consume newline
                String compressedStr = scanner.nextLine();
                MyString compressedString = new MyString(compressedStr);
                System.out.println("Expanded: " + compressedString.expand(compressedStr));
                break;
         case 9:   
                  System.out.println("Enter a string to compress it:");
                  scanner.nextLine(); // Consume newline
                  String toCompressStr = scanner.nextLine();
                  MyString toCompressString = new MyString(toCompressStr);
                  System.out.println("Compressed: " + toCompressString.compress(toCompressStr));
                  break;
         case 10:
            System.out.println("Enter a string to find the length of the longest unique substring:");
            scanner.nextLine(); // Consume newline
            String uniqueStr = scanner.nextLine();
            MyString uniqueString = new MyString(uniqueStr);
            System.out.println("Length of longest unique substring: " + uniqueString.getLengthOfLongestUniqueSubstring(uniqueStr));
            break;

         case 11:
            System.out.println("Exiting...");
            scanner.close();
            System.exit(0);
            break;   
         default:
            System.out.println("Invalid choice. Please try again.");
            break;
            }      
        }

    }
}
