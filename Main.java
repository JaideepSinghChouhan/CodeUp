/**
 * @filename- Main.java
 * @description- Main Class to use other classes and their methods.
 * @author- JD
 */

import java.util.Scanner;



public class Main {
    
    
    public static void main(String[] args) {
        System.out.println("Enter Your String: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        MyString myString = new MyString(input);
        System.out.println("Original string: " + myString.toString());
        //Append
        System.out.println("Enter the string to append: ");
        String toAppend = scanner.nextLine();
        System.out.println("After append: " + myString.append(toAppend));
        //Count words
        System.out.println("Word count: " + myString.countWords());
        //Replace characters
        System.out.println("After replace: " + myString.replace("o", "0"));
        //Check palindrome
        System.out.println("Enter a string to check if it's a palindrome: ");
        String palInput = scanner.nextLine();
        MyString palString = new MyString(palInput);
        System.out.println("Is palindrome: " + palString.isPalindrome());
        //splice
        System.out.println("Enter a string to splice: ");
        String spliceInput = scanner.nextLine();
        MyString spliceString = new MyString(spliceInput);
        System.out.println("Before splice: " + spliceString.toString());
        System.out.println("After splice(7,5): " + spliceString.splice(7, 5));
        // split
        System.out.println("Enter a string to split: ");
        String splitInput = scanner.nextLine();
        MyString splitString = new MyString(splitInput);
        String [] wordStrings = splitString.split(" ");
        System.out.println("Split default (whitespace): " + java.util.Arrays.toString(wordStrings));
        // Most frequent character
        System.out.println("Enter a string to find the most frequent character: ");
        String mostFrequentInput = scanner.nextLine();
        MyString mostFrequentString = new MyString(mostFrequentInput);
        System.out.println("Most frequent char in '" + mostFrequentInput + "': " + mostFrequentString.getmostFrequentChar());
        // Sort
        System.out.println("Enter a string to sort: ");
        String sortInput = scanner.nextLine();
        MyString sortString = new MyString(sortInput);
        System.out.println("Sorted '" + sortInput + "': " + sortString.sort());
        // Shift
        System.out.println("Enter a string to shift: ");
        String shiftInput = scanner.nextLine();
        MyString shiftString = new MyString(shiftInput);
        System.out.println("Before shift: " + shiftString.toString());
        System.out.println("After shift(2): " + shiftString.shift(2));
        //Reverse
        System.out.println("Enter a string to reverse: ");
        String revInput = scanner.nextLine();
        MyString revString = new MyString(revInput);
        System.out.println("Before reverse: " + revString.toString());
        System.out.println("After reverse: " + revString.reverse());

    }
}
