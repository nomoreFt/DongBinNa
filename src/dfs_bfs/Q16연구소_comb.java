package dfs_bfs;

import java.util.*;

public class Q16연구소_comb {
	public static int[][] graph = new int[9][9];
	public static int[][] temp = new int[9][9];
	public static int N,M;
	public static ArrayList<Position> spaces = new ArrayList<Position>();
	public static ArrayList<Position> viruses = new ArrayList<>(); 
	public static int max = (int) -1e9;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		//�ʱ� ����
		for(int i = 0; i < N; i++) {
			for(int j = 0 ; j <M; j++) {
				graph[i][j] = sc.nextInt();
				if(graph[i][j] == 2) viruses.add(new Position(i,j));
				if(graph[i][j] == 0) spaces.add(new Position(i,j));
			}
		}
		
		Combination comb = new Combination(spaces.size(), 3);
		comb.combination(spaces, 0, 0, 0);
		ArrayList<ArrayList<Position>> virusList = comb.result;
		
		for(int i = 0; i < virusList.size(); i++) {
			
			for(int j = 0; j < virusList.get(i).size(); j++) {
				int x = virusList.get(i).get(j).x;
				int y = virusList.get(i).get(j).y;
				graph[x][y] = 1;
			}
			//temp�� �Űܼ� virus ��ġ���� bfs�� 2�� ��Ʈ��
			//���� ���� ã��
			process();
				
			for(int j = 0; j < virusList.get(i).size(); j++) {
				int x = virusList.get(i).get(j).x;
				int y = virusList.get(i).get(j).y;
				graph[x][y] = 0;
			}
		}
		System.out.println(max);
	}
	public static void process() {
		//process ������ �� ���� temp�� graph�� �ʱ�ȭ (�� 3�� ������ ����)
		for(int i = 0 ; i < N; i++) {
			for(int j = 0 ; j < M; j++) {
				temp[i][j] = graph[i][j];
			}
		}
		//�� ���̷��� ��� �ڱ� ���̷��� ��Ʈ����
		for(int i = 0 ; i < viruses.size(); i++) {
			int x = viruses.get(i).x;
			int y = viruses.get(i).y;
			Queue<Position> q = new LinkedList<>();
			q.offer(new Position(x,y));
			
			while(!q.isEmpty()) {
				Position pos = q.poll();
				x = pos.x;
				y = pos.y;
				for(int j = 0 ; j < 4; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];
					if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
					if(temp[nx][ny] == 0) {
						temp[nx][ny] = 2;
						q.offer(new Position(nx,ny));
					}
				}
			}
		}
		max = Math.max(max, getCount(temp));
	}
	public static int getCount(int[][] temp) {
		int count = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(temp[i][j] == 0) count++; 
			}
		}
		return count;
	}
}
