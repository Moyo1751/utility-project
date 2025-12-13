package billing;

public class ElectricityBill extends Utility {
    private double standingDailyRate;
    private double electricUnitRate;
    private double standingCharge;
    private final Vat vat;

    public ElectricityBill(String location) {
        this.standingDailyRate = 22.63;
        this.electricUnitRate = 0.19349;
        this.standingCharge = calcStandingCharge(standingDailyRate);
        this.vat = new Vat(location);
    }

    public double getStandingCharge() {
        return standingCharge;
    }

    public double getElectricUsage(double openingDay, double closingDay,
            double openingNight, double closingNight) {
        double usageDay = calcUsage(openingDay, closingDay);
        double usageNight = calcUsage(openingNight, closingNight);
        return calcTotalUsage(usageDay, usageNight);
    }

    public double getElectricCost(double usage) {
        return calcCost(usage);
    }

    public double getVatAmount(double amount) {
        return calcVat(amount, this.vat.getVat());
    }

    public double getTotalCost(double electricCost, double vatAmount) {
        return calcTotalCost(electricCost, vatAmount);
    }

    public double calcUsage(double openingReading, double closingReading) {
        return closingReading - openingReading;
    }

    public double calcTotalUsage(double usageDay, double usageNight) {
        return usageNight + usageDay;
    }

    public double calcCost(double usage) {
        return roundToTwoDecimals(usage * this.electricUnitRate + this.standingCharge);
    }

    public double calcTotalCost(double electricCost, double vatAmount) {
        return electricCost + vatAmount;
    }
}
