package 위상정렬TopologySort;

import java.util.*;

public class 위상정렬 {
    //노드의 개수, 간선의 개수
    static int n, m; 
    //모든 노드의 진입차수는 0으로 초기화
    static int[] indegree = new int[100001]; 
    //각 노드에 연결된 간선 정보를 담을 list
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static void topologySort(){
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        //처음 시작할때 진입차수가 0인 노드를 큐에 삽입
        for(int i = 1; i <= n; i++){
            if(indegree[i] == 0) q.offer(i);
        }
        
        while(!q.isEmpty()){
            int now = q.poll();
            result.add(now);
            //해당 원소와 연결된 노드들의 진입차수 1씩 빼기
            for(int i = 0; i < graph.get(now).size(); i++){
                indegree[graph.get(now).get(i)] -= 1;
                if(indegree[graph.get(now).get(i)] == 0){
                    q.offer(graph.get(now).get(i));
                }
            }
        }
        for(int i = 0; i < result.size(); i++){
            System.out.println(result.get(i) + " ");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i <= m; i++){
            graph.add(new ArrayList<Integer>());
        }
        
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            indegree[b] += 1;
        }
        topologySort();
    }
}
