package graph;

import java.util.*;

public class Q45최종순위복습 {
	public static int testCase,n,m;
	public static int[] indegree = new int[501];
	public static boolean[][] graph = new boolean[501][501];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		testCase = sc.nextInt();
		for(int tc = 0; tc < testCase; tc++) {
			
			Arrays.fill(indegree, 0);
			
			for(int i = 0; i < 501; i++) {
				Arrays.fill(graph[i], false);
			}
			
			n = sc.nextInt();
			ArrayList<Integer> teams = new ArrayList<Integer>();
			for(int i = 0 ; i < n; i++) {
				teams.add(sc.nextInt());
			}
			
			for(int i = 0; i < n; i++) {
				for(int j = i+1; j < n; j++) {
					graph[teams.get(i)][teams.get(j)] = true;
					indegree[teams.get(j)] += 1;
				}
			}
			
			m = sc.nextInt();
			for(int i = 0; i < m; i++) {
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
			
			//topologySort
			boolean isCycle = false;//q가 먼저 비어버리면 cycle
			boolean isNotCertain = false;//q에 2개 이상인지, 그럼 두개 들어감
			
			ArrayList<Integer> result = new ArrayList<>();
			Queue<Integer> q = new LinkedList<>();
			
			for(int i = 1 ; i <= n; i++) {
				if(indegree[i] == 0) q.offer(i); 
			}
			
			for(int i = 1; i <= n; i++) {
				if(q.size() >= 2) {
					isNotCertain = true;
					break;
				}
				if(q.size() == 0) {
					isCycle = true;
					break;
				}
				int now = q.poll();
				result.add(now);
				for(int k = 1; k <= n; k++) {
					if(graph[now][k]) {
						indegree[k]--;
						if(indegree[k] == 0) q.offer(k);
					}
				}
			}
			if(isCycle) {
				System.out.println("IMPOSSIBLE");
			}else if(isNotCertain) {
				System.out.println("?");
			}else {
				for(int i = 0; i < result.size(); i++) {
					System.out.print(result.get(i)+" ");
				}
				System.out.println();
			}
			
		}
		
	}

}



