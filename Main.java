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
        System.out.println(myString.append(" How are you?"));
        //Count words
        System.out.println("Word count: " + myString.countWords());
        //Replace characters
        System.out.println("After replace: " + myString.replace("o", "0"));
        //Check palindrome
        MyString palString = new MyString("racecar");
        System.out.println("Is palindrome: " + palString.isPalindrome());
        //splice
        MyString spliceString = new MyString("Hello, World!");
        System.out.println("Before splice: " + spliceString.toString());
        System.out.println("After splice(7,5): " + spliceString.splice(7, 5));
        // split
        MyString intro = new MyString("My name is JD");
        String [] wordStrings = intro.split(" ");
        System.out.println("Split default (whitespace): " + java.util.Arrays.toString(wordStrings));
        // Most frequent character
        MyString Success = new MyString("success");
        System.out.println("Most frequent char in 'Success': " + Success.getmostFrequentChar());
        // Sort
        System.out.println("Sorted 'Success': " + Success.sort());
        // Shift
        MyString shiftString = new MyString("abcdef");
        System.out.println("Before shift: " + shiftString.toString());
        System.out.println("After shift(2): " + shiftString.shift(2));
        //Reverse
        MyString revString = new MyString("abcdef");
        System.out.println("Before reverse: " + revString.toString());
        System.out.println("After reverse: " + revString.reverse());

    }
}
