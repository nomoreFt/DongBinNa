package graph;
import java.util.*;

class Position implements Comparable<Position>{
	int idx;
	int pos;
	public Position(int pos, int idx) {
		this.pos = pos;
		this.idx = idx;
	}
	@Override
	public int compareTo(Position other) {
		return this.pos - other.pos;
	}
}

public class Q44행성터널 {
	public static int N; //행성의 개수
	public static ArrayList<Edge> edges = new ArrayList<>();
	public static int[] parent = new int[100001];
	
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
		
		for(int i = 0; i <= N; i++) {
			parent[i] = i;
		}
		
		ArrayList<Position> x = new ArrayList<Position>();
		ArrayList<Position> y = new ArrayList<Position>();
		ArrayList<Position> z = new ArrayList<Position>();
		for(int i = 1; i <= N; i++) {
			int posX = sc.nextInt();
			int posY = sc.nextInt();
			int posZ = sc.nextInt();
			x.add(new Position(posX,i));
			y.add(new Position(posY,i));
			z.add(new Position(posZ,i));
		}
		
		Collections.sort(x);
		Collections.sort(y);
		Collections.sort(z);
		
		for(int i = 1; i <= N-1; i++) {
			edges.add(new Edge(i,i+1,x.get(i).pos-x.get(i-1).pos));
			edges.add(new Edge(i,i+1,y.get(i).pos-y.get(i-1).pos));
			edges.add(new Edge(i,i+1,z.get(i).pos-z.get(i-1).pos));
		}
		Collections.sort(edges);
		
		int result = 0;
		for(int i = 0; i < edges.size(); i++) {
			Edge edge = edges.get(i);
			int nodeA = edge.nodeA;
			int nodeB = edge.nodeB;
			int cost = edge.distance;
			
			if(findParent(nodeA) != findParent(nodeB)) {
				unionParent(nodeA,nodeB);
				result += cost;
			}
		}
		System.out.println(result);
		
		
		
	}
}
