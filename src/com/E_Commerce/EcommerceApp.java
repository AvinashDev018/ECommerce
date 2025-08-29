package com.E_Commerce;

import java.util.Scanner;

public class EcommerceApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        ECommercePlatForm platform = new ECommercePlatForm();
        Customer loggedInCustomer = null;

        boolean running = true;
        while (running) {
            System.out.println("\n===== E-Commerce Menu =====");
            System.out.println("1. Add Product (Admin)");
            System.out.println("2. View Products");
            System.out.println("3. Register Customer");
            System.out.println("4. Login Customer");
            System.out.println("5. Add Item to Cart");
            System.out.println("6. View Cart");
            System.out.println("7. Checkout");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    String pid = sc.nextLine();
                    System.out.print("Enter Product Name: ");
                    String pname = sc.nextLine();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Enter Category: ");
                    String category = sc.nextLine();
                    System.out.print("Enter Stock Quantity: ");
                    int stock = sc.nextInt();
                    sc.nextLine();

                    platform.addProd(new Product(pid,pname, price, category, stock));
//                    System.out.println("✅ Product Added.");
                    break;

                case 2:
                    platform.view();
                    break;

                case 3:
                    System.out.print("Enter Customer ID: ");
                    String cid = sc.nextLine();
                    System.out.print("Enter Name: ");
                    String cname = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter Password: ");
                    String pass = sc.nextLine();

                    loggedInCustomer = new Customer(cid, cname, email, pass);
                    platform.registerUser(loggedInCustomer);
//                    System.out.println("✅ Customer Registered.");
                    break;

                case 4:
                    System.out.print("Enter Email: ");
                    String logEmail = sc.nextLine();
                    System.out.print("Enter Password: ");
                    String logPass = sc.nextLine();
                    User u = platform.login(logEmail, logPass);
                    if (u instanceof Customer) {
                        loggedInCustomer = (Customer) u;
                        System.out.println("✅ Login Successful. Welcome " + loggedInCustomer.name);
                    } else {
                        System.out.println("❌ Invalid credentials.");
                    }
                    break;

                case 5:
                    if (loggedInCustomer == null) {
                        System.out.println("⚠ Please login first.");
                        break;
                    }
                    platform.view();
                    System.out.print("Enter Product ID to add: ");
                    String addPid = sc.nextLine();
                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();
                    sc.nextLine();

                    Product p = platform.findProduct(addPid);
                    if (p != null) {
                        loggedInCustomer.getCart().addItems(p,qty);
                        System.out.println("✅ Added to cart.");
                    } else {
                        System.out.println("❌ Product not found.");
                    }
                    break;

                case 6:
                    if (loggedInCustomer != null) {
                        loggedInCustomer.getCart().viewCart();
                    } else {
                        System.out.println("⚠ No customer logged in.");
                    }
                    break;

                case 7:
                    if (loggedInCustomer != null) {
                        System.out.print("Enter Payment Mode (upi/card): ");
                        String mode = sc.nextLine();
                        platform.checkout(loggedInCustomer, mode);
                    } else {
                        System.out.println("⚠ No customer logged in.");
                    }
                    break;

                case 8:
                    running = false;
                    System.out.println("👋 Exiting E-Commerce App. Goodbye!");
                    break;

                default:
                    System.out.println("❌ Invalid choice.");
            }
        }
	}
}
