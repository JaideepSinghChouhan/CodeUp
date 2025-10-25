/**
 * @filename-MyString.java
 * @description-A custom string manipulation class with various methods such as counting unique palindromic substrings,           converting snake_case to camelCase, counting consonants, expanding and compressing strings, and finding the length of the longest unique substring.
 * @author-JD
 */
package Assignment2;



import java.util.HashSet;
import java.util.Set;

public class MyString {
    private String value;

    public MyString(String str) {
        this.value = str;
    }

    @Override
    public String toString() {
        return this.value;
    }

    // Helper method to check if a string is a palindrome
    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Count the number of unique palindromic substrings
    public int countUniquePalindromes() {
        if (this.value == null || this.value.isEmpty()) {
            return 0;
        }
        
        Set<String> uniquePalindromes = new HashSet<>();
        int n = this.value.length();
        
        // Check all possible substrings
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String substring = this.value.substring(i, j + 1);
                // Only consider substrings of length 2 or more as meaningful palindromes
                if (substring.length() >= 2 && isPalindrome(substring)) {
                    uniquePalindromes.add(substring);
                }
            }
        }
        
        return uniquePalindromes.size();
    }

    // Convert snake_case string to camelCase format
    public String toCamelCase() {
        if (this.value == null || this.value.isEmpty()) {
            return this.value;
        }
        
        String result = "";
        boolean capitalizeNext = false;
        
        for (int i = 0; i < this.value.length(); i++) {
            char c = this.value.charAt(i);
            
            if (c == '_') {
                // Skip underscore and capitalize the next character
                capitalizeNext = true;
            } else if (capitalizeNext) {
                // Capitalize this character
                result = result + Character.toUpperCase(c);
                capitalizeNext = false;
            } else {
                // Keep character as lowercase (first word stays lowercase in camelCase)
                result = result + Character.toLowerCase(c);
            }
        }
        
        return result;
    }

    int countConsonants() {
        if (this.value == null || this.value.isEmpty()) {
            return 0;
        }
        int consonants = 0;
        String vowels = "aeiouAEIOU";
        for (char c : this.value.toCharArray()) {
            if (Character.isLetter(c) && vowels.indexOf(c) == -1) {
                consonants++;
            }
        }
        return consonants;
    }

    String expand(String pattern){
        if(pattern==null || pattern.isEmpty() || this.value==null || this.value.isEmpty())
            return this.value;

        String result="";
        for(int i=0;i<pattern.length();i++){
            char c=pattern.charAt(i);
            if(c>='a' && c<='z'){
                result+=c;
            }
            else if(c>='A' && c<='Z'){
                result+=c;
            }
            else if(c>='0' && c<='9'){
                int count=c-'0';
                if(result.length()>0){
                    char lastChar=result.charAt(result.length()-1);
                    for(int j=0;j<count-1;j++){
                        result+=lastChar;
                    }
                }
            }
        }
       return result;
    }

    String compress(String pattern){
        if(pattern==null || pattern.isEmpty() || this.value==null || this.value.isEmpty())
            return this.value;

        String result="";
        int count=1;
        for(int i=0;i<pattern.length();i++){
            char c=pattern.charAt(i);
            if(i<pattern.length()-1 && c==pattern.charAt(i+1)){
                count++;
            }
            else{
                result+=c;
                if(count>1){
                    result+=count;
                    count=1;
                }
            }
        }
       return result;
    }

    int getLengthOfLongestUniqueSubstring(String inputString) {
        int maxLength = 0;
        int n = inputString.length();
        for (int startIndex = 0; startIndex < n; startIndex++) {
            for (int endIndex = startIndex; endIndex < n; endIndex++) {
                int[] charPresence = new int[256];
                boolean isUnique = true;
                for (int k = startIndex; k <= endIndex; k++) {
                    char currentChar = inputString.charAt(k);
                    if (charPresence[currentChar] == 1) {
                        isUnique = false;
                        break;
                    }
                    charPresence[currentChar] = 1;
                }
                if (isUnique) {
                    int currentLength = endIndex - startIndex + 1;
                    if (currentLength > maxLength) {
                        maxLength = currentLength;
                    }
                }
            }
        }
        return maxLength;
     }
    
}
