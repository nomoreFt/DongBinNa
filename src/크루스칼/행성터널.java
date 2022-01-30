package 크루스칼;

import java.util.*;

public class 행성터널 {
    static class Planet{
        int idx;
        int x;
        int y;
        int z;
        public Planet(int idx, int x, int y, int z){
            this.idx = idx;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
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

    static int n,min = 0;
    static int[] parents = new int[100001];
    static ArrayList<Planet> planets = new ArrayList<>();
    static ArrayList<Edge> edges = new ArrayList<>();
    static int getCost(Planet a, Planet b){
        return Math.min(Math.abs(a.x-b.x),Math.min(Math.abs(a.y-b.y),Math.abs(a.z-b.z)));
    }
    static int findParent(int x){
        if(x == parents[x]) return x;
        else return parents[x] = findParent(parents[x]);
    }
    static void unionParent(int a, int b){
        a = findParent(a);
        b = findParent(b);
        if(a < b) parents[b] = a;
        else parents[a] = b;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        
        for(int i = 0; i < n; i++){
            parents[i] = i;
        }
        for(int i = 0; i < n; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            planets.add(new Planet(i, x, y, z));
        }
        for(int i = 0; i < n; i++){
            Planet planetA = planets.get(i);
            for(int j = i+1; j < n; j++){
            Planet planetB = planets.get(j);
            edges.add(new Edge(i, j, getCost(planetA,planetB)));
            }
        }
        Collections.sort(edges);
        
        int result = 0;
        for(int i = 0; i < edges.size(); i++){
            Edge ed = edges.get(i);
            int a = ed.nodeA;
            int b = ed.nodeB;
            int cost = ed.cost;
            if(findParent(a) != findParent(b)){
                unionParent(a,b);
                result += cost;
            }
        }
        System.out.println(result);
    }    
}
