package selfstudy;
class Calct{
	private int num1;
	private static int num2;
	Calct(){
		this.num1 = 30;
		Calct.num2 = 70;
	}
	class InnerCal{
		public int num3;
		private static int num4;
		InnerCal(){
			this.num3 = 80;
			InnerCal.num4 = 55;
		}
		public int mul() {
			Calct ct = new Calct();
			return (ct.num1+num2)*(num3+num4);
		}
	}
	
	public int calculation() {
		InnerCal in = new InnerCal();
		return (this.num1*num2)+(in.num3*InnerCal.num4);
	}
}
public class Nested {

	public static void main(String[] args) {
		Calct c = new Calct();
		Calct.InnerCal ct = new Calct().new InnerCal();
		System.out.println("Result1: "+c.calculation());
		System.out.println("Result2: "+ct.mul());

	}

}
