package 최단거리;

import java.util.*;

import 최단거리.dijkstra.Node;

public class Q37전보 {
    static final int INF = (int)1e9;
    static int N,M,START;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static int[] d = new int[300001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        START = sc.nextInt();

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<Node>());
        }

            Arrays.fill(d,INF);

        for(int i = 0 ; i < M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Node(b,c));
        }

        process(START);
        
        int cities = 0;
        int cost = 0;
        
        for(int i = 1; i<=N; i++){
            if(d[i] != INF){
                cities +=1;
                cost = Math.max(cost, d[i]);
            }
            
        }

        System.out.println(cities-1 + " " + cost);
    }
    static void process(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        d[start] = 0;
        pq.offer(new Node(start,0));

        while(!pq.isEmpty()){
            Node n = pq.poll();
            int now = n.idx;
            int dist = n.distance;
            if(d[now] < dist) continue;
            for(int i = 0; i < graph.get(now).size(); i++){
                int cost = graph.get(now).get(i).distance + d[now];
                if(cost < d[graph.get(now).get(i).idx]){
                    pq.offer(new Node(graph.get(now).get(i).idx,cost));
                    d[graph.get(now).get(i).idx] = cost;
                }
            }
        }
    }
}
