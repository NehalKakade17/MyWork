package tester;

import dependency.EnglishTeacher;
import dependency.MathsTeacher;
import dependency.ScienceTeacher;
import dependency.Teacher;
import dependent.PublicSchool;

public class TestSchool {

	public static void main(String[] args) {
		Teacher englishTeacher = new EnglishTeacher();
        Teacher scienceTeacher = new ScienceTeacher();
        Teacher mathsTeacher = new MathsTeacher();
        // Inject both teachers into the PublicSchool constructor
        PublicSchool mySchool = new PublicSchool(englishTeacher, scienceTeacher,mathsTeacher);
        
        // Call the manageAcademics method to see the result
        mySchool.manageAcademics();
    }
}


