package billing;

public class Vat {
    private double vat;

    public Vat(String location) {

        switch (location.toUpperCase()) {
            case "US":
                this.vat = 0.15;
                break;
            case "UK":
                this.vat = 0.05;
                break;
            case "FR":
                this.vat = 0.1;
                break;
            case "IT":
                this.vat = 0.2;
                break;
            default:
                this.vat = 0.5; // No VAT for other locations
        }
    }

    public double getVat() {
        return vat;
    }

    // public void setVat(double vat) {
    // this.vat = vat;
    // }

}
