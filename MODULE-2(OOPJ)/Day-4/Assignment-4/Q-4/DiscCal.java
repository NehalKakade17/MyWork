package assign4;
public class DiscCal {
    private double origP;
    private double disR;
    public DiscCal(double originalPrice, double discountRate) {
        this.origP = originalPrice;
        this.disR = discountRate;
    }
    public double getOriginalPrice() {
        return origP;
    }

    public void setOriginalPrice(double origP) {
        this.origP = origP;
    }

    public double getDiscountRate() {
        return disR;
    }

    public void setDiscountRate(double disR) {
        this.disR = disR;
    }
    public double calculateDiscountAmount() {
        return origP * (disR / 100);
    }
    public double calculateFinalPrice() {
        return origP - calculateDiscountAmount();
    }

    @Override
    public String toString() {
        return String.format("Original Price: ₹%.2f\nDiscount Rate: %.2f%%", origP, disR);
    }
}

