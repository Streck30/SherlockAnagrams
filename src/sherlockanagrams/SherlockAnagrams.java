/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sherlockanagrams;

/**
 *
 * @author Streck
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SherlockAnagrams {

    static BigInteger factorial(int n){
        BigInteger fact = new BigInteger("1");
        for(int i = 1; i <= n; i++){
            fact = fact.multiply(BigInteger.valueOf(i));
        }
        return fact;
    }

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        HashMap<String, Integer> hmap = new HashMap<String, Integer>();
        int numAnagrams = 0;
        for(int i = 0; i < s.length();i++){
            for(int j = 0; j < s.length()-i; j++){
                String s1 = s.substring(j, j+i+1);
                char [] cray = s1.toCharArray();
                Arrays.sort(cray);
                s1 = new String(cray);
                if(!hmap.containsKey(s1)){
                    hmap.put(s1, 1);
                }
                else{
                    hmap.replace(s1,hmap.get(s1)+1);
                }
                
            }
        }
        for(int value: hmap.values()){
            if(value > 1){
                numAnagrams +=factorial(value).divide(factorial(value-2).multiply(BigInteger.valueOf(2))).intValue();
            }
        }
        return numAnagrams;


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
