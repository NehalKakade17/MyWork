package selfstudy;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Date_Program {

	public static void main(String[] args) {
//		Date d = new Date();
//		int day = d.getDate();
//		int month = d.getMonth()+1;
//		int year = d.getYear()+1900;
//		System.out.println(day+"/"+month+"/"+year);
//		long tm = System.currentTimeMillis();
//		Date d = new Date(tm);
//		System.out.println(d.toString());
//		String pt = "dd-mm-yyyy";
//		SimpleDateFormat sdf = new SimpleDateFormat(pt);
//		Date d = new Date();
//		String date = sdf.format(d);
//		System.out.println(date);
		String pt = "dd-MM-yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(pt);
		String mydate = "04-01-2002";
		Date d;
		try {
			d = sdf.parse(mydate);
			System.out.println(d.toString());
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		

	}

}
