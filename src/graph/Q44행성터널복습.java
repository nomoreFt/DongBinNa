package graph;
import java.util.*;

//�ּҽ��� (N-1)���� �������� ����ٸ� ���
public class Q44행성터널복습 {
	public static int N;
	public static int[] parent = new int[100001];
	public static ArrayList<Edge> edges = new ArrayList<>();
	
	public static int findParent(int x) {
		if(parent[x] == x) return x;
		return parent[x] = findParent(parent[x]);
	}
	public static void unionParent(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		if(a < b) parent[b] = a;
		else parent[a] = b;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		for(int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		ArrayList<Position> x = new ArrayList<Position>();
		ArrayList<Position> y = new ArrayList<Position>();
		ArrayList<Position> z = new ArrayList<Position>();
		//x, y, z ��ǥ�� ���� ������ ����
		for(int i = 1 ; i <= N; i++) {
			int posx = sc.nextInt();
			int posy = sc.nextInt();
			int posz = sc.nextInt();
			x.add(new Position(posx, i));
			y.add(new Position(posy, i));
			z.add(new Position(posz, i));
		}
		
		Collections.sort(x);
		Collections.sort(y);
		Collections.sort(z);
		
		for(int i = 0; i <N-1; i++) {
			edges.add(new Edge(x.get(i).idx, x.get(i+1).idx, x.get(i+1).pos - x.get(i).pos));
			edges.add(new Edge(y.get(i).idx, y.get(i+1).idx, y.get(i+1).pos - y.get(i).pos));
			edges.add(new Edge(z.get(i).idx, z.get(i+1).idx, z.get(i+1).pos - z.get(i).pos));
		}
		Collections.sort(edges);
		
		int result = 0;
		for(int i = 0; i < edges.size(); i++) {
			Edge edge = edges.get(i);
			int nodeA = edge.nodeA;
			int nodeB = edge.nodeB;
			int dist = edge.distance;
			
			if(findParent(nodeA) != findParent(nodeB)) {
				unionParent(nodeA,nodeB);
				result += dist;
			}
		}
		System.out.println(result);
	}

}


//5
//11 -15 -15
//14 -5 -15
//-1 -1 -5
//10 -4 -1
//19 -4 19

//4