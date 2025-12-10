package billing;

public class GasBill extends IUtility {
    public double calcStandingCharge(double dailyRate, Integer days) {
        return (dailyRate / 100) * days;
    }

}
