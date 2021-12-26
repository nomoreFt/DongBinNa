package dfs_bfs;

import java.util.*;

class Node {

    private int x;
    private int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
}

public class EXQ4미로탈출 {
	public static int[][] graph = new int[201][201];
	public static int n, m;
	 public static int dx[] = {-1, 1, 0, 0};
	    public static int dy[] = {0, 0, -1, 1};
	    
	   public static void bfs(int x, int y) {
		   Queue<Node> q = new LinkedList<>();
		   q.offer(new Node(x,y));
		   
		   while(!q.isEmpty()) {
			   Node node = q.poll();
			   x = node.getX();
			   y = node.getY();
			   
			   for(int i = 0; i < 4; i++) {
				   int nX = x + dx[i];
				   int nY = y + dy[i];
				   if(nX < 0 || nX >= n || nY < 0 || nY >= m) continue;
				   
				   if(graph[nX][nY] == 0) continue;
				   
				   if(graph[nX][nY] == 1) {
					   graph[nX][nY] = graph[x][y] + 1;
					   q.offer(new Node(nX,nY));
				   }
				   
			   }
			   
		   }
		   System.out.println(graph[n-1][m-1]);
	   }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine();
		for(int i = 0 ; i < n; i++){
			String[] str = sc.nextLine().split("");
			for(int j = 0; j < m; j++) {
				graph[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		bfs(0,0);
	}

}
