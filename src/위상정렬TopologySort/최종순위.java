package 위상정렬TopologySort;

import java.util.*;

public class 최종순위 {
    static int testCase;
    static int indegree[] = new int[501];
    static boolean[][] graph = new boolean[501][501];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        testCase = sc.nextInt();
        
        for(int t = 0; t < testCase; t++){
            Arrays.fill(indegree,0);
            for(int i = 0; i < 501; i++){
                Arrays.fill(graph[i],false);
            }
            int team = sc.nextInt();

            ArrayList<Integer> arr = new ArrayList<>();
            for(int i = 0; i < team; i++){
                arr.add(sc.nextInt());
            }

            for(int i = 0; i < team; i++){
                for(int j = i+1; j < team; j++){
                    graph[arr.get(i)][arr.get(j)] = true;
                    indegree[arr.get(j)]++;
                }
            }

            int c = sc.nextInt();
            for(int i = 0; i < c; i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                if(graph[a][b]){
                    graph[a][b] = false;
                    graph[b][a] = true;
                    indegree[b]--;
                    indegree[a]++;
                }else{
                    graph[a][b] = true;
                    graph[b][a] = false;
                    indegree[b]++;
                    indegree[a]--;
                }
            }

            ArrayList<Integer> result = new ArrayList<>();
            Queue<Integer> q = new LinkedList<>();
            
            for(int i = 0; i < arr.size(); i++){
                if(indegree[i] == 0) q.offer(i);
            }
            
            boolean certain = true; //위상정렬 결과가 오직 하나인지
            boolean cycle = false;  //사이클이 돌지 않는지 체크
            
            for(int i = 0; i < team; i++){
                if(q.size() == 0){
                    cycle = true;
                    break;
                }
                //q가 2개이상이라는건 가능한 정렬 결과가 여러개라는 의미
                if(q.size() >= 2){
                    certain = false;
                    break;
                }
                
                int now = q.poll();
                result.add(now);

                for(int j = 1; j <= team; j++){
                    if(graph[now][j]){
                        indegree[j] -= 1;
                        if(indegree[j] == 0){
                            q.offer(j);
                        }
                    }
                }
            }
               // 사이클이 발생하는 경우(일관성이 없는 경우)
               if (cycle) System.out.println("IMPOSSIBLE");
               // 위상 정렬 결과가 여러 개인 경우
               else if (!certain) System.out.println("?");
               // 위상 정렬을 수행한 결과 출력
               else {
                   for (int i = 0; i < result.size(); i++) {
                       System.out.print(result.get(i) + " ");
                   }
                   System.out.println();
               }
        }
    }    
}
