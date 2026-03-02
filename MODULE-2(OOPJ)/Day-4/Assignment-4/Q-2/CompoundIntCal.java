package assign4;
public class CompoundIntCal {
    private double principal;
    private double annualIntR;
    private int numOfComp;
    private int years;
    public CompoundIntCal(double principal, double annualIntR, int numOfComp, int years) {
        this.principal = principal;
        this.annualIntR = annualIntR;
        this.numOfComp = numOfComp;
        this.years = years;
    }
    public double getPrincipal() {
        return principal;
    }

    public void setPrincipal(double principal) {
        this.principal = principal;
    }

    public double getAnnualInterestRate() {
        return annualIntR;
    }

    public void setAnnualInterestRate(double annualIntR) {
        this.annualIntR = annualIntR;
    }

    public int getNumberOfCompounds() {
        return numOfComp;
    }

    public void setNumberOfCompounds(int numOfComp) {
        this.numOfComp = numOfComp;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }
    public double calculateFutureValue() {
        double ratePerPeriod = annualIntR / numOfComp;
        int totalPeriods = numOfComp * years;
        return principal * Math.pow(1 + ratePerPeriod, totalPeriods);
    }
    public double calculateTotalInterest() {
        return calculateFutureValue() - principal;
    }

    @Override
    public String toString() {
        return String.format("Principal: ₹%.2f\nAnnual Interest Rate: %.2f%%\nNumber of Compounds per Year: %d\nInvestment Duration: %d years",
                             principal, annualIntR, numOfComp, years);
    }
}

