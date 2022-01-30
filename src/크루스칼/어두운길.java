package 크루스칼;

import java.util.*;

public class 어두운길 {
    static class Edge implements Comparable<Edge>{
        int nodeA;
        int nodeB;
        int cost;
        public Edge(int nodeA, int nodeB, int cost){
            this.nodeA = nodeA;
            this.nodeB = nodeB;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge other){
            return this.cost - other.cost;
        }
    }
    static int n,m;
    static int total = 0;
    static int min = 0;
    static int[] parent;
    static ArrayList<Edge> edges = new ArrayList<>();
    static int findParent(int x){
        if(x == parent[x]) return x;
        else return parent[x] = findParent(parent[x]);
    }
    static void unionParent(int a, int b){
        a = findParent(a);
        b = findParent(b);
        if(a < b) parent[b] = a;
        else parent[a] = b;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();//집의 수 
        m = sc.nextInt();//도로의 수
        parent = new int[n];
        for(int i = 0; i <= n; i++){
            parent[i] = i;
        }
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();
            total += cost;
           edges.add(new Edge(a, b, cost));     
        }
        Collections.sort(edges);
        
        for(int i = 0; i < edges.size(); i++){
            Edge ed = edges.get(i);
            int nodeA = ed.nodeA;
            int nodeB = ed.nodeB;
            int cost = ed.cost;

            if(findParent(nodeA) != findParent(nodeB)){
                min += cost;
                unionParent(nodeA,nodeB);
            }
        }

        System.out.println(total - min);
    }
}
