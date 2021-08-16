import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of customers : ");
        int size = scanner.nextInt();
        scanner.nextLine();
        BillManagement billManagement = new BillManagement(size);
        Bill[] bills = billManagement.getBills();
        for (int i = 0; i < size; i++) {
            bills[i] = billManagement.initBill(scanner);
        }
        runProgram(scanner, billManagement, bills);
    }

    private static void runProgram(Scanner scanner, BillManagement billManagement, Bill[] bills) {
        int choice = -1;
        do {
            menu();
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: {
                    checkOutBill(scanner, billManagement, bills);
                    break;
                }
                case 2: {
                    checkBillInfo(scanner, billManagement, bills);
                    break;
                }
                case 3: {
                    billManagement.addCustommer(scanner);
                    System.out.println("ADDED SUCCESS!\n");
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
                    System.out.println("FALSE !!! PLEASE RE-ENTER\n");
                    break;
                }
            }

        } while (choice != 0);
    }

    private static void checkBillInfo(Scanner scanner, BillManagement billManagement, Bill[] bills) {
        System.out.print("Enter Id home or id meter : ");
        String id = scanner.nextLine();
        if (billManagement.findIndex(id) == -1) {
            System.out.println("CUSTOMER NOT FOUND !!\n");
        } else if (billManagement.findIndex(id) != -1) {
            System.out.println("FIND: " + bills[billManagement.findIndex(id)].toString());
        }
    }

    private static void checkOutBill(Scanner scanner, BillManagement billManagement, Bill[] bills) {
        System.out.print("Enter Id home or id meter : ");
        String id = scanner.nextLine();
        if (billManagement.findIndex(id) == -1) {
            System.out.println("CUSTOMER NOT FOUND !!\n");
        } else if (billManagement.findIndex(id) != -1) {
            System.out.println(bills[billManagement.findIndex(id)].toString());
            System.out.println("TOTAL COST : " + bills[billManagement.findIndex(id)].electricBill() + " VND");
            billManagement.deleteCustomer(id);
        }
    }

    public static void menu() {
        System.out.println("1: Checkout and delete customer");
        System.out.println("2: Check information customer");
        System.out.println("3: Add information customer");
        System.out.println("4: All information customer");
        System.out.println("0: EXit");
    }
}
