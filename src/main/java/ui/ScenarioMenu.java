package com.laundry.ui;

import com.laundry.dao.ScenarioDao;
import com.laundry.model.ScenarioEntity;
import java.util.List;
import java.util.Scanner;

public class ScenarioMenu {
    private final ScenarioDao dao = new ScenarioDao();
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        int choice;
        do {
            System.out.println("\n=== LAUNDRY SHOP JOB ORDER SYSTEM ===");
            System.out.println("1. Add Job Order");
            System.out.println("2. View All Job Orders");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Customer Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Weight (kg): ");
                    double weight = scanner.nextDouble();
                    scanner.nextLine(); // consume newline
                    double totalAmount = weight * 50.0; // 50 per kg rate
                    System.out.print("Enter Status (e.g., Pending, Completed): ");
                    String status = scanner.nextLine();

                    dao.addJobOrder(new ScenarioEntity(name, weight, totalAmount, status));
                    System.out.println("Job order added successfully! Total Amount: " + totalAmount);
                    break;
                case 2:
                    List<ScenarioEntity> orders = dao.getAllJobOrders();
                    System.out.println("\n--- Job Orders List ---");
                    for (ScenarioEntity o : orders) {
                        System.out.println("ID: " + o.getId() + " | Name: " + o.getCustomerName() +
                                " | Weight: " + o.getWeightKg() + "kg | Amount: " + o.getTotalAmount() +
                                " | Status: " + o.getStatus());
                    }
                    break;
                case 3:
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 3);
    }
}