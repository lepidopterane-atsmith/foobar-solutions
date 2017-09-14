// Answer class by Sarah Abowitz
// This is my secret FooBar workspace. I love the math I'm working with here :D
// The solutions I use in FooBar look like this except no System stuff

import java.util.List;
import java.util.Arrays;
import java.util.HashSet;
import java.util.ArrayList;

public class Answer {   
    // Challenge 1
    public static String answer1(int n) { 

        String primes = spawnPrimeString(20357);
        System.out.println("\n\n"+primes.length());
        return primes.substring(n,n+5);
    }
    
    public static String spawnPrimeString(int n) {
        boolean[] isPrimeNumber = new boolean[n+1];
        String primes = "";
        for (int i = 2; i < n; i++) {
            isPrimeNumber[i] = true;
        }
        for (int i = 2; i < n; i++) {
            if (isPrimeNumber[i]) {
                primes += i;
                for (int j = i; j * i <= n; j++) {
                    isPrimeNumber[i * j] = false;
                }
            }
        }

        return primes;
    }
    
    // Challenge 2A
    public static String ans(int x, int y) { 

        long triLevel = x+y-1; 
        long approx = (triLevel*(x+y))/2;  
        long num = approx - y + 1;
        String ans = ""+num;
        return ans;
        
        // moral of the story: ints are awesome but longs are good for long shit like 10000*10001
    }
    
    // Challenge 2B
    public static int answer2B(String s) { 
        if ((s.indexOf('>')==-1)||(s.indexOf('<')==-1))
          return 0;
          
        String str = s.substring(s.indexOf('>'));
        System.out.println(str);
        str = str.substring(0,str.lastIndexOf('<')+1);
        str = str.replaceAll("-","");
        int sum = 0;
        System.out.println(str);
        
        while (str.indexOf('>') > -1){
          System.out.println(str);
          sum += findLefts(str);
          if (str.substring(1).indexOf('>')>-1){
            str = str.substring(1);
            str = str.substring(str.indexOf('>'));
          } else{
            str = "-";  
          }
        }
        
        System.out.println("---");
        return sum; 
    }
    
    public static int findLefts(String s){
      int total = 0;
      String str = s.substring(1);
      str = str.replaceAll(">","");
      while (str.indexOf('<') > -1){
          System.out.println("+2 "+str);
          total += 2;
          if (str.substring(1).indexOf('<')>-1){
            str = str.substring(1);
            str = str.substring(str.indexOf('<'));
          } else{
            str = "-";  
          }
        }
        
      return total;
    }
    
    // Challenge 3A
    public static int answer(int[] myList) { 
      
      // the following chunk is an override for testing large sets
      // to use in normal mode, comment that out and change the param
      // name to l 
      
      int[] l = new int[5];
      final int NUMBER_OF_RESPONSES = 999999;
      for(int i = 0; i < 5; i++){
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        l[i] = whichResponse+1;
        l[i]++;
        System.out.print(" "+l[i]);
       }
       
      // this is the last bit of that chunk
      
      System.out.println("---");
      
      int total = 0;
      HashSet<String> record = new HashSet<>();
      int counter = 0;
      for(int n: l){
        int m = n;
        l[counter] = -1;
        
        // record = isModulus(l, l.length, n, record);
        // (int arr[], int n, int x, HashSet<String> record)
        
        HashSet<Integer> hset = new HashSet<>();
        
        if(l.length > 2) {
         
            for(int i = 0; i < l.length; i++){
            if(l[i] > 0 && n % l[i] == 0 && i < counter){ // && !(x == arr[i] && x>1) ){
              int hcounter = 0;
              for(int h: hset){
                String code = ""+n+" "+l[i]+" "+h;
                if(l[i] % h==0 && !record.contains(code) && hcounter < i){ // && !(h == arr[i] && h>1)){
                    System.out.println(code);
                    total++;
                    record.add(code);
                    
                }
                hcounter++;
              }
              hset.add(l[i]);
            }
          }
        }
        
        l[counter] = m;
        counter++;   
      }
      
      //System.out.println(l[0]);
      
      return total;
    }
     
    }
