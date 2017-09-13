// This is my secret FooBar workspace. I love the math I'm working with here aaaaaa
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
    public static int answer(int[] l) { 
      Arrays.sort(l);
      int total = 0;
      HashSet<String> record = new HashSet<>();
      int counter = 0;
      for(int n: l){
        int m = n;
        l[counter] = -1;
        record = isModulus(l, l.length, n, record);
        l[counter] = m;
        counter++;   
      }
      
      return record.size();
      
      // naive strategy I'm still leaving here
      /*List<Integer> lookup = new ArrayList<Integer>();
      for (int index = 0; index < l.length; index++){
        lookup.add(l[index]);
      }
      List<Integer> dummy = new ArrayList<Integer>(lookup);
      
      Collections.sort(dummy);
      Collections.reverse(dummy);
      int big = dummy.get(0)+1;
      ArrayList<String> tuples = new ArrayList<String>();
      System.out.println("-"+big+"--");
      
      // don't forget to import collections!
      for (int i=0; i < big-1; i++){
        System.out.println("i: "+i);
        for (int j = l[i]; j < big; j+=l[i]){
          System.out.println("j: "+j);
          if (lookup.lastIndexOf(j) > i){
            for (int k = j; k < big; k+=j) {
              System.out.println("k: "+k);
              String t = ("{"+l[i]+" "+j+" "+k+"}");
              System.out.print(t);
              if(k % j ==0 && lookup.lastIndexOf(k) > lookup.indexOf(j) && !tuples.contains(t)){
                tuples.add(t); 
                System.out.print(" <:D ");
              }
              
            }
          }  
        }  
      }
      
      return tuples.size();*/
    }
      
    static HashSet<String> isModulus(int arr[], int n, int x, HashSet<String> record)
    {
        // Create an empty set and insert first
        // element into it
        
        HashSet<Integer> hset = new HashSet<>();
        
        if(n > 2) {
         
          // Traverse remaining elements
            for(int i = 0; i < n; i++){
            if(arr[i] > 0 && x % arr[i] == 0){ // && !(x == arr[i] && x>1) ){
              
              for(int h: hset){
                String code = ""+x+" "+arr[i]+" "+h;
                if(arr[i] % h==0 && !record.contains(code) ){ //&& !(h == arr[i] && h>1)){
                    System.out.println(code);
                    record.add(code);
                    
                }
              }
              hset.add(arr[i]);
            }
          }
        }
        return record;
    }
     
    }
