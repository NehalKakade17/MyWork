package assign4;
public class LoanAmCal {
    private double principal;
    private double annualIntR;
    private int loanT;

    public LoanAmCal(double principal, double annualIntR, int loanT) {
        this.principal = principal;
        this.annualIntR = annualIntR;
        this.loanT = loanT;
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

    public int getLoanTerm() {
        return loanT;
    }

    public void setLoanTerm(int loanT) {
        this.loanT = loanT;
    }

    public double calculateMonthlyPayment() {
        double monthlyInterestRate = annualIntR / 12 / 100;
        int numberOfMonths = loanT * 12;
        return principal * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfMonths)) / 
               (Math.pow(1 + monthlyInterestRate, numberOfMonths) - 1);
    }

    public double calculateTotalAmountPaid() {
        return calculateMonthlyPayment() * loanT * 12;
    }

    @Override
    public String toString() {
        return String.format("Principal: ₹%.2f\nAnnual Interest Rate: %.2f%%\nLoan Term: %d years", 
                             principal, annualIntR, loanT);
    }
}

