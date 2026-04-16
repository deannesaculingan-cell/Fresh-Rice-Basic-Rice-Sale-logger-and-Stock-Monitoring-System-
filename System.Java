package ricestore1222;
import java.util.Scanner;
import java.util.ArrayList;

public class RiceStore1222 {
    
    class Product {
    String name;
    int quantity;
    double price;

    Product(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}


class Sale {
    String productName;
    int quantitySold;
    double totalPrice;

    Sale(String productName, int quantitySold, double totalPrice) {
        this.productName = productName;
        this.quantitySold = quantitySold;
        this.totalPrice = totalPrice;
    }
}


    Scanner sc = new Scanner(System.in);

    static ArrayList<Product> stocks = new ArrayList<>();
    static ArrayList<Sale> sales = new ArrayList<>();

    public static void main(String[] args) {
        new RiceStore1222().run();
    }

    void run() {
        while (true) {
            System.out.println("=====================================");
            System.out.println("            USER SELECTION           ");
            System.out.println("=====================================");

            System.out.println("1. Admin");
            System.out.println("2. Owner");
            System.out.println("3. Exit");

            int choice = getIntRange(1, 3);

            if (choice == 1) adminLogin();
            else if (choice == 2) ownerLogin();
            else return;
        }
    }

    int getIntRange(int min, int max) {
        while (true) {
            System.out.print("\nEnter choice: ");
            String input = sc.nextLine();

            try {
                int num = Integer.parseInt(input);
                if (num >= min && num <= max) return num;
            } catch (Exception e) {}

            System.out.println("\nINVALID INPUT!");
        }
    }

    int getPositiveInt(String label) {
        while (true) {
            System.out.print(label);
            String input = sc.nextLine();

            try {
                int num = Integer.parseInt(input);
                if (num > 0) return num;
            } catch (Exception e) {}

            System.out.println("\nINVALID INPUT!");
        }
    }

    double getPositiveDouble(String label) {
        while (true) {
            System.out.print(label);
            String input = sc.nextLine();

            try {
                double num = Double.parseDouble(input);
                if (num > 0) return num;
            } catch (Exception e) {}

            System.out.println("\nINVALID INPUT!");
        }
    }

    String getValidName() {
        while (true) {
            System.out.print("\nEnter Product Name: ");
            String name = sc.nextLine();

            if (!name.isEmpty() && name.matches("[a-zA-Z ]+")) return name;

            System.out.println("\nINVALID INPUT!");
        }
    }

    void adminLogin() {
        while (true) {
            System.out.print("\nEnter Username: ");
            String user = sc.nextLine();
            System.out.print("Enter Password: ");
            String pass = sc.nextLine();

            if (user.equals("admin") && pass.equals("password")) {
                adminDashboard();
                return;
            } else {
                System.out.println("\nTRY AGAIN!");
                System.out.println("Incorrect Username and Password");
            }
        }
    }

    void ownerLogin() {
        while (true) {
            System.out.print("\nEnter Username: ");
            String user = sc.nextLine();

            System.out.print("Enter Password: ");
            String pass = sc.nextLine();

            if (user.equals("owner") && pass.equals("password")) {
                ownerDashboard();
                return;
            } else {
                System.out.println("\nTRY AGAIN!");
                System.out.println("Incorrect Username and Password");
            }
        }
    }

       void adminDashboard() {
        while (true) {
            System.out.println("\n=====================================");
            System.out.println("           ADMIN DASHBOARD           ");
            System.out.println("=====================================");
            System.out.println("1. Add Stock");
            System.out.println("2. View Stocks");
            System.out.println("3. Update Stock");
            System.out.println("4. Delete Stock");
            System.out.println("5. Add Sale");
            System.out.println("6. Logout");

            int choice = getIntRange(1, 6);

            switch (choice) {
                case 1: addStock(); break;
                case 2: viewStocks(); break;
                case 3: updateStock(); break;
                case 4: deleteStock(); break;
                case 5: addSale(); break;
                case 6: return;
            }
        }
    }

  
    void ownerDashboard() {
        while (true) {
            System.out.println("\n=====================================");
            System.out.println("
