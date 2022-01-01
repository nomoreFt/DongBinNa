package 정렬;

import java.util.*;

class Home implements Comparable<Home>{
    int idx;
    int sumDistance;
    public void setSumDistance(int x){
        this.sumDistance= x;
    }
    public Home(int idx){
        this.idx = idx;
    }
    @Override
    public int compareTo(Home other){
        if(this.sumDistance == other.sumDistance) {
            return this.idx - other.idx;
        }
        return this.sumDistance - other.sumDistance;
    }
}

class Q24안테나{
    static ArrayList<Home> homes = new ArrayList<>();
    static int N,min;
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     N = sc.nextInt();
     for(int i = 0; i < N; i++){
         homes.add(new Home(sc.nextInt()));
     }
     for(int i = 0; i < N; i++){
        int antena = homes.get(i).idx;
        int sum = 0;
        for(int j = 0; j < N; j++){
            sum += Math.abs(antena - homes.get(j).idx);
        }
        homes.get(i).setSumDistance(sum);
     }  

     Collections.sort(homes);
     
     System.out.println(homes.get(0).idx);
 }   
}