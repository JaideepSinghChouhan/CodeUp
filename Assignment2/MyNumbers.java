/**
 * @filename-MyString.java
 * @description-A custom Number manipulation class with various methods such as Fibonacci calculation, prime checking, and number-to-word conversion.
 * @author-JD
 */
package Assignment2;

public class MyNumbers {

    //Fibbonacci using recursion
    int getNthFibonacci(int n){
        if(n<=0) return 0;
        if(n==1) return 1;
        return getNthFibonacci(n-1) + getNthFibonacci(n-2);
    }
    
    //Prime number check
    boolean isPrime(int n){
        if(n<=1) return false;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0) return false;
        }
        return true;
    }

    //Conveting number to words
    String toWords(int n){
        if(n==0) return "Zero";
        if(n<0) return "Minus "+toWords(-n);
        String[] belowTwenty={"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten",
        "Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        String[] tens={"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        String result="";
        if(n>=1000){
            result+=belowTwenty[n/1000]+ " Thousand ";
            n%=1000;
        }
        if(n>=100){
            result+=belowTwenty[n/100]+" Hundred ";
            n%=100;
        }
        if(n>=20){
            result+=tens[n/10]+" ";
            n%=10;
        }
        if(n>0){
            result+=belowTwenty[n]+" ";
        }
        return result.trim();
    }

    double toDecimal(String binary){
        double decimal=0;
        String[] partitionString=binary.split("\\.");
        String wholePart=partitionString[0];
        for(int i=0;i<wholePart.length();i++){
            if(wholePart.charAt(i)!=0 && wholePart.charAt(i)!=1){
                System.out.println("Invalid Binary String");
                return 0;
            }
            if(wholePart.charAt(wholePart.length()-1-i)=='1'){
                decimal+=Math.pow(2, i);
            }
        }
        if(partitionString.length>1){
            for(int i=0;i<partitionString[1].length();i++){
                if(partitionString[1].charAt(i)!=0 && partitionString[1].charAt(i)!=1){
                System.out.println("Invalid Binary String");
                return 0;
            }
            if(partitionString[1].charAt(i)=='1'){
                decimal+=1/Math.pow(2, i+1);
            }
        }
        }
        return decimal;
    }

}

