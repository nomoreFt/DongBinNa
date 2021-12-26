package dfs_bfs;

import java.util.*;

class Node2 implements Comparable<Node2>{
	int idx;
	int distance;
	
	public Node2(int idx, int distance) {
		this.idx = idx;
		this.distance = distance;
	}
	
	@Override
	public int compareTo(Node2 other) {
		return this.distance - other.distance;
	}
}



public class Q15특정거리의도시찾기 {
	public static int n,m,k,x;
	public static ArrayList<ArrayList<Node2>> graph = new ArrayList<ArrayList<Node2>>();
	public static int[] d = new int[300001];
	public static final int INF = (int) 1e9;
	
	public static void dijkstra(int start) {
		PriorityQueue<Node2> pq = new PriorityQueue<Node2>();
		pq.offer(new Node2(start,0));
		
		while(!pq.isEmpty()) {
			Node2 Node2 = pq.poll();
			int now = Node2.idx;
			int dist = Node2.distance;
			if(d[now] < dist) continue;
			
			for(int i = 0; i < graph.get(now).size(); i++ ) {
				int cost = dist + graph.get(now).get(i).distance;
				if(cost < d[graph.get(now).get(i).idx]) {
					d[graph.get(now).get(i).idx] = cost;
					pq.offer(new Node2(graph.get(now).get(i).idx,cost));
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n=sc.nextInt();
		m=sc.nextInt();
		k=sc.nextInt();
		x=sc.nextInt();
		//n ���
		//m ����
		//k �ִܰŸ�
		//x ���۳��
		Arrays.fill(d,INF);
		for(int i = 0; i <= n; i++) {
			graph.add(new ArrayList<Node2>());
		}
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph.get(a).add(new Node2(b,1));
		}
		
		dijkstra(x);
		
		int cnt = 0;
		for(int i = 1; i <= n; i++) {
			if(k == d[i]) System.out.println(i);
			else cnt++;
		}
		if(cnt == n) {
			System.out.println("-1");
		}
	}

}
