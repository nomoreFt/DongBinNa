package 최단거리;

import java.util.*;
import java.io.*;


public class 화성탐사 {

    static class Space implements Comparable<Space>{
        int x;
        int y;
        int distance;

        public Space(int x, int y, int distance){
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
        
        @Override
        public int compareTo(Space other){
            return this.distance - other.distance;
        }


    }

    static int n,testCase;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] graph = new int[130][130];
    static int[][] d = new int[130][130];
    static final int INF = (int) 1e9;
    static StringBuffer sb = new StringBuffer();
    static void djikstra(){
        PriorityQueue<Space> pq = new PriorityQueue<>();
        pq.offer(new Space(0,0,graph[0][0]));
        d[0][0] = graph[0][0];
        
        while(!pq.isEmpty()){
            Space sp = pq.poll();
            int x = sp.x;
            int y = sp.y;
            int dist = sp.distance;
            if(d[x][y] < dist) continue;
            for(int i = 0; i < 4; i++){
                int nX = x + dx[i];
                int nY = y + dy[i];
                if(nX < 0 || nX >=n || nY < 0 || nY >= n) continue;
                int cost = graph[nX][nY] + dist;
                if(cost < d[nX][nY]){
                    d[nX][nY] = cost;
                    pq.offer(new Space(nX,nY,cost));
                }
            }
        }
        sb.append(d[n-1][n-1] + "\n");
        


    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testCase = Integer.parseInt(br.readLine());
        
        while(testCase-- > 0){
            n = Integer.parseInt(br.readLine());
            for(int i = 0; i < n; i++){
                String[] strs = br.readLine().split(" ");
                for(int j = 0; j < n; j++){
                    graph[i][j] = Integer.parseInt(strs[j]);
                }
            }
            for(int i = 0; i <n; i++){
                Arrays.fill(d[i],INF);
            }
            
            djikstra();
            
            System.out.println(sb.toString());


        }


        
    }
}
