package billing;

public class GasBill extends Utility {
    private double standingDailyRate;
    private double gasUnitRate;
    private double correctionFactor = 1.02264;
    private double conversionFactor = 2.83;
    private double calorificValue = 39.4 / 3.6;
    private double standingCharge;
    // private String readType;
    private final Vat vat;

    public GasBill(String location) {
        this.standingDailyRate = 24.87;
        this.gasUnitRate = 0.03797;
        this.standingCharge = calcStandingCharge(standingDailyRate);
        this.vat = new Vat(location);
        // this.readType = readType;
    }

    public double getStandingCharge() {
        return this.standingCharge;
    }

    public double getGasUsage(double openingReading, double closingReading) {
        return calcUsageInKWh(convertReadingToCubicMeters(calcUsage(openingReading, closingReading)));
    }

    public double getGasCost(double usageAmount) {
        return calcCost(usageAmount);
    }

    public double getVatAmount(double amount) {
        return calcVat(amount, this.vat.getVat());
    }

    public double calcUsage(double openingReading, double closingReading) {
        return closingReading - openingReading;
    }

    public double convertReadingToCubicMeters(double reading) {
        return reading * this.conversionFactor;
    }

    public double calcUsageInKWh(double usageAmount) {
        return usageAmount * this.correctionFactor * this.calorificValue;
    }

    public double calcCost(double usageAmount) {
        return roundToTwoDecimals(usageAmount * this.gasUnitRate + this.standingCharge);
    }

    public double calcTotalCost(double gasCost, double vatAmount) {
        return gasCost + vatAmount;
    }

}
