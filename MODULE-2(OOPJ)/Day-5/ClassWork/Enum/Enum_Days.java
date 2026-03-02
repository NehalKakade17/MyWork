package selfstudy;

public class Enum_Days {
	enum Days{
		SUNDAY,MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY
	}

	public static void main(String[] args) {
		Days[] d = Days.values();
		for(Days day : d) {
			System.out.println(day.ordinal()+1+" Day = "+day.name());
		}

	}

}
