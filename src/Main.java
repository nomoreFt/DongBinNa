import java.util.*;

public class Main {
    static int n,m;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int max = Integer.MIN_VALUE;
    static void process(int x, int y, boolean[][] visited, int[][] graph,int depth,int sum){
        if(depth == 3){
            max = Math.max(max,sum);
            return;
        }
        for(int i = 0; i < 4; i++){
            int nX = x + dx[i];
            int nY = y + dy[i];
            if(nX <0 || nX >= n || nY <0 || nY >= m) continue;
            if(!visited[nX][nY]){
                visited[nX][nY] = true;
                int cost = graph[nX][nY] + sum;
                process(nX,nY,visited,graph,depth+1,cost);
                visited[nX][nY] = false;
            }
            
        }
    }
    static void check(int y, int x, int[][] graph) {
        if (y < n - 2 && x < m - 1)
            max = Math.max(max, graph[y][x] + graph[y + 1][x] + graph[y + 2][x] + graph[y + 1][x + 1]);

        if (y < n - 2 && x > 0)
            max = Math.max(max, graph[y][x] + graph[y + 1][x] + graph[y + 2][x] + graph[y + 1][x - 1]);

        if (y < n - 1 && x < m - 2)
            max = Math.max(max, graph[y][x] + graph[y][x + 1] + graph[y][x + 2] + graph[y + 1][x + 1]);

        if (y > 0 && x < m - 2)
            max = Math.max(max, graph[y][x] + graph[y][x + 1] + graph[y][x + 2] + graph[y - 1][x + 1]);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        boolean[][] visited = new boolean[n][m];
        int[][] graph = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                graph[i][j] = sc.nextInt();
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                visited[i][j] = true;
                process(i,j,visited,graph,0,graph[i][j]);
                visited[i][j] = false;
                check(i,j,graph);
            }
        }

        System.out.println(max);
    }
}