package graph;

import java.util.*;

public class Q42Å¾½Â±¸ {
	public static int G,P;//G Å¾½Â±¸ ,P ºñÇà±â
	public static int[] parent = new int[100001];
	
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
		
		G = sc.nextInt();
		P = sc.nextInt();
		
		for(int i = 0; i <= G; i++) {
			parent[i] = i;
		}
		
		int count = 0;
		for(int i = 0 ; i < P; i++) {
			int airplane = sc.nextInt();
			if(findParent(airplane) != 0) {
				count++;
			}else break;
			unionParent(airplane,airplane-1);
		}
		
		System.out.print(count);
	}
}
