package tester;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import dependent.PublicCoach;
import dependent.PublicSchool;

public class TestSpringContainer {

	public static void main(String[] args) {
		// start SC (Spring Container) in a standalone app
		try (ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("bean_config.xml")) {
			System.out.println("SC up n running !");
			//exec B.L - manage acads
			PublicSchool school1=
					context.getBean("public_school", PublicSchool.class);
			//B.L
			school1.manageAcademics();
			PublicSchool school2=
					context.getBean("public_school", PublicSchool.class);
		
			System.out.println(school1 == school2);//true since it's singleton
			PublicCoach coach1 = context.getBean("public_coach",PublicCoach.class);
			coach1.getDailyWorkout();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
