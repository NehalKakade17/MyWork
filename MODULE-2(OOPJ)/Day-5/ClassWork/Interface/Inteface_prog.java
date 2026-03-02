package selfstudy;
interface add{
	int num1 = 5+9;
}
interface sub{
	int num2 = 7-2;
}
interface main extends add,sub{
	int num3 = 100;
}
public class Inteface_prog {

	public static void main(String[] args) {
		System.out.println("Number- "+add.num1);
		System.out.println("Number- "+sub.num2);
		System.out.println("Number- "+main.num3);
		System.out.println("Number- "+main.num1);
		System.out.println("Number- "+main.num2);

	}

}
