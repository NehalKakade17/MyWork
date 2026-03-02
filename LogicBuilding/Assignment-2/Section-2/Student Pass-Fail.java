import java.util.Scanner;

public class GradeEvaluation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         System.out.print("Enter the grade for Subject 1: ");
        int grade1 = scanner.nextInt();
        System.out.print("Enter the grade for Subject 2: ");
        int grade2 = scanner.nextInt();
        System.out.print("Enter the grade for Subject 3: ");
        int grade3 = scanner.nextInt();
        int failedSubjects = 0;
        if (grade1 <= 40) {
            failedSubjects++;
        }
        if (grade2 <= 40) {
            failedSubjects++;
        }
        if (grade3 <= 40) {
            failedSubjects++;
        }
        if (failedSubjects > 0) {
            System.out.println("The student has failed in " + failedSubjects + " subject(s).");
        } else {
            System.out.println("The student has passed in all subjects.");
        }
        scanner.close();
    }
}