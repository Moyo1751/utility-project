package billing;

public abstract class Utility {

    private final int standingDays = 33;

    public double calcStandingCharge(double standingDailyRate) {
        return (standingDailyRate / 100) * standingDays;
    }

    public abstract double calcUsage(double openingReading, double closingReading);

    public abstract double calcCost(double usage);

    public abstract double calcTotalCost(double cost, double vatAmount);

    public double calcVat(double amount, double vat) {
        return roundToTwoDecimals(amount * vat);
    }

    public String formatCost(double cost) {
        return String.format("£%.2f", cost);
    }

    protected double roundToTwoDecimals(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
