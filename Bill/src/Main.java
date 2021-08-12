import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter size array : ");
        int size = scanner.nextInt();
        scanner.nextLine();
        BillManagement billManagement = new BillManagement(size);
        Bill[] bills = billManagement.getBills();
        for (int i = 0; i < size; i++) {
            bills[i] = billManagement.initBill(scanner);
        }
        int choice = -1;
        do {
            menu();
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: {
                    System.out.println("Enter Id home or id meter");
                    String id = scanner.nextLine();
                    if (billManagement.findIndex(id) == -1) {
                        System.out.println("Customer not found !!");
                    } else if (billManagement.findIndex(id) != -1) {
                        System.out.println(bills[billManagement.findIndex(id)].toString());
                        System.out.println("Electricity bill payment : " + bills[billManagement.findIndex(id)].electricBill() + "\n");
                        billManagement.deleteCustomer(id);
                    }
                    break;
                }
                case 2: {
                    System.out.println("Enter Id home or id meter");
                    String id = scanner.nextLine();
                    if (billManagement.findIndex(id) == -1) {
                        System.out.println("Customer not found !!");
                    } else if (billManagement.findIndex(id) != -1) {
                        System.out.println("Find : " + bills[billManagement.findIndex(id)].toString());
                    }
                    break;
                }
                case 3: {
                    billManagement.addCustommer(scanner);
                    System.out.println("Add complete!");
                    break;
                }
                case 4: {
                    System.out.println("ALL CUSTOMER : \n" + Arrays.toString(billManagement.getBills()));
                    break;
                }
                case 0: {
                    System.exit(0);
                    break;
                }
                default: {
                    System.out.println("Please re-enter");
                    break;
                }
            }

        } while (choice != 0);
    }
    public static void menu() {
        System.out.println("1: Payment/ Delete customer");
        System.out.println("2: Check information customer");
        System.out.println("3: Add customer");
        System.out.println("4: All customer");
        System.out.println("0: EXit");
    }
}
