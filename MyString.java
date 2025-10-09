/**
 * @filename-MyString.java
 * @description-A custom string manipulation class with various methods.
 * @author-JD
 */

import java.util.ArrayList;
import java.util.Arrays;

public class MyString {
    private String str;

    public MyString(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return this.str;
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
        ArrayList<String> list=new ArrayList<>();
        int i=0;
        String str="";
        while(i<this.str.length()-pattern.length()+1){
            boolean flag=true;
            for(int j=0;j<pattern.length();j++){
                if(this.str.charAt(i+j)!=pattern.charAt(j)){
                    flag=false;
                    break;
                }
            }    
                if(flag){
                    list.add(str);
                    str="";
                    i+=pattern.length();
                }
                else{
                  str+=this.str.charAt(i);
                  i++;
                }
            }


       while(i<this.str.length())
            str+=this.str.charAt(i++);

        list.add(str);
       return list.toArray(new String[0]);
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
}    
