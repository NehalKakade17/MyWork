package dependent;

import dependency.Teacher;


public class PublicSchool implements School {    
    private Teacher englishTeacher;
    private Teacher scienceTeacher;
    private Teacher mathsTeacher;

    // No-argument constructor (needed by Spring)
    public PublicSchool() {
        System.out.println("In default constructor - " + getClass());
    }

    // Constructor-based Dependency Injection
    public PublicSchool(Teacher englishTeacher, Teacher scienceTeacher,Teacher mathsTeacher) {
        this.englishTeacher = englishTeacher;
        this.scienceTeacher = scienceTeacher;
        this.mathsTeacher = mathsTeacher;
        System.out.println("In constructor - " + getClass());
    }

    @Override
    public void manageAcademics() {
        System.out.println("Managing academics here -");
        englishTeacher.teach();
        scienceTeacher.teach();
        mathsTeacher.teach();
    }


	

	

//	//setter based D.I - injecting optional dependencies !
//	public void setSubjectTeacher(Teacher subjectTeacher) {
//		System.out.println("in setter");
//		this.subjectTeacher = subjectTeacher;
//	}
	

	

}
