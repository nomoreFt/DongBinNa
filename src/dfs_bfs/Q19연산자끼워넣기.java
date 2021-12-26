package dfs_bfs;
import java.util.*;

public class Q19연산자끼워넣기 {
	public static ArrayList<Integer> nums = new ArrayList<>();
	public static int N,a,b,c,d;
	public static int max = (int) -1e9;
	public static int min = (int) 1e9;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		sc.nextLine();
		String[] strs = sc.nextLine().split(" ");
		for(int i = 0; i < strs.length; i++) {
			nums.add(Integer.parseInt(strs[i]));
		}
		strs = sc.nextLine().split(" ");
		a = Integer.parseInt(strs[0]);
		b = Integer.parseInt(strs[1]);
		c = Integer.parseInt(strs[2]);
		d = Integer.parseInt(strs[3]);
		
			dfs(0,nums.get(0));
		System.out.println(max);
		System.out.println(min);
		
	}
	public static void dfs(int depth, int result) {
		if(depth == N-1) {
			max = Math.max(max, result);
			min = Math.min(min, result);
		}
		if(a > 0) { // ����
			int num = nums.get(depth+1);
			a -= 1;
			result += num;
			depth += 1;
			dfs(depth,result);
			depth -= 1;
			result -= num;
			a += 1;
		}
		if(b > 0) { // ����
			int num = nums.get(depth+1);
			b -= 1;
			result -= num;
			depth += 1;
			dfs(depth,result);
			depth -= 1;
			result += num;
			b += 1;
		}
		if(c > 0) { // ����
			int num = nums.get(depth+1);
			c -= 1;
			result *= num;
			depth += 1;
			dfs(depth,result);
			depth -= 1;
			result /= num;
			c += 1;
		}
		if(d > 0) { // ������
			int num = nums.get(depth+1);
			d -= 1;
			result /= num;
			depth += 1;
			dfs(depth,result);
			depth -= 1;
			result *= num;
			d += 1;
		}
	}
	
}
