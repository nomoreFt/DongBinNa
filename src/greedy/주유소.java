package greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 주유소 {
    static long n;
    static long min;
    static long total;
    static ArrayList<Long> len = new ArrayList<>();
    static ArrayList<Long> oil = new ArrayList<>();
    public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    
    StringTokenizer st = new StringTokenizer(br.readLine()," ");
    while(st.hasMoreTokens()){
        len.add(Long.parseLong(st.nextToken()));
    }
    st = new StringTokenizer(br.readLine()," ");
    while(st.hasMoreTokens()){
        oil.add(Long.parseLong(st.nextToken()));
    }
    min = oil.get(0);
    for(int i = 0; i < n-1; i++){
        min = Math.min(min, oil.get(i));
        total += len.get(i) * min;
    }
    System.out.println(total);

    }
    
}
