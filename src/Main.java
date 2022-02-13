import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        int T = sc.nextInt();
        int cnt300 = 0;
        int cnt60 = 0;
        int cnt10 = 0;

        if(T <300){
            while(T % 60 > 0){
                T -= 10;
                cnt10++;
            }
            if(T < 0) {
                System.out.println("-1");
                return;
            }
            cnt60 += T/60;
        }else{
            while(T >= 300){
                T-=300;
                cnt300++;
            }
            while(T >= 60){
                T-=60;
                cnt60++;
            }
            while(T >= 10){
                T-=10;
                cnt10++;
            }
            if(T <= 9 && T != 0){
                System.out.println("-1");
                return;
            }
        }

        System.out.println(cnt300 + " " + cnt60 + " " + cnt10);
      
}
}
