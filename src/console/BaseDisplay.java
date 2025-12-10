package console;

import java.util.Scanner;

import billing.ElectricityBill;

public class BaseDisplay {
    private Scanner scanner = new Scanner(System.in);
    private ElectricityBill electricBill;
    private String name;

    public BaseDisplay() {
        System.out.println("============ Welcome to the Utility Billing System ============");
        System.out.print("Please enter your name: ");
        this.name = scanner.nextLine();
        System.out.print("Please enter your location (US/UK/FR/IT): ");
        String location = scanner.nextLine();
        System.out.println("Hello, " + name + "! Let's generate your utility bill.");
        electricBill = new ElectricityBill(location);
    }

    public static void main(String[] args) {
        System.out.println("\n============ Utility Bill ============");
        BaseDisplay display = new BaseDisplay();
        display.generateElectricBill();
        System.out.println("======================================");
    }

    public void generateElectricBill() {
        System.out.println("Generating electric bill...");
        double standingCharge = electricBill.getStandingCharge();
        System.out.println("Please enter your electric meter readings.");
        System.out.print("Opening electric reading (night): ");
        double openingElectricReadingNight = scanner.nextDouble();
        System.out.print("Closing electric reading (night): ");
        double closingElectricReadingNight = scanner.nextDouble();
        System.out.print("Opening electric reading (day): ");
        double openingElectricReadingDay = scanner.nextDouble();
        System.out.print("Closing electric reading (day): ");
        double closingElectricReadingDay = scanner.nextDouble();

        double electricUsageNight = electricBill.calcUsage(openingElectricReadingNight, closingElectricReadingNight);
        double electricUsageDay = electricBill.calcUsage(openingElectricReadingDay, closingElectricReadingDay);
        double electricUsage = electricBill.calcTotalUsage(electricUsageDay, electricUsageNight);
        double electricCost = electricBill.calcCost(electricUsage);
        double vatAmount = electricBill.getVatAmount(electricCost + standingCharge);
        double totalCost = electricBill.calcTotalCost(electricCost, vatAmount);
        printElectricBill(standingCharge, electricCost, totalCost, vatAmount);
    }

    public void printElectricBill(double standingCharge, double electricCost, double totalCost, double vatAmount) {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("\n============ " + this.name + "'s Bill ============");
        System.out.println("Note: All costs are shown including VAT.");
        System.out.println("Electric Bill Details:");
        System.out.println("Standing Charge: " + electricBill.formatCost(standingCharge));
        System.out.println("Electric Cost: " + electricBill.formatCost(electricCost));
        System.out.println("VAT Amount: " + electricBill.formatCost(vatAmount));
        System.out.println("Total Cost: " + electricBill.formatCost(totalCost));
    }
}
