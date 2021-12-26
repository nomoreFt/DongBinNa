package graph;

import java.util.*;

public class Q41여행계획 {

	public static int N,M;
	public static int[] parent = new int[501];
	
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
		M = sc.nextInt();
		
		for(int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				int x = sc.nextInt();
				if(x == 1) {
					unionParent(i,j);
				}
			}
		}
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i = 0; i < M; i++) {
			arr.add(sc.nextInt());
		}
		
		boolean result = false;
		for(int i = 0; i < arr.size()-1; i++) {
			if(findParent(arr.get(i)) == findParent(arr.get(i+1))) {
				result = true;
			}else {
				result = false;
			}
		}
		if(result) System.out.println("YES");
		else System.out.println("NO");
		
	}

}
