package graph;

import java.util.*;

public class Q45최종순위 {
	public static int testCase,n,m;
	public static int[] indegree = new int[501];
	public static boolean[][] graph = new boolean[501][501];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		testCase = sc.nextInt();
		for(int tc = 0; tc < testCase; tc++) {
			Arrays.fill(indegree,0);
			for(int a = 0 ; a < 501; a++) {
				Arrays.fill(graph[a], false);
			}
			
			
			n = sc.nextInt();
			ArrayList<Integer> teams = new ArrayList<Integer>();
			for(int j = 0; j < n; j++){
				teams.add(sc.nextInt());
			}
			for(int a = 0; a < n; a++) {
				for(int b = a+1; b < n; b++) {
					graph[teams.get(a)][teams.get(b)] = true;
					indegree[teams.get(b)]++;
				}
			}
			m = sc.nextInt();
			for(int k = 0; k < m; k++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				if(graph[a][b]) {
					graph[a][b] = false;
					indegree[b]--;
					graph[b][a] = true;
					indegree[a]++;
				}else {
					graph[a][b] = true;
					indegree[b]++;
					graph[b][a] = false;
					indegree[a]--;
				}
			}
			
			ArrayList<Integer> result = new ArrayList<Integer>();
			Queue<Integer> q = new LinkedList<>();
			
			for(int i = 1; i <=n; i++) {
				if(indegree[i] == 0) q.offer(i);
			}
			
			boolean cycle = false;
			boolean certain = true;
			
			for(int i = 0; i < n; i++) {
				if(q.size() >= 2) {
					certain = false;
					break;
				}
				if(q.size() == 0) {
					cycle = true;
					break;
				}
				
				int now = q.poll();
				result.add(now);
				for(int j = 1; j <= n; j++) {
					if(graph[now][j]) {
						indegree[j]--;
					if(indegree[j] == 0) {
						q.offer(j);
						}
					}
				}
				if(cycle) System.out.println("IMPOSSIBLE");
				else if(!certain) System.out.println("?");
				else {
					for(int k = 0; k < result.size(); k++) {
						System.out.print(result.get(i) + " ");
					}
					System.out.println();
				}
				
			}
		}
	}
}
