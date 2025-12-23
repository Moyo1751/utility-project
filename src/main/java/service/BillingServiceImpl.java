package service;

import java.time.LocalDateTime;

import billing.ElectricityBill;
import billing.GasBill;
import model.BillingRecord;
import model.MeterReading;

public class BillingServiceImpl implements BillingService {

    @Override
    public BillingRecord generateBill(String customerName, String location, MeterReading readings) {
        ElectricityBill electricBill = new ElectricityBill(location);
        GasBill gasBill = new GasBill(location);

        double electricStandingCharge = electricBill.getStandingCharge();

        double electricUsage = electricBill.getElectricUsage(
                readings.getOpeningElectricDay(),
                readings.getClosingElectricDay(),
                readings.getOpeningElectricNight(),
                readings.getClosingElectricNight());

        double electricCost = electricBill.getElectricCost(electricUsage);
        double electricVatAmount = electricBill.getVatAmount(electricCost);
        double electricTotalCost = electricBill.calcTotalCost(electricCost, electricVatAmount);

        double gasStandingCharge = gasBill.getStandingCharge();

        double gasUsageKWh = gasBill.getGasUsage(
                readings.getOpeningGas(),
                readings.getClosingGas());

        double gasCost = gasBill.getGasCost(gasUsageKWh);
        double gasVatAmount = gasBill.getVatAmount(gasCost);
        double gasTotalCost = gasBill.calcTotalCost(gasCost, gasVatAmount);

        return new BillingRecord(
                generateBillId(), // Generate a better unique bill Id
                "TEMP_CUSTOMER_ID", // Add appropriate customer Id retrieval logic later
                customerName,
                location,
                LocalDateTime.now(),
                electricStandingCharge,
                electricCost,
                electricVatAmount,
                electricTotalCost,
                gasStandingCharge,
                gasCost,
                gasVatAmount,
                gasTotalCost);
    }

    private String generateBillId() {
        return "BILL" + System.currentTimeMillis();
    }

}
