import java.util.Date;
import java.util.StringTokenizer;
import java.util.Hashtable;

public class MapDemo {
	public static void main(String[] args) {
		Date now = new Date();
		String nowStr = now.toString();   //Wed Jul 17 15:37:08 KST 2024
		//문자열 Parsing 방법 3가지
		//1. String class's split()        String [] array = split(String regex)
		//2. java.util.Scanner class's useDelemeter()   new Scanner(문자열).useDelemeter(String regex)
		//3. java.util.StringTokenizer class 
		StringTokenizer st = new StringTokenizer(nowStr);
		String [] array = new String[st.countTokens()];
		for(int i = 0 ; i < array.length ; i++) {
			array[i] = st.nextToken();
			//System.out.println(st.nextToken());
		}
		System.out.print("오늘은 " + array[5] + "년 "); 
		System.out.println(	getMonthbyName(array[1]) + "월 " + array[2] + "일입니다.");
	}
	static int getMonthbyName(String month) {
		Hashtable<String, Integer> ht = new Hashtable<String, Integer>();
		ht.put("Jan", 1);   ht.put("Feb", 2);   ht.put("Mar", 3);  ht.put("Apr", 4);
		ht.put("May", 5);   ht.put("Jun", 6);   ht.put("Jul", 7);  ht.put("Aug", 8);
		ht.put("Sep", 9);   ht.put("Oct", 10);   ht.put("Nov", 11);  ht.put("Dec", 12);
		return ht.get(month);
	}
}
