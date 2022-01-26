package 위상정렬TopologySort;

import java.util.*;

/*
* 위상ㅈ
*/

public class 커리큘럼 {
    static int v;
    static int[] indegree = new int[501];
    static int[] times = new int[501];
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    static void topology(){
        int[] result = new int[501];
        for(int i = 1; i <= v; i++){
            result[i] = times[i];
        }
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 1; i <= v; i++){
            if(indegree[i] == 0) q.offer(i);
        }
        while(!q.isEmpty()){
            int now = q.poll();
            //원소와 연결된 진입차수에서 1 뱨기
            for(int i = 0; i < graph.get(now).size(); i++){
                result[graph.get(now).get(i)] = Math.max(result[graph.get(now).get(i)], result[now] + times[graph.get(now).get(i)]);
                indegree[graph.get(now).get(i)] -= 1;
                if(indegree[graph.get(now).get(i)] == 0){
                    q.offer(graph.get(now).get(i));
                }
            }
        }
        for(int i = 1; i <=v ; i++){
            System.out.println(result[i]);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        v = sc.nextInt();

        // 그래프 초기화
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for(int i = 1; i <= v; i++){
            int t = sc.nextInt();
            times[i] = t;

            while(true){
                t = sc.nextInt();
                if(t == -1) break;
                indegree[i] += 1;
                graph.get(t).add(i);
            }
        }
        topology();
    }
}
