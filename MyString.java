/**
 * @filename-MyString.java
 * @description-A custom string manipulation class with various methods.
 * @author-JD
 */

import java.util.ArrayList;
import java.util.Arrays;

public class MyString {
    private String value;

    public MyString(String words) {
        this.value = words;
    }

    @Override
    public String toString() {
        return this.value;
    }

    String append(String str1) {
        String toAppend = (str1 == null) ? "" : str1;
        if (this.value == null) {
            this.value = toAppend;
        } else {
            this.value = this.value + toAppend;
        }
        return this.value;
    }

    public String replace(String firstString, String secondString) {

        if (firstString == null || firstString.length() == 0 || secondString == null || secondString.length() == 0) {
            return this.value;
        }
        if (this.value == null) {
            return null;
        }
        //If `firstString` or `secondString` has length > 1, use only the first character.
        char oldChar = firstString.charAt(0);
        char newChar = secondString.charAt(0);
        this.value = this.value.replace(oldChar, newChar);
        return this.value;
    }
    
    public String splice(int start, int length) {
        if (this.value == null) {
            return null;
        }
        if (length <= 0) {
            return this.value;
        }

        if (start >= this.value.length()) {
            return this.value;
        }

        int end = start + length;
        if (end > this.value.length()) {
            end = this.value.length();
        }
        // Build new string without the specified substring
        this.value = this.value.substring(0, start) + this.value.substring(end);
        return this.value;
    }
    
    public String[] split(String pattern) {
        ArrayList<String> list=new ArrayList<>();
        int i=0;
        String string="";
        while(i<this.value.length()-pattern.length()+1){
            boolean flag=true;
            for(int j=0;j<pattern.length();j++){
                if(this.value.charAt(i+j)!=pattern.charAt(j)){
                    flag=false;
                    break;
                }
            }    
                if(flag){
                    list.add(string);
                    string="";
                    i+=pattern.length();
                }
                else{
                  string+=this.value.charAt(i);
                  i++;
                }
            }


       while(i<this.value.length())
            string+=this.value.charAt(i++);

        list.add(string);
       return list.toArray(new String[0]);
    }


    
    int countWords(){
        if (this.value == null || this.value.isEmpty()) {
            return 0;
        }
        String[] words = this.value.trim().split("\\s+");
        return words.length;
    }

    boolean isPalindrome() {
        if (this.value == null) {
            return false;
        }
        int left = 0, right = this.value.length() - 1;
        while (left < right) {
            if (this.value.charAt(left) != this.value.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    char getmostFrequentChar() {
        if (this.value == null || this.value.isEmpty())
            return ' ';

        String s = this.value.toLowerCase();
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
        if (this.value == null || this.value.isEmpty()) {
            return this.value;
        }

        char[] chars = this.value.toCharArray();

        Arrays.sort(chars);

        return new String(chars);
    }

    String shift( int n) {
        if (this.value == null || this.value.isEmpty()) {
            return this.value;
        }

        int len = this.value.length();
        n = n % len;
        String shifted = this.value.substring(n) + this.value.substring(0, n);

        return shifted;
    }

    String reverse() {
        if (this.value == null || this.value.isEmpty()) return this.value;

        char[] characters = this.value.toCharArray();
        int i = 0, j = characters.length - 1;

        while (i < j) {
            // Swap characters at positions i and j
            char temp = characters[i];
            characters[i] = characters[j];
            characters[j] = temp;

            i++;
            j--;
        }

        return new String(characters);
    }
}    