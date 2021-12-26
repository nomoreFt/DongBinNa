package dfs_bfs;

import java.util.*;


class Combination{
    int n;
    int r;
    int now[];
    ArrayList<ArrayList<Position>> result;
    
    public Combination(int n, int r){
        this.n = n;
        this.r = r;
        this.now = new int[r];
        this.result = new ArrayList<ArrayList<Position>>();
    }
    
    public void combination(ArrayList<Position> arr, int depth, int index, int target){
        if(depth == r){
            ArrayList<Position> temp = new ArrayList<>();
            for(int i = 0 ; i < now.length; i++){
                temp.add(arr.get(now[i]));
            }
            result.add(temp);
            return;
        }
        if(target == n) return;
        now[index] = target;
        combination(arr,depth+1,index+1,target+1);
        combination(arr,depth,index,target+1);
    }
}

public class Q20감시피하기_comb {

	public static String[][] graph = new String[7][7];    
	public static int N;
	public static ArrayList<Position> teachers = new ArrayList<>();
	public static ArrayList<Position> spaces = new ArrayList<>();

	    public static void main(String[] args){
	        Scanner sc = new Scanner(System.in);
	        N = sc.nextInt();
	        sc.nextLine();
	        
	        for(int i = 0; i < N; i++){
	            String[] strs = sc.nextLine().split(" ");
	            for(int j = 0; j < N; j++){
	                graph[i][j] = strs[j];
	                if(graph[i][j].equals("T")){
	                    teachers.add(new Position(i,j));
	                }
	                if(graph[i][j].equals("X")){
	                    spaces.add(new Position(i,j));
	                }
	            }
	        }
	        
	        Combination comb = new Combination(spaces.size(), 3);
	        comb.combination(spaces, 0, 0, 0);
	        ArrayList<ArrayList<Position>> spaceList = comb.result;
	        boolean findStu = false;
	       for(int i = 0 ; i < spaceList.size(); i++) {
	    	  
	    	   for(int j = 0 ; j < spaceList.get(i).size(); j++) {
	    		   int x = spaceList.get(i).get(j).x;
	    		   int y = spaceList.get(i).get(j).y;
	    		   
	    		   graph[x][y] = "O";
	    	   }
	    	   
	    	   if(process()) {
	    		   findStu = true;  
	    	   }else {
	    		   findStu = false;
	    		   break;
	    	   }
	    	   
	    	   for(int j = 0 ; j < spaceList.get(i).size(); j++) {
	    		   int x = spaceList.get(i).get(j).x;
	    		   int y = spaceList.get(i).get(j).y;
	    		   
	    		   graph[x][y] = "X";
	    	   }  
	    	   
	       	}
	       
	       if(findStu) System.out.println("NO");
	       else System.out.println("YES");
	    }
	    public static boolean process() {
	    	for(int i = 0 ; i < teachers.size(); i++) {
	    		int x = teachers.get(i).x;
	    		int y = teachers.get(i).y;
	    		for(int j = 0; j< 4; j++) {
	    			if(watch(x,y,j)) {
	    				return true;
	    			}
	    		}
	    	}
	    	return false;
	    }
	    public static boolean watch(int x, int y, int direction) {
	    	//��������
	    	if(direction == 0) {
	    		while(y<N) {
	    			if(graph[x][y].equals("S")) return true;
	    			if(graph[x][y].equals("O")) return false;
	    			y++;
	    		}
	    	}
	    	if(direction == 1) {
	    		while(y>=0) {
	    			if(graph[x][y].equals("S")) return true;
	    			if(graph[x][y].equals("O")) return false;
	    			y--;
	    		}
	    	}
	    	if(direction == 2) {
	    		while(x<N) {
	    			if(graph[x][y].equals("S")) return true;
	    			if(graph[x][y].equals("O")) return false;
	    			x++;
	    		}
	    	}
	    	if(direction == 3) {
	    		while(x>=0) {
	    			if(graph[x][y].equals("S")) return true;
	    			if(graph[x][y].equals("O")) return false;
	    			x--;
	    		}
	    	}
	    	return false;
	    	
	    }
}
