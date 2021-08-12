public class Bill {
    private Customer customer;
    private int oldIndexElectric;
    private int newIndexElectric;

    public Bill() {
    }

    public Bill(Customer customer, int oldIndexElectric, int newIndexElectric) {
        this.customer = customer;
        this.oldIndexElectric = oldIndexElectric;
        this.newIndexElectric = newIndexElectric;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getOldIndexElectric() {
        return oldIndexElectric;
    }

    public void setOldIndexElectric(int oldIndexElectric) {
        this.oldIndexElectric = oldIndexElectric;
    }

    public int getNewIndexElectric() {
        return newIndexElectric;
    }

    public void setNewIndexElectric(int newIndexElectric) {
        this.newIndexElectric = newIndexElectric;
    }

    public int electricBill() {
        return (this.newIndexElectric - this.oldIndexElectric) * 750;
    }

    @Override
    public String toString() {
        return "Bill {" +
                "customer = " + customer +
                ", oldIndexElectric = " + oldIndexElectric +
                ", newIndexElectric = " + newIndexElectric +
                '}' + "\n";
    }
}
