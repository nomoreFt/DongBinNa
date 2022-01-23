package 최단거리;

import java.util.*;

public class Q37미래도시 {
    static int N,M,X,K;
    static final int INF = (int) 1e9;
    static int[][] graph = new int[101][101];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        
        for(int i = 0; i < 101; i++){
            Arrays.fill(graph[i],INF);
        }
        
        for(int i = 0; i <= N; i++){
            for(int j = 0; j <= M; j++){
                if(i==j) graph[i][j] = 0;
            }
        }

        for(int i = 0; i < M; i++){
            str = sc.nextLine().split(" ");
                int start = Integer.parseInt(str[0]);
                int end = Integer.parseInt(str[1]);
                int cost = 1;
                graph[start][end] = cost;
                graph[end][start] = cost;
        }
        str = sc.nextLine().split(" ");
        K = Integer.parseInt(str[1]);//K번 회사거쳐
        X = Integer.parseInt(str[0]);//X번회사로

        for(int k = 1; k <= N; k++){
            for(int a = 1; a <=N; a++){
                for(int b = 1; b <= N; b++){
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        // 수행된 결과를 출력
        int distance = graph[1][K] + graph[K][X];

         // 도달할 수 없는 경우, -1을 출력
         if (distance >= INF) {
            System.out.println(-1);
        }
        // 도달할 수 있다면, 최단 거리를 출력
        else {
            System.out.println(distance);
        }

    }
}
