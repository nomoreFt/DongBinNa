package dfs_bfs;

import java.util.*;

public class DFS {
	public static boolean[] visited = new boolean[9];
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	
	public static void dfs(int start) {
		visited[start] = true;
		System.out.println(start + " ");
		
		for(int i = 0; i < graph.get(start).size(); i++) {
			int y = graph.get(start).get(i);
			if(!visited[y]) dfs(y);
		}
		
	}
	public static void main(String[] args) {
		for(int i = 0; i < 9; i++) {
			graph.add(new ArrayList<Integer>());
		}
	    // ��� 1�� ����� ��� ���� ���� 
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(8);
        
        // ��� 2�� ����� ��� ���� ���� 
        graph.get(2).add(1);
        graph.get(2).add(7);
        
        // ��� 3�� ����� ��� ���� ���� 
        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(3).add(5);
        
        // ��� 4�� ����� ��� ���� ���� 
        graph.get(4).add(3);
        graph.get(4).add(5);
        
        // ��� 5�� ����� ��� ���� ���� 
        graph.get(5).add(3);
        graph.get(5).add(4);
        
        // ��� 6�� ����� ��� ���� ���� 
        graph.get(6).add(7);
        
        // ��� 7�� ����� ��� ���� ���� 
        graph.get(7).add(2);
        graph.get(7).add(6);
        graph.get(7).add(8);
        
        // ��� 8�� ����� ��� ���� ���� 
        graph.get(8).add(1);
        graph.get(8).add(7);

        dfs(1);
		
	}
}
