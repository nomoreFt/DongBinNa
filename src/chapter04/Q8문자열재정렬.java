package chapter04;
import java.util.*;

public class Q8문자열재정렬 {
	public static ArrayList<Character> alphas = new ArrayList<>();
	public static String str = "";
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String strs = sc.nextLine();
		
		char[] chs = strs.toCharArray();
		
		int result = 0;
		for(char ch : chs) {
			if(Character.isDigit(ch)) {
				result += ch -'0';
			}else {
				alphas.add(ch);
			}
		}
		Collections.sort(alphas);
		for(int i = 0; i < alphas.size(); i++) {
			str += alphas.get(i);
		}
		str += result;
		
		System.out.println(str);
	}

}
