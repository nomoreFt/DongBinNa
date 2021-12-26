package dfs_bfs;
import java.util.*;

class Node4 implements Comparable<Node4>{
	int idx;
	int distance;
	
	public Node4(int idx, int distance) {
		this.idx  = idx;
		this.distance = distance;
	}

	@Override
	public int compareTo(Node4 other) {
		return this.distance - other.distance;
	}

}

public class Q15특정거리의도시찾기복습 {
	public static int[] d = new int[300001];
	public static int N,M,K,X;
	public static ArrayList<ArrayList<Node4>> graph = new ArrayList<>();
	public static int INF = (int) 1e9;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Arrays.fill(d, INF);
		
		N = sc.nextInt();//������ ����
		M = sc.nextInt();//������ ����
		K = sc.nextInt();//�Ÿ�����(�ִܰŸ�)
		X = sc.nextInt();//������
		
		for(int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Node4>());
		}
		
		for(int i = 0; i < M; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			graph.get(start).add(new Node4(end,1));
		}
		
		djikstra(X);
		
		ArrayList<Integer> answer = new ArrayList<Integer>();
		for(int i = 1; i <= N; i++) {
			if(d[i] == K) answer.add(i);
		}
		if(answer.size() == 0) System.out.println("-1");
		else {
			answer.stream().forEach(x -> System.out.println(x));
		}
	}
	public static void djikstra(int start) {
		PriorityQueue<Node4> pq = new PriorityQueue<Node4>();
		pq.offer(new Node4(start,0));
		d[start] = 0;
		while(!pq.isEmpty()) {
			Node4 node = pq.poll();
			int now = node.idx;
			int dist = node.distance;
			if(d[now] < dist) continue;
			for(int i = 0; i < graph.get(now).size(); i++) {
				int cost = dist + graph.get(now).get(i).distance;
				if(cost < d[graph.get(now).get(i).idx]) {
					d[graph.get(now).get(i).idx] = cost;
					pq.offer(new Node4(graph.get(now).get(i).idx,cost));
				}
			}
			
		}
	}

}
