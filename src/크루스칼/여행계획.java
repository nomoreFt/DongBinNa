package 크루스칼;

import java.util.*;
import java.io.*;

public class 여행계획 {
    static int n,m;//n = 여행지 수 m = 여행할 도시수
    static int[] parents = new int[501];

    static int findParent(int x){
        if(x == parents[x]) return x;
        else return parents[x] = findParent(parents[x]);
    }
    static void unionParent(int a, int b){
        a = findParent(a);
        b = findParent(b);
        if(a < b) parents[b] = a;
        else parents[a] = b;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        for(int i = 0; i < n; i++){
            parents[i] = i;
        }

        for(int i = 0; i < n; i++){
            System.out.println("parents["+i+"] : "+ findParent(i));   
        }

        for(int i = 0; i < n; i++){
            str = br.readLine().split(" ");
            for(int j = 0; j < n; j++){
                if(str[j].equals("1")){
                    unionParent(i, j);
                }
            }
        }
        for(int i = 0; i < n; i++){
            System.out.println("parents["+i+"] : "+ findParent(i));   
        }
        str = br.readLine().split(" ");
        boolean flag = true;

        for(int i = 0; i < m-1; i++){
            int a = Integer.parseInt(str[i]);
            int b = Integer.parseInt(str[i+1]);
            if(findParent(a) != findParent(b)) flag = false;
        }
        
        if(flag) System.out.println("YES");
        else System.out.println("NO");
        
        br.close();
    }
    
}
