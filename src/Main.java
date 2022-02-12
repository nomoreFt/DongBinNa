import java.util.*;

public class Main {
    static final int INF = (int) 1e9;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = INF;
        int temp = n;
        
        int max5 = 0;
        max5 = n / 5;
        if(n == 3) {
            System.out.println("1");
            return;
        }

        if(n == 4){
            System.out.println("-1");
            return;
        }
        for(int i = max5; i >= 0; i--){
            temp = n;
            temp -= 5 * max5;
            if(temp == 0){
                result = Math.min(result,i);
            }else{
                if(temp % 3 == 0){
                   result = Math.min(result,(i + temp/3)); 
                }else{
                    continue;
                }
            }
        }
        if(result >= INF){
            System.out.println("-1");
        }else{
            System.out.println(result);
        }
        
}
}
