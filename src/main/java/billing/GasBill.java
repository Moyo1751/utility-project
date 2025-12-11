package billing;

public class GasBill extends Utility {
    private double standingDailyRate;
    private double gasUnitRate;
    private double standingCharge;
    private final Vat vat;

    public GasBill(String location) {
        this.standingDailyRate = 24.87;
        this.gasUnitRate = 0.03797;
        this.standingCharge = calcStandingCharge(standingDailyRate);
        this.vat = new Vat(location);
    }

    public double calcUsage(double startReading, double endReading) {
        return endReading - startReading;
    }

    public double calcTotalCost(double usageAmount, double ratePerUnit) {
        return usageAmount * ratePerUnit + this.standingCharge;
    }

    public double calcCost(double usageAmount) {
        return usageAmount;
    }

}
