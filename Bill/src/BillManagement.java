import java.util.Scanner;

public class BillManagement {
    private Bill[] bills;

    public BillManagement() {
    }

    public BillManagement(Bill[] bills) {
        this.bills = bills;
    }

    public BillManagement(int size) {
        bills = new Bill[size];
    }

    public Bill[] getBills() {
        return this.bills;
    }

    public void setBills(Bill[] bills) {
        this.bills = bills;
    }

    public Customer initCustomer(Scanner scanner) {
        System.out.print("Full name : ");
        String name = scanner.nextLine();
        System.out.print("Id home : ");
        String idHome = scanner.nextLine();
        System.out.print("Id Electric Meter : ");
        String idMeter = scanner.nextLine();
        return new Customer(name, idHome, idMeter);
    }

    public Bill initBill(Scanner scanner) {
        System.out.println("CUSTOMER INFORMATION");
        Customer customer = initCustomer(scanner);
        System.out.println("ELECTRIC BILL");
        System.out.print("Old index electric : ");
        int oldIndex = scanner.nextInt();
        System.out.print("New index electric : ");
        int newIndex = scanner.nextInt();
        scanner.nextLine();
        return new Bill(customer, oldIndex, newIndex);
    }

    public int findIndex(String id) {
        int index = -1;
        for (int i = 0; i < bills.length; i++) {
            if (this.bills[i].getCustomer().getIdHome().equals(id) || this.bills[i].getCustomer().getIdMeter().equals(id)) {
                index = i;
                break;
            }
            index = -1;
        }
        return index;
    }

    public void deleteCustomer(String id) {
        Bill[] newBills = new Bill[this.bills.length - 1];
        int index = findIndex(id);
        if (index == -1) {
            newBills = this.bills;
        } else {
            for (int i = 0; i < this.bills.length - 1; i++) {
                if (i < index) {
                    newBills[i] = this.bills[i];
                } else {
                    newBills[i] = this.bills[i + 1];
                }
            }
        }
        this.bills = newBills;
    }

    public void addCustommer(Scanner scanner) {
        Bill[] newBills = new Bill[bills.length + 1];
        for (int i = 0; i < bills.length; i++) {
            newBills[i] = this.bills[i];
        }
        System.out.println("NEW CUSTOMER INFORMATION");
        System.out.print("Full name : ");
        String name = scanner.nextLine();
        System.out.print("Id home : ");
        String idHome = scanner.nextLine();
        System.out.print("Id Electric Meter : ");
        String idMeter = scanner.nextLine();
        Customer customer = new Customer(name, idHome, idMeter);
        System.out.println("ELECTRIC BILL");
        System.out.print("Old index electric : ");
        int oldIndex = scanner.nextInt();
        System.out.print("New index electric : ");
        int newIndex = scanner.nextInt();
        scanner.nextLine();
        newBills[bills.length] = new Bill(customer, oldIndex, newIndex);
        this.bills = newBills;
    }
}
