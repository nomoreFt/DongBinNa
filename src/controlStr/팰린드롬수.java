package controlStr;

import java.util.Scanner;

public class 팰린드롬수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = "";
        while(true){
            str = sc.nextLine();
            if(str.equals("0")) break;
            String rts = new StringBuffer(str).reverse().toString();

            if(str.equals(rts)) System.out.println("yes");
            else System.out.println("no");
        }
        sc.close();
    }
    
}
