import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeDemo {
	public static void main(String[] args) {
		//Date now = new Date();
		//System.out.println(now);    //now.toString()
		//Calendar cal = new Calendar();
		
		//Calendar cal = Calendar.getInstance();   
		//System.out.printf("오늘은 %d년 %d월 %d일입니다.%n", 
		//		cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, 
		//		//cal.get(Calendar.DATE));
		//		cal.get(Calendar.DAY_OF_MONTH));
		
		//Calendar cal = new GregorianCalendar(2024, 11, 25);
		//System.out.printf("금년은 %d년%n", cal.get(Calendar.YEAR));
		
//		DateFormat df = DateFormat.getDateTimeInstance(
//				DateFormat.FULL, DateFormat.MEDIUM, Locale.FRENCH);
//		System.out.println(df.format(new Date()));
		
//		String pattern = "오늘은 yyyy년 MM월 dd일입니다.";
//		DateFormat df = new SimpleDateFormat(pattern);
//		System.out.println(df.format(new Date()));
		
		//String pattern = String.format("오늘은 %1$tY년 %1$tm월 %1$td일입니다", new Date());
		//System.out.println(pattern);
		System.out.printf("오늘은 %1$tY년 %1$tm월 %1$td일입니다", new Date());
	}
}
