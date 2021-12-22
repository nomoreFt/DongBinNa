package dfs_bfs;

import java.util.*;
import java.io.*;


class Combination4{
	int n;
	int r;
	int[] now;
	ArrayList<ArrayList<Position4>> result;
	
	public Combination4(int n, int r) {
		this.n = n;
		this.r = r;
		now = new int[r];
		result = new ArrayList<ArrayList<Position4>>();
	}
	
	public void comb(ArrayList<Position4> arr, int index, int depth, int target) {
		if(depth == r) {
			ArrayList<Position4> temp = new ArrayList<>();
			for(int i = 0; i < now.length; i++) {
				temp.add(arr.get(now[i]));
			}
			result.add(temp);
			return;
		}
		if(target == n) return;
		now[index] = target;
		comb(arr,index+1,depth+1,target+1);
		comb(arr,index,depth,target+1);
	}
	
}

class Position4{ 
	int x;
	int y;
	public Position4(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class �������ϱ⺹��2 {
	public static ArrayList<Position4> teachers = new ArrayList<Position4>();
	public static ArrayList<Position4> spaces = new ArrayList<Position4>();
	public static String[][] graph = new String[7][7];
	public static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		for(int i = 0; i < N; i++) {
			strs = br.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				graph[i][j] = strs[j];
				if(graph[i][j].equals("T")) teachers.add(new Position4(i,j));
				else if(graph[i][j].equals("X")) spaces.add(new Position4(i,j));
			}
		}
			
			
		Combination4 com = new Combination4(spaces.size(), 3);
		com.comb(spaces,0,0,0);
		ArrayList<ArrayList<Position4>> result = com.result;
		for(int i = 0 ; i < result.size(); i++) {//�� ������ ��ֹ� 3�� ����� �� 
			for(int j = 0; j < result.get(i).size(); j++) {
				Position4 p = result.get(i).get(j);
				graph[p.x][p.y] = "O";
			}
			if(!process()) {
				System.out.println("YES");
				return;
			}
			for(int j = 0; j < result.get(i).size(); j++) {
				Position4 p = result.get(i).get(j);
				graph[p.x][p.y] = "X";
			}
		}
		System.out.println("NO");
	}
	public static boolean process() {//�л� ã���� true, �� ���� �� ��ã���� false
		for(int i = 0 ; i < teachers.size(); i++) {
			Position4 p = teachers.get(i);
			int x = p.x;
			int y = p.y;
			for(int j = 0 ; j < 4; j++) {
				if(findStudent(x,y,j)) return true; 
			}
		}
		return false;
	}
	public static boolean findStudent(int x, int y, int target) {
		if(target == 0) {//��
			while(y < N) {
				if(graph[x][y].equals("O")) return false;
				if(graph[x][y].equals("S")) return true;
				y += 1;
			}
		}else if(target == 1) {//��
			while(y >= 0) {
				if(graph[x][y].equals("O")) return false;
				if(graph[x][y].equals("S")) return true;
				y -= 1;
			}
		}else if(target == 2) {//��
			while(x < N) {
				if(graph[x][y].equals("O")) return false;
				if(graph[x][y].equals("S")) return true;
				x += 1;
			}
		}else if(target == 3) {//��
			while(x >= 0) {
				if(graph[x][y].equals("O")) return false;
				if(graph[x][y].equals("S")) return true;
				x -= 1;
			}
		}
		return false;
	}
}
