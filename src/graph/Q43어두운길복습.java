package graph;

import java.util.*;

//최소신장트리
//Edge만들어서 길이순으로 정렬, cycle 체크하면서 unionParent
public class Q43어두운길복습 {
	public static int N,M;
	public static int[] parent = new int[200001];
	public static ArrayList<Edge> edges = new ArrayList<Edge>();
	
	public static void unionParent(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		if(a < b) parent[b] = a;
		else parent[a] = b;
	}
	public static int findParent(int x) {
		if(parent[x] == x) return x;
		return parent[x] = findParent(parent[x]);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		for(int i = 0; i <= N; i++) {
			parent[i] = i;
		}
		for(int i = 0 ; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int cost = sc.nextInt();
			edges.add(new Edge(a, b, cost));
		}
		
		Collections.sort(edges);
		
		int total = 0;
		int sum = 0;
		
		for(int i = 0 ; i < edges.size(); i++) {
			Edge edge = edges.get(i);
			int nodeA = edge.nodeA;
			int nodeB = edge.nodeB;
			int cost = edge.distance;
			total += cost;
			if(findParent(nodeA) != findParent(nodeB)) {
				unionParent(nodeA,nodeB);
				sum += cost;
			}
		}
		
		System.out.println(total - sum);
		
	}
	
	

}
