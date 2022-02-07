import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(sc.nextInt());
        arr.add(sc.nextInt());
        
        System.out.println(arr.stream().mapToInt(i -> i).sum());
    }
}