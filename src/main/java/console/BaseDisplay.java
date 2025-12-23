package console;

import java.util.Scanner;

import billing.ElectricityBill;
import billing.GasBill;

public class BaseDisplay {
    private Scanner scanner = new Scanner(System.in);
    private ElectricityBill electricBill;
    private String name;
    private GasBill gasBill;
    // Class<?> BreadCrumb = new GasBill("UK");

    public BaseDisplay() {
        System.out.println("============ Welcome to the Utility Billing System ============");
        CreateAccountDisplay createAccountDisplay = new CreateAccountDisplay();
        this.name = createAccountDisplay.getName();
        String location = createAccountDisplay.getLocation();
        System.out.println("Hello, " + name + "! Let's generate your utility bill.");
        electricBill = new ElectricityBill(location);
        gasBill = new GasBill(location);
    }

    public static void main(String[] args) {
        System.out.println("\n============ Utility Bill ============");
        BaseDisplay display = new BaseDisplay();
        display.generateBill();
        System.out.println("======================================");
    }

    public void generateBill() {
        System.out.println("Generating electric bill...");
        double electricStandingCharge = electricBill.getStandingCharge();
        System.out.println("Please enter your electric meter readings.");
        System.out.print("Opening electric reading (night): ");
        double openingElectricReadingNight = scanner.nextDouble();
        System.out.print("Closing electric reading (night): ");
        double closingElectricReadingNight = scanner.nextDouble();
        System.out.print("Opening electric reading (day): ");
        double openingElectricReadingDay = scanner.nextDouble();
        System.out.print("Closing electric reading (day): ");
        double closingElectricReadingDay = scanner.nextDouble();

        double electricUsage = electricBill.getElectricUsage(openingElectricReadingDay,
                closingElectricReadingDay, openingElectricReadingNight, closingElectricReadingNight);
        double electricCost = electricBill.getElectricCost(electricUsage);
        double electricVatAmount = electricBill.getVatAmount(electricCost);
        double electricTotalCost = electricBill.calcTotalCost(electricCost, electricVatAmount);

        System.out.println("Please enter your gas meter readings.");
        System.out.println("Generating gas bill...");
        double gasStandingCharge = gasBill.getStandingCharge();
        System.out.println("Please enter your electric meter readings.");
        System.out.print("Opening gas reading: ");
        double openingGasReading = scanner.nextDouble();
        System.out.print("Closing gas reading: ");
        double closingGasReadingNight = scanner.nextDouble();

        double gasUsageKWh = gasBill.getGasUsage(openingGasReading, closingGasReadingNight);
        double gasCost = gasBill.getGasCost(gasUsageKWh);
        double gasVatAmount = gasBill.getVatAmount(gasCost);
        double gasTotalCost = gasBill.calcTotalCost(gasCost, gasVatAmount);

        printBill(electricStandingCharge, electricCost, electricTotalCost, electricVatAmount,
                gasStandingCharge, gasCost, gasTotalCost, gasVatAmount);
    }

    public void printBill(double electricStandingCharge, double electricCost, double electricTotalCost,
            double electricVatAmount, double gasStandingCharge, double gasCost, double gasTotalCost,
            double gasVatAmount) {
        System.out.println();
        System.out.println();
        System.out.println("\n============ " + this.name + "'s Bill ============");
        System.out.println("Note: All costs are shown including VAT.");
        System.out.println("Electric Bill Details:");
        System.out.println("Electric Standing Charge: " + electricBill.formatCost(electricStandingCharge));
        System.out.println("Electric Cost: " + electricBill.formatCost(electricCost));
        System.out.println("Electric VAT Amount: " + electricBill.formatCost(electricVatAmount));
        System.out.println("Electric Total Cost: " + electricBill.formatCost(electricTotalCost));
        System.out.println("Gas Bill Details:");
        System.out.println("Gas Standing Charge: " + gasBill.formatCost(gasStandingCharge));
        System.out.println("Gas Cost: " + gasBill.formatCost(gasCost));
        System.out.println("Gas VAT Amount: " + gasBill.formatCost(gasVatAmount));
        System.out.println("Gas Total Cost: " + gasBill.formatCost(gasTotalCost));
    }
}
