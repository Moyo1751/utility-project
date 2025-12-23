package model;

public class MeterReading {
    final double openingElectricDay;
    final double closingElectricDay;
    final double openingElectricNight;
    final double closingElectricNight;

    final double openingGas;
    final double closingGas;

    public MeterReading(double openingElectricDay, double closingElectricDay,
            double openingElectricNight, double closingElectricNight,
            double openingGas, double closingGas) {

        if (closingElectricDay < openingElectricDay) {
            throw new IllegalArgumentException(
                    "Electric day closing reading (" + closingElectricDay +
                            ") must be >= opening reading (" + openingElectricDay + ")");
        }

        if (closingElectricNight < openingElectricNight) {
            throw new IllegalArgumentException(
                    "Electric night closing reading (" + closingElectricNight +
                            ") must be >= opening reading (" + openingElectricNight + ")");
        }

        if (closingGas < openingGas) {
            throw new IllegalArgumentException(
                    "Gas closing reading (" + closingGas +
                            ") must be >= opening reading (" + openingGas + ")");
        }

        this.openingElectricDay = openingElectricDay;
        this.closingElectricDay = closingElectricDay;
        this.openingElectricNight = openingElectricNight;
        this.closingElectricNight = closingElectricNight;
        this.openingGas = openingGas;
        this.closingGas = closingGas;
    }

    public double getOpeningElectricDay() {
        return openingElectricDay;
    }

    public double getClosingElectricDay() {
        return closingElectricDay;
    }

    public double getOpeningElectricNight() {
        return openingElectricNight;
    }

    public double getClosingElectricNight() {
        return closingElectricNight;
    }

    public double getOpeningGas() {
        return openingGas;
    }

    public double getClosingGas() {
        return closingGas;
    }
}
