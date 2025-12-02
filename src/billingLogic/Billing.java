package billingLogic;

abstract class Billing implements IUtility {
    public double calcStandingCharge(double dailyRate, Integer days) {
        return (dailyRate / 100) * days;
    }
}
