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

    public double getElectricCost(double usage) {
        return calcCost(usage);
    }

    public double getVatAmount(double amount) {
        return calcVat(amount);
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
        return usage * this.electricUnitRate;
    }

    public double calcVat(double amount) {
        return amount * this.vat.getVat();
    }

    public double calcTotalCost(double electricCost, double vatAmount) {
        return this.standingCharge + electricCost + vatAmount;
    }
}
