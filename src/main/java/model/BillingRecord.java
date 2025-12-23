package model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class BillingRecord implements Serializable {
    private final String billId;
    private final String customerId;
    private final String customerName;
    private final String location;
    private final LocalDateTime timestamp;

    private final double electricStandingCharge;
    private final double electricCost;
    private final double electricVatAmount;
    private final double electricTotalCost;

    private final double gasStandingCharge;
    private final double gasCost;
    private final double gasVatAmount;
    private final double gasTotalCost;

    private final double totalAmountDue;

    public BillingRecord(String billId, String customerId, String customerName,
            String location, LocalDateTime timestamp,
            double electricStandingCharge, double electricCost,
            double electricVatAmount, double electricTotalCost,
            double gasStandingCharge, double gasCost,
            double gasVatAmount, double gasTotalCost) {
        this.billId = billId;
        this.customerId = customerId;
        this.customerName = customerName;
        this.location = location;
        this.timestamp = timestamp;

        this.electricStandingCharge = electricStandingCharge;
        this.electricCost = electricCost;
        this.electricVatAmount = electricVatAmount;
        this.electricTotalCost = electricTotalCost;

        this.gasStandingCharge = gasStandingCharge;
        this.gasCost = gasCost;
        this.gasVatAmount = gasVatAmount;
        this.gasTotalCost = gasTotalCost;

        this.totalAmountDue = electricTotalCost + gasTotalCost;
    }

    public String getBillId() {
        return billId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getLocation() {
        return location;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public double getElectricStandingCharge() {
        return electricStandingCharge;
    }

    public double getElectricCost() {
        return electricCost;
    }

    public double getElectricVatAmount() {
        return electricVatAmount;
    }

    public double getElectricTotalCost() {
        return electricTotalCost;
    }

    public double getGasStandingCharge() {
        return gasStandingCharge;
    }

    public double getGasCost() {
        return gasCost;
    }

    public double getGasVatAmount() {
        return gasVatAmount;
    }

    public double getGasTotalCost() {
        return gasTotalCost;
    }

    public double getTotalAmountDue() {
        return totalAmountDue;
    }

    public String formatCost(double cost) {
        return String.format("£%.2f", cost);
    }

    public String getFormattedElectricStandingCharge() {
        return formatCost(electricStandingCharge);
    }

    public String getFormattedElectricCost() {
        return formatCost(electricCost);
    }

    public String getFormattedElectricVatAmount() {
        return formatCost(electricVatAmount);
    }

    public String getFormattedElectricTotalCost() {
        return formatCost(electricTotalCost);
    }

    public String getFormattedGasStandingCharge() {
        return formatCost(gasStandingCharge);
    }

    public String getFormattedGasCost() {
        return formatCost(gasCost);
    }

    public String getFormattedGasVatAmount() {
        return formatCost(gasVatAmount);
    }

    public String getFormattedGasTotalCost() {
        return formatCost(gasTotalCost);
    }

    public String getFormattedTotalAmountDue() {
        return formatCost(totalAmountDue);
    }

    @Override
    public String toString() {
        return "BillingRecord{" +
                "billId='" + billId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", timestamp=" + timestamp +
                ", totalAmountDue=" + formatCost(totalAmountDue) +
                '}';
    }

}
