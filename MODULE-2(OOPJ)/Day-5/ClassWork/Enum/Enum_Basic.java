package selfstudy;

public class Enum_Basic {
	enum Color{
		RED,
		BLUE,
		GREEN
	}
	public static void main(String[] args) {
		Color[] c = Color.values();
		for(Color col : c) {
			System.out.println(col.name()+" "+col.ordinal());
		}

	}

}
