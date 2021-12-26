package graph;

import java.util.*;

class Edge implements Comparable<Edge>{
	int nodeA;
	int nodeB;
	int distance;
	public Edge(int nodeA, int nodeB, int distance) {
		this.nodeA = nodeA;
		this.nodeB = nodeB;
		this.distance = distance;
	}
	@Override
	public int compareTo(Edge other) {
		if(this.distance < other.distance) return -1;
		return 1;
	}
}

public class Q43어두운길 {
	public static int N,M;
	public static ArrayList<Edge> edges = new ArrayList<>();
	public static int[] parent = new int[200001];
	
	public static void unionParent(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		if(a<b) parent[b] = a;
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
		for(int i = 0; i <=N; i++) {
			parent[i] = i;
		}
		
		for(int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int cost = sc.nextInt();
			edges.add(new Edge(a,b,cost));
		}
		Collections.sort(edges);
		
		int result = 0;
		int min = 0;
		for(int i = 0; i < edges.size(); i++) {
			Edge edge = edges.get(i);
			int nodeA = edge.nodeA;
			int nodeB = edge.nodeB;
			int distance = edge.distance;
			
			result += distance;
			if(findParent(nodeA) != findParent(nodeB)) {
				unionParent(nodeA,nodeB);
				min += distance;
			}
		}
		
		System.out.println(result - min);
	}
}
