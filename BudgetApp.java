import java.util.ArrayList;
import java.util.Scanner;

class Transaction {
    private String detail;
    private double cost;

    public Transaction(String detail, double cost) {
        this.detail = detail;
        this.cost = cost;
    }

    public String getDetail() {
        return detail;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Transaction [Detail=" + detail + ", Cost=" + cost + "]";
    }
}

class BudgetManager {
    private ArrayList<Transaction> transactions = new ArrayList<>();

    public void recordTransaction(String detail, double cost) {
        Transaction transaction = new Transaction(detail, cost);
        transactions.add(transaction);
        System.out.println("Transaction recorded successfully!");
    }

    public void showTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions to display.");
        } else {
            for (Transaction transaction : transactions) {
                System.out.println(transaction);
            }
        }
    }

    public void removeTransaction(int index) {
        if (index >= 0 && index < transactions.size()) {
            transactions.remove(index);
            System.out.println("Transaction removed successfully!");
        } else {
            System.out.println("Invalid index. Please try again.");
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (Transaction transaction : transactions) {
            total += transaction.getCost();
        }
        return total;
    }
}

public class BudgetApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BudgetManager manager = new BudgetManager();
        boolean active = true;

        while (active) {
            System.out.println("\nBudget Manager Menu:");
            System.out.println("1. Record Transaction");
            System.out.println("2. View Transactions");
            System.out.println("3. Remove Transaction");
            System.out.println("4. View Total Spent");
            System.out.println("5. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter transaction detail: ");
                    String detail = scanner.nextLine();
                    System.out.print("Enter transaction cost: ");
                    double cost = scanner.nextDouble();
                    manager.recordTransaction(detail, cost);
                    break;
                case 2:
                    manager.showTransactions();
                    break;
                case 3:
                    System.out.print("Enter the index of the transaction to remove: ");
                    int index = scanner.nextInt();
                    manager.removeTransaction(index);
                    break;
                case 4:
                    System.out.println("Total Spent: " + manager.calculateTotal());
                    break;
                case 5:
                    active = false;
                    System.out.println("Exiting Budget Manager...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}
