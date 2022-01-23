package controlStr;

import java.util.Scanner;

public class reverse {
 
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String A = in.nextLine();
		String B = in.nextLine();
        
        String reverse = new StringBuffer(B).reverse().toString();
        
        int numA = Integer.parseInt(A);
        int numB = Integer.parseInt(B);
        
        for(int i = 0; i < reverse.length(); i++){
            System.out.println(numA * (reverse.charAt(i) - '0'));
        }
        
        
        
        in.close();
		System.out.println(numA*numB);
		
	}
}
