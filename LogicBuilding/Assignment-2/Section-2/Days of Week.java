public class DayClassifier {
    public static void main(String[] args) {
        int dayNumber = 3;
        switch (dayNumber) {
            case 1:
                System.out.println("Monday");
                switch (dayNumber) {
                    case 1:
                        System.out.println("It is a weekday.");
                        break;
                }
                break;
            case 2:
                System.out.println("Tuesday");
                 switch (dayNumber) {
                    case 2:
                        System.out.println("It is a weekday.");
                        break;
                }
                break;
            case 3:
                System.out.println("Wednesday");
                switch (dayNumber) {
                    case 3:
                        System.out.println("It is a weekday.");
                        break;
                }
                break;
            case 4:
                System.out.println("Thursday");
                switch (dayNumber) {
                    case 4:
                        System.out.println("It is a weekday.");
                        break;
                }
                break;
            case 5:
                System.out.println("Friday");
                switch (dayNumber) {
                    case 5:
                        System.out.println("It is a weekday.");
                        break;
                }
                break;
            case 6:
                System.out.println("Saturday");
                switch (dayNumber) {
                    case 6:
                        System.out.println("It is a weekend.");
                        break;
                }
                break;
            case 7:
                System.out.println("Sunday");
                switch (dayNumber) {
                    case 7:
                        System.out.println("It is a weekend.");
                        break;
                }
                break;
            default:
                System.out.println("Invalid day number. Please enter a number between 1 and 7.");
                break;
        }
    }
}