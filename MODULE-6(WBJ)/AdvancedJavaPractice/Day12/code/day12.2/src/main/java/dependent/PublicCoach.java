package dependent;

import dependency.Coach;

public class PublicCoach implements Coach {    
    private Coach cricketCoach;
    private Coach footballCoach;
    private Coach SwimmingCoach;
    
    // No-argument constructor (needed by Spring)
    public PublicCoach() {
        System.out.println("In default constructor - " + getClass());
    }

    // Constructor-based Dependency Injection
    public PublicCoach(Coach cricketCoach, Coach footballCoach,Coach swimmingCoach) {
        this.cricketCoach = cricketCoach;
        this.footballCoach = footballCoach;
        this.SwimmingCoach = swimmingCoach;
        System.out.println("In constructor - " + getClass());
    }

    @Override
    public String getDailyWorkout() {
        System.out.println("Managing workouts here -");
        // Use the coaches to manage sports activities
        System.out.println(cricketCoach.getDailyWorkout());
        System.out.println(footballCoach.getDailyWorkout());
        System.out.println(SwimmingCoach.getDailyWorkout());
		return null;
    }

    // You can also define setter-based D.I. if necessary (for optional dependencies)
    // public void setCricketCoach(Coach cricketCoach) {
    //     this.cricketCoach = cricketCoach;
    // }

    // public void setFootballCoach(Coach footballCoach) {
    //     this.footballCoach = footballCoach;
    // }
}



