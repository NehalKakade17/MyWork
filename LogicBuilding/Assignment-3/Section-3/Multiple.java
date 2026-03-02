package assign3;
import java.util.*;
public class Multiple {
	void mul() {
		for(int i =0;i<=100;i++) {
			if(i%7==0) {
				System.out.print(i+" ");
			}
		}
	}
	public static void main(String[] args) {
		Multiple m =new Multiple();
		m.mul();

	}

}
