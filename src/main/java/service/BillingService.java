package service;

import model.BillingRecord;
import model.MeterReading;

public interface BillingService {

    BillingRecord generateBill(String customerName, String location, MeterReading readings);
}
