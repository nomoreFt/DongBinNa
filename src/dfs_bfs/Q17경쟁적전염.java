package dfs_bfs;

import java.util.*;

class Virus implements Comparable<Virus>{
    int x;
    int y;
    int idx;
    int sec;
    public Virus(int x, int y, int idx, int sec){
        this.x = x;
        this.y = y;
        this.idx = idx;
        this.sec = sec;
    }
    @Override
    public int compareTo(Virus other){
        return this.idx-other.idx;
    }
}

class Q17°æÀïÀûÀü¿°{
    public static int[][] graph = new int[201][201];
    public static int N,K,S,X,Y;
    public static ArrayList<Virus> virus = new ArrayList<>();
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        N = Integer.parseInt(strs[0]);
        K = Integer.parseInt(strs[1]);
        for(int i = 0 ; i < N; i++){
            strs = sc.nextLine().split(" ");
           for(int j = 0; j < N; j++){
               graph[i][j] = Integer.parseInt(strs[j]);
               if(graph[i][j] != 0){
                   virus.add(new Virus(i,j,graph[i][j],0));
               }
           }
        }
        strs = sc.nextLine().split(" ");
        S = Integer.parseInt(strs[0]);
        X = Integer.parseInt(strs[1]);
        Y = Integer.parseInt(strs[2]);
        
        Collections.sort(virus);
        Queue<Virus> q = new LinkedList<>();
        for(int i = 0; i < virus.size(); i++){
            q.offer(virus.get(i));
        }
        
        while(!q.isEmpty()){
            Virus v = q.poll();
            int x = v.x;
            int y = v.y;
            int idx = v.idx;
            int sec = v.sec;
            if(sec == S) break;
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if(graph[nx][ny] == 0){
                    graph[nx][ny] = idx;
                    q.offer(new Virus(nx,ny,idx,sec+1));
                }
            }
        }
        System.out.print(graph[X-1][Y-1]);
    }
}