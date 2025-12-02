package billingLogic;

public interface IUtility {
    public double calcStandingCharge();

    public double calcUsage();

    public double calcVat();

    public double calcCost();

    public double calcTotalCost();

    public double formatCost();
}
