import java.util.Arrays;
import java.util.Scanner;

public class MyString {
    private String str;

    public MyString(String str) {
        this.str = str;
    }

    String append(String str1) {
        String toAppend = (str1 == null) ? "" : str1;
        if (this.str == null) {
            this.str = toAppend;
        } else {
            this.str = this.str + toAppend;
        }
        return this.str;
    }
    
    public String replace(String a, String b) {
    
        if (a == null || a.length() == 0 || b == null || b.length() == 0) {
            return this.str;
        }
        if (this.str == null) {
            return null;
        }
        //If `a` or `b` has length > 1, use only the first character.
        char oldChar = a.charAt(0);
        char newChar = b.charAt(0);
        this.str = this.str.replace(oldChar, newChar);
        return this.str;
    }
    
    public String splice(int start, int length) {
        if (this.str == null) {
            return null;
        }
        if (length <= 0) {
            return this.str;
        }
        
        if (start >= this.str.length()) {
            return this.str;
        }

        int end = start + length;
        if (end > this.str.length()) {
            end = this.str.length();
        }
        // Build new string without the specified substring
        this.str = this.str.substring(0, start) + this.str.substring(end);
        return this.str;
    }
    
    public String[] split(String pattern) {
        if (pattern == null || pattern.isEmpty()) {
            return str.trim().split("\\s+");
        }
        return str.split(pattern);
    }


    
    int countWords(){
        if (str == null || str.isEmpty()) {
            return 0;
        }
        String[] words = str.trim().split("\\s+");
        return words.length;
    }

    boolean isPalindrome() {
        if (str == null) {
            return false;
        }
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    char mostFrequentChar() {
        if (this.str == null || this.str.isEmpty())
            return ' ';

        String s = this.str.toLowerCase();
        int[] freq = new int[256];
        int maxFreq = 0;
        char result = ' ';

        for (char c : s.toCharArray()) {
            freq[c]++;
            if (freq[c] > maxFreq) {
                maxFreq = freq[c];
                result = c;
            }
        }
        return result;
    }

    String sort() {
        if (this.str == null || this.str.isEmpty()) {
            return this.str;
        }

        char[] chars = this.str.toCharArray();

        Arrays.sort(chars);

        return new String(chars);
    }

    String shift( int n) {
        if (this.str == null || this.str.isEmpty()) {
            return this.str;
        }

        int len = this.str.length();
        n = n % len;
        String shifted = this.str.substring(n) + this.str.substring(0, n);

        return shifted;
    }

    String reverse() {
        if (this.str == null || this.str.isEmpty()) return this.str;

        char[] chars = this.str.toCharArray();
        int i = 0, j = chars.length - 1;

        while (i < j) {
            // Swap characters at positions i and j
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;

            i++;
            j--;
        }

        return new String(chars);
    }



    public static void main(String[] args) {
        System.out.println("Enter Your String: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        MyString myString = new MyString(input);
        System.out.println("Original string: " + myString.str);
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
        System.out.println("Before splice: " + spliceString.str);
        System.out.println("After splice(7,5): " + spliceString.splice(7, 5));
        // split
        MyString intro = new MyString("My name is JD");
        String [] wordStrings = intro.split(null);
        System.out.println("Split default (whitespace): " + java.util.Arrays.toString(wordStrings));
        // Most frequent character
        MyString Success = new MyString("Success");
        System.out.println("Most frequent char in 'Success': " + Success.mostFrequentChar());
        // Sort
        System.out.println("Sorted 'Success': " + Success.sort());
        // Shift
        MyString shiftString = new MyString("abcdef");
        System.out.println("Before shift: " + shiftString.str);
        System.out.println("After shift(2): " + shiftString.shift(2));
        //Reverse
        MyString revString = new MyString("abcdef");
        System.out.println("Before reverse: " + revString.str);
        System.out.println("After reverse: " + revString.reverse());

    }
    
}    