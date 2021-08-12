public class Customer {
    private String name;
    private String idHome;
    private String idMeter;

    public Customer() {
    }

    public Customer(String name, String idHome, String idMeter) {
        this.name = name;
        this.idHome = idHome;
        this.idMeter = idMeter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdHome() {
        return idHome;
    }

    public void setIdHome(String idHome) {
        this.idHome = idHome;
    }

    public String getIdMeter() {
        return idMeter;
    }

    public void setIdMeter(String idMeter) {
        this.idMeter = idMeter;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name = '" + name + '\'' +
                ", idHome = " + idHome +
                ", idMeter = " + idMeter +
                '}';
    }
}
