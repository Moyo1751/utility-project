public class App {
    public static void main(String[] args) throws Exception {
        double dailyStandingCharge = 22.63;
        double electricUnitRate = 0.19349;
        int standingChargeDays = 33;
        double openingElectricReadingNight = 40470.637;
        double closingElectricReadingNight = 40516.687;
        double openingElectricReadingDay = 37386.998;
        double closingElectricReadingDay = 37623.210;
        double vatRate = 0.05;

        double standingCharge = new App().calcStandingCharge(dailyStandingCharge, standingChargeDays);
        double electricUsageNight = new App().calcElectricUsage(openingElectricReadingNight,
                closingElectricReadingNight);
        double electricUsageDay = new App().calcElectricUsage(openingElectricReadingDay, closingElectricReadingDay);
        double electricUsage = electricUsageNight + electricUsageDay;
        double electricCost = new App().calcElectricCost(electricUsage, electricUnitRate);
        double vatAmount = new App().calcVat(electricCost + standingCharge, vatRate);
        double totalCost = new App().calcTotalCost(standingCharge, electricCost, vatAmount);
        new App().printBill(standingCharge, electricCost, totalCost);
    }

    public double calcStandingCharge(double dailyRate, Integer days) {
        return (dailyRate / 100) * days;
    }

    public double calcElectricUsage(double openingReading, double closingReading) {
        return closingReading - openingReading;
    }

    public double calcElectricCost(double usage, double unitRate) {
        return usage * unitRate;
    }

    public double calcVat(double amount, double vatRate) {
        return amount * vatRate;
    }

    public double calcTotalCost(double standingCharge, double electricCost, double vatAmount) {
        return standingCharge + electricCost + vatAmount;
    }

    public String formatCost(double cost) {
        return String.format("£%.2f", cost);
    }

    public void printBill(double standingCharge, double electricCost, double totalCost) {
        System.out.println("Standing Charge: " + formatCost(standingCharge));
        System.out.println("Electric Cost: " + formatCost(electricCost));
        System.out.println("Total Cost: " + formatCost(totalCost));
    }
}
