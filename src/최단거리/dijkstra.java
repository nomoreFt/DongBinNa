package 최단거리;

import java.util.*;
public class dijkstra {

    static class Node implements Comparable<Node>{
        int idx;
        int distance;
        public Node (int idx, int distance){
            this.idx = idx;
            this.distance = distance;
        }
        @Override
        public int compareTo(Node other) {
            return this.distance - other.distance;
        }
        

    }
    static final int INF = (int) 1e9;
    public static int n, m, start;
    static int[] d = new int[100001];
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    public static void process(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));
        d[start] = 0;
        
        while(!pq.isEmpty()){
            Node n = pq.poll();
            int now = n.idx;
            int dist = n.distance;
            if(d[now] < dist) continue;
            for(int i = 0; i < graph.get(now).size(); i++){
                int cost = d[now] + graph.get(now).get(i).distance;
                if(cost < d[graph.get(now).get(i).idx]){
                    d[graph.get(now).get(i).idx] = cost;
                    pq.offer(new Node(graph.get(now).get(i).idx,cost));
                }
            }


        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node>());
        }
        
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            // a번 노드에서 b번 노드로 가는 비용이 c라는 의미
            graph.get(a).add(new Node(b, c));
        }

        Arrays.fill(d,INF);

        process(start);

        for(int i =1; i <=n; i++){
            if(d[i] == INF){
                System.out.println("INFINITY");
            }else{
                System.out.println(d[i]);
            }
        }

    }
}
